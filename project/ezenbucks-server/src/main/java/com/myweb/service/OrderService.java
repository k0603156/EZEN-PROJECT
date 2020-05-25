package com.myweb.service;

import java.util.List;

import com.myweb.domain.OrderDetailReq;
import com.myweb.domain.OrderVO;

public interface OrderService {
	public void saveOrder(OrderVO order, List<OrderDetailReq> list) throws Exception;
	public void cancleOrder(int orderId) throws Exception;
	public List<OrderVO> selectOrders() throws Exception;
}
