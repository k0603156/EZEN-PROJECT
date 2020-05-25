package com.myweb.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.myweb.domain.StoreMapVO;
import com.myweb.exception.ErrorCode;
import com.myweb.exception.RootException;

import lombok.AllArgsConstructor;
/** 외부 api의 데이터를 처리하는 비즈니스 로직
 *  kakao api
 */
@Service
@PropertySource("classpath:application.properties")
public class MapServiceImp implements MapService {
	private static final Logger log = LoggerFactory.getLogger(MapServiceImp.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${map.search.url}")
	private String searchMapUrl;
	
	@Value("${kakao.map.secretKey}")
	private String kakaoSecreyKey;
	
	@Override
	public List<StoreMapVO> arroundStore(String x, String y) {
		ResponseEntity<String> response  = searchMapRequestResult(x, y);
		
		if (response.getStatusCode() == HttpStatus.OK) {
			return storedMapStrConvertToJson(response.getBody(), x, y);
		} else {
			ErrorCode code = ErrorCode.MapRequestError;
			throw new RootException(code.getErrorCode(), code.getMessage());
		}
	}
	
	private ResponseEntity<String> searchMapRequestResult(String x, String y) throws RestClientException {
		int radius = 20000;
		String url = searchMapUrl + "?y=" + y + "&x=" + x + "&radius=" + radius + "&query=스타벅스&sort=distance";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "KakaoAK " + kakaoSecreyKey);
		
		HttpEntity request = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
	}
	
	private List<StoreMapVO> storedMapStrConvertToJson(String json, String oX, String oY) {
		List<StoreMapVO> list = new ArrayList<StoreMapVO>();
		try {
			JsonObject jsonObject = new com.google.gson.JsonParser().parse(json).getAsJsonObject();
			JsonArray array = jsonObject.get("documents").getAsJsonArray();
			for(JsonElement elm : array) {
				String address = elm.getAsJsonObject().get("address_name").getAsString();
				String name = elm.getAsJsonObject().get("place_name").getAsString();
				String x = elm.getAsJsonObject().get("x").getAsString();
				String y = elm.getAsJsonObject().get("y").getAsString();
				
				list.add(new StoreMapVO(name, address, calDistance(oX, oY, x, y)));
			}
			Collections.sort(list, new Comparator<StoreMapVO>() {
				@Override
				public int compare(StoreMapVO o1, StoreMapVO o2) {
					Double d1 = Double.parseDouble(o1.getDistance());
					Double d2 = Double.parseDouble(o2.getDistance());
					
					if(d1 > d2) return 1;
					else if(d1 < d2) return -1;
					else return 0;
				}
			});
		} catch (Exception e) {
			log.error("", e);
		}
		
		return list;
	}
	
	private String calDistance(String oX, String oY, String x, String y) {
		BigDecimal oXb = new BigDecimal(oX);
		BigDecimal oYb = new BigDecimal(oY);
		BigDecimal xB = new BigDecimal(x);
		BigDecimal yB = new BigDecimal(y);
		
		return String.valueOf(distance(oXb.doubleValue(), oYb.doubleValue(), xB.doubleValue(), yB.doubleValue(), "kilometer"));
	}
	
	private double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
         
        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
 
        return (dist);
    }
     
 
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
