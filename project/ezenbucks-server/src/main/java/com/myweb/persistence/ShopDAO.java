package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.ProductVO;
import com.myweb.domain.ShopVO;

public interface ShopDAO {
	public List<ShopVO> selectList();
	public ShopVO selectOne(String shop_name);
}
