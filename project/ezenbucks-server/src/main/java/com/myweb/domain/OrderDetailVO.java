package com.myweb.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {
	private int orderDetailId;
	private int itemId;
	private int itemOptionId;
	private int orderId;
	private int orderDetailCount;
	private LocalDate orderDetailDatetime;
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public static OrderDetailVO create(int itemId, int itemOptionId, int orderId, int orderDetailCount) {
		OrderDetailVO order = new OrderDetailVO();
		order.itemId = itemId;
		if(itemOptionId >= 0)
			order.itemOptionId = itemOptionId;
		order.orderId = orderId;
		order.orderDetailCount = orderDetailCount;
		order.orderDetailDatetime = LocalDate.now();
		
		return order;
	}
}
