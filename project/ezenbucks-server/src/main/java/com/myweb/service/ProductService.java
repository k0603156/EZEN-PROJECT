package com.myweb.service;

import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductService {
	public List<ProductVO> list();
	public ProductVO detail(int product_id);
}
