package com.myweb.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomParser {

	public static List<Map<String, String>> getShopList(String sampleData) throws Exception {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper(); 
		
		Map<String, Object> map = mapper.readValue(sampleData, Map.class);
		List<Map<String, String>> list = (List<Map<String, String>>) map.get("documents");
		List<Map<String, String>> rList = new ArrayList<Map<String,String>>(); 
		for(Map<String, String> item : list) {
			Map<String, String> m = new HashMap<String, String>(); 
			m.put("place_name", item.get("place_name"));
			m.put("address_name", item.get("address_name"));
			m.put("distance", item.get("distance"));
			rList.add(m); 
		}
		return rList; 
	}
}
