package com.myweb.ctrl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.util.LocalAPIHelper;

public class RestAPI {
	private static final Logger log = LoggerFactory.getLogger(RestAPI.class);

	private String getSampleData() {
		//37.5025398,127.0226792
		double y = 37.5025398;
		double x = 127.0226792;
		int radius = 3000;
		int size = 3;
		return LocalAPIHelper.getSampleData("스타벅스", x, y, radius, size); 
	}
	
	@Test
	public void getShopList() throws Exception {
		List<Map<String, String>> list = CustomParser.getShopList(getSampleData());
	}
}
