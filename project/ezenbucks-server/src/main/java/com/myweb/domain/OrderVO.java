package com.myweb.domain;

import java.time.LocalDate;

import com.myweb.enums.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderVO {
	private int orderId;
	
	private int orderTotalPrice;
	private int orderStatus;
	
	private int shopId;
	private LocalDate orderDatetime;
	
	public static OrderVO newOrder(int orderTotalPrice, int shopId) {
		OrderVO newOrder = new OrderVO();
		newOrder.orderTotalPrice = orderTotalPrice;
		newOrder.orderStatus = OrderStatus.CompletetPayment.ordinal();
		newOrder.shopId = shopId;
		newOrder.orderDatetime = LocalDate.now();
		
		return newOrder;
	}
	
}
