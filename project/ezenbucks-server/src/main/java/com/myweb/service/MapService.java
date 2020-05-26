package com.myweb.service;

import java.math.BigDecimal;
import java.util.List;

import com.myweb.domain.StoreMapVO;

public interface MapService {
	public List<StoreMapVO> arroundStore(String x, String y);
}
