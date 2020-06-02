package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.domain.OrderedItemDTO;

@Repository
public class OrderDAOImp implements OrderDAO{
	private static String ns = "OrderMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int writeOne(Integer customer_id, String shop_name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("customer_id", customer_id); 
		map.put("shop_name", shop_name);
		return sql.insert(ns + "writeOrders", map);
	}

	@Override
	public int selectOne() {
		// TODO Auto-generated method stub
		int result = sql.selectOne(ns + "readMaxId");
		return result;
	}

	@Override
	public int writeOne(int order_id, int product_id, int product_opt_id, int quantity) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("order_id", order_id);
		map.put("product_id", product_id);
		map.put("product_opt_id", product_opt_id);
		map.put("quantity", quantity);
		
		return sql.insert(ns + "writeOrderDetails", map);
	}

	@Override
	public List<OrderedItemDTO> selectList(int order_id, int customer_id) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("order_id", order_id);
		map.put("customer_id", customer_id);
		return sql.selectList(ns + "OrderedList", map);
	}

	@Override
	public List<Map<String, Object>> getOrder_idsByCustomer_id(int customer_id) {
		// TODO Auto-generated method stub
		return sql.selectList(ns + "getOrder_idsByCustomer_id", customer_id);
	}
	
}
