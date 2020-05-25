package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
/**
 * 
 * Request ���� ó���ϱ� ���� Ŭ����
 *
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailReq {
	private int itemId;
	private int orderDetailCount;
	private int itmeOptionTemp;
	private int itemOptionSize;
}
