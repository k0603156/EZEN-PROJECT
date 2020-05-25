package com.myweb.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
	private int order_id;
	private int order_detail_id;
	private int order_total_price;
	private Date order_datetime;
	private char order_status;
}
