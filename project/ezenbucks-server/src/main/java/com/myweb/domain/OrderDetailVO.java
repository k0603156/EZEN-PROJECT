package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {
	private int order_detail_id;
	private int item_id;
	private int item_option_id;
	private int shop_id;
}
