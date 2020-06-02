package com.myweb.service;

import java.util.List;

import com.myweb.domain.ProductVO;
import com.myweb.domain.ShopVO;

public interface ShopService {
	public List<ShopVO> list();
	public ShopVO detail(String shop_name);
}
