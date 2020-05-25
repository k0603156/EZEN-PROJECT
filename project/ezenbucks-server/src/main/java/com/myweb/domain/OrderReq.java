package com.myweb.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 주문테이블
 * 총가격
 * 매장id
 * 주문 내역 리스트
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReq {
	private int orderTotalPrice;
	private int shopId;
	private List<OrderDetailReq> orderDetailReq;
}
