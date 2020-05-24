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
	private int item_id;
	private int item_option_id;
	private int shop_id;
	private int order_count;
	private Date order_datetime;
	private int order_total_price;
	private char order_status;
}
