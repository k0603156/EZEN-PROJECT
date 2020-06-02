package com.myweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.domain.OrderVO;
import com.myweb.domain.OrderedItemDTO;
import com.myweb.domain.ShopVO;
import com.myweb.persistence.OrderDAO;
import com.myweb.persistence.ShopDAO;

@Service
public class OrderServiceImp implements OrderService{
	
	@Inject
	OrderDAO odao;
	
	@Inject
	ShopDAO sdao;
	
	@Override
	public int writeOrder(int customer_id, List<Map<String, String>> list, String shop_name) {
		// TODO Auto-generated method stub
		odao.writeOne(customer_id, shop_name); 
		int maxId = odao.selectOne();
		
		for(Map<String, String> map : list) {
			odao.writeOne(maxId, Integer.parseInt(map.get("product_id")), Integer.parseInt(map.get("product_opt_id")), Integer.parseInt(map.get("quantity")));
		}
		 
		return 0;
	}


	@Override
	public List<OrderVO> getReceipt(int customer_id) {
		// TODO Auto-generated method stub
		List<OrderVO> ovList = new ArrayList<OrderVO>(); 
		List<Map<String, Object>> osList = getOrder_idsByCustomer_id(customer_id);
		for(Map<String, Object> map : osList) {
			ShopVO svo = sdao.selectOne((String)map.get("shop_name"));
			List<OrderedItemDTO>list = odao.selectList((Integer)map.get("order_id"), customer_id); 
			OrderVO ovo = new OrderVO(); 
			ovo.setShop(svo);
			ovo.setProducts(list);
			ovo.setTotal();
			ovo.setOrder_date((String)map.get("order_date"));
			ovList.add(ovo); 
		}
		
		return ovList;
	}

	@Override
	public List<Map<String, Object>> getOrder_idsByCustomer_id(int customer_id) {
		// TODO Auto-generated method stub
		return odao.getOrder_idsByCustomer_id(customer_id);
	}
	
}
