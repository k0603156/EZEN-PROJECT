package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.ProductVO;

@Repository
public class ProductDAOImp implements ProductDAO{
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImp.class);
	private static String ns = "ProductMapper.";
	
	@Inject
	private SqlSession sql;

	@Override
	public List<ProductVO> selectList() {
		// TODO Auto-generated method stub
		return sql.selectList(ns + "list");
	}

	@Override
	public ProductVO selectOne(int product_id) {
		// TODO Auto-generated method stub
		return sql.selectOne(ns + "detail", product_id);
	}
}
