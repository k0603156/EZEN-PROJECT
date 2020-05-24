package com.myweb.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopVO {
	private int shop_id;
	private String shop_name;
	private double shop_latitude;
	private double shop_longitude;

	
}
