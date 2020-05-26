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
	private int item_id;
	private String item_name;
	private int item_price;
	private String item_species;
	private String item_temp;
}