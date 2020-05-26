package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/** 
 * Item table 데이터 교환을 위한 객체
 * 상품 테이블
 * 상품 이름
 * 상품 가격
 * 상품 구분(coffee, food)
 * 상품 옵션(hot,ice,all,none)
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVO {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemSpecies;
	private String itemTemp;
}