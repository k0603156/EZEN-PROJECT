package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeVO {
	private int coffee_id;
	private String coffee_title;
	private int coffee_price;
	private String coffee_temp;
	private String coffee_size;
}
