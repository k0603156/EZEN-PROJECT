package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.domain.ProductVO;
import com.myweb.domain.ShopVO;
import com.myweb.persistence.ShopDAO;

@Service
public class ShopServiceImp implements ShopService{
	@Inject
	ShopDAO dao; 
	
	@Override
	public List<ShopVO> list() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}
	
	@Override
	public ShopVO detail(String shop_name) {
		// TODO Auto-generated method stub
		return dao.selectOne(shop_name);
	}
	
}
