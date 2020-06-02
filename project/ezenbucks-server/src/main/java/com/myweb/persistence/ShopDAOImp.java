package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.domain.ProductVO;
import com.myweb.domain.ShopVO;

@Repository
public class ShopDAOImp implements ShopDAO{
	private static String ns = "ShopMapper.";

	@Inject
	SqlSession sql; 
	
	@Override
	public List<ShopVO> selectList() {
		// TODO Auto-generated method stub
		return sql.selectList(ns + "list");
	}
	
	@Override
	public ShopVO selectOne(String shop_name) {
		// TODO Auto-generated method stub
		return sql.selectOne(ns + "detail", shop_name);
	}

}
