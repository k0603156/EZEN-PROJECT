package com.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.domain.OptionVO;
import com.myweb.domain.OrderDetailReq;
import com.myweb.domain.OrderDetailVO;
import com.myweb.domain.OrderVO;
import com.myweb.enums.OrderStatus;
import com.myweb.exception.RootException;
import com.myweb.persistence.OrderDAO;
import com.myweb.persistence.ItemDAO;
/** 주문에 대한 비즈니스 로직 처리
 * 
 */
@Service
public class OrderServiceImp implements OrderService{
	
	@Autowired
	private OrderDAO orderDAOImp;
	
	@Autowired
	private ItemDAO productionDAOImp;
	
	@Override
	@Transactional
	public void saveOrder(OrderVO order, List<OrderDetailReq> list) throws Exception {
		if(order.getOrderStatus() != OrderStatus.CompletetPayment.ordinal()) {
			throw new RootException();
		}
		
		int optionId = -1;
		orderDAOImp.save(order);
		for(OrderDetailReq detail : list) {
			if(detail.getItmeOptionTemp() !=0) {
				OptionVO option = new OptionVO();
				option.setOptions(detail.getItmeOptionTemp(), detail.getItemOptionSize());
				productionDAOImp.insertOption(option);
				optionId = option.getItemOptionId();
			}
			
			OrderDetailVO orderDetail = OrderDetailVO.create(detail.getItemId(), optionId, order.getOrderId(), detail.getOrderDetailCount());
			orderDAOImp.saveOrderDetail(orderDetail);
		}
	}
	
	@Override
	public void cancleOrder(int orderId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<OrderVO> selectOrders() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
