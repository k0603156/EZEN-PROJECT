package com.myweb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	private int product_id;
	private String product_title;
	private int product_price;
	private String product_species;
}
