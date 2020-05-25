package com.myweb.domain;

import java.time.LocalDate;

import com.myweb.enums.OrderStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/** 
 * 주문테이블 데이터 교환을 위한 객체
 * 주문 총 가격
 * 주문 상태
 * 매장 id
 * 주문 시간
 */
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
