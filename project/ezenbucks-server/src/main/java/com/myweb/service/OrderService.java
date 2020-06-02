package com.myweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.myweb.domain.OrderVO;
import com.myweb.domain.OrderedItemDTO;

public interface OrderService {
	@Transactional
	int writeOrder(int customer_id, List<Map<String, String>> list, String shop_name);
	
	List<OrderVO> getReceipt(int customer_id); 
	
	List<Map<String, Object>> getOrder_idsByCustomer_id(int customer_id); 
}
