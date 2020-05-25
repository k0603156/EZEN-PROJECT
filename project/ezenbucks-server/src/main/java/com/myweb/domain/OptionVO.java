package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
/** 
 * ITEM_OPTION TABLE 데이터 교환을 위한 객체
 * 상품 관련 옵션 테이블
 * 상품 옵션(hot,ice,all,none)
 * 사이즈 관련 옵션
 */ 
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionVO {
	private int itemOptionId;
	private int itemOptionTemp;
	private int itemOptionSize;
	
	public void setOptions(int itemOptionTemp, int itempOptionSize) {
		this.itemOptionSize = itempOptionSize;
		this.itemOptionTemp = itemOptionTemp;
	}
}
