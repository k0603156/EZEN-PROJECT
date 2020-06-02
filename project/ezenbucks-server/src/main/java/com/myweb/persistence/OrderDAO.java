package com.myweb.persistence;

import java.util.List;
import java.util.Map;

import com.myweb.domain.OrderedItemDTO;

public interface OrderDAO {
	//order
	int writeOne(Integer customer_id, String shop_name);
	//max id
	int selectOne();
	// oder detail
	int writeOne(int order_id, int product_id, int product_opt_id, int quantity);
	List<OrderedItemDTO> selectList(int order_id, int customer_id);
	List<Map<String, Object>> getOrder_idsByCustomer_id(int customer_id); 
}
