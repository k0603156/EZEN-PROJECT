package com.myweb.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
	private int cart_id;
	private int product_id;
	private int cart_count;
	private String temp;
	private String size;
	
}
