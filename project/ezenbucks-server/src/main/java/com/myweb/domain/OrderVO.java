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
	private int coffee_id;
	private int food_id;
	private int shop_id;
	private Date order_date;
	private int order_total;
	private char order_status;
	
}
