package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
/** 매장 테이블 데이터 교환을 위한 객체
 * 매장 이름
 * 매장 주소
 * 매장 거리계산(위도,경도)
 */
@Getter
@AllArgsConstructor
public class StoreMapVO {
	private String shopName;
	private String shopAddress;
	private String distance;
}
