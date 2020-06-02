package com.myweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class LocalAPIHelper {

	public static String getSampleData(String keyword, double x, double y, int radius, int size) {
		String jsonString = new String();
		String buf;
		//보안필요
		String apikey = "9c25e625b496a5f704e44f474a51a7dc";  
		String host = "https://dapi.kakao.com";
		String format = "json"; 
		String strQuery = "?x=" + x + "&y=" + y + "&query=" + URLEncoder.encode(keyword) + "&size=" + size + "&radius=" + radius; 
		String strURL = host + "/v2/local/search/keyword." + format + strQuery;  
		try {
			URL url = new URL(strURL);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			String auth = "KakaoAK " + apikey;
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("User-Agent", "Java-Client");
			//conn.setRequestProperty("X-Requested-With", "curl");
			conn.setRequestProperty("Authorization", auth);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while ((buf = br.readLine()) != null) {
				jsonString += buf;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
}
