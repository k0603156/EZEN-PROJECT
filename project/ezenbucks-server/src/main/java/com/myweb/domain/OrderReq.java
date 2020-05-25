package com.myweb.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * �ֹ����̺�
 * �Ѱ���
 * ����id
 * �ֹ� ���� ����Ʈ
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReq {
	private int orderTotalPrice;
	private int shopId;
	private List<OrderDetailReq> orderDetailReq;
}
