package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductDAO {
	public List<ProductVO> selectList();
	public ProductVO selectOne(int product_id);
}
