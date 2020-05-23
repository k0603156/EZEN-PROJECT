package com.myweb.domain;

public class FoodVO {
	private int food_id;
	private String food_title;
	private int food_price;

	public FoodVO() {

	}

	public FoodVO(int food_id, String food_title, int food_price) {
		this.food_id = food_id;
		this.food_title = food_title;
		this.food_price = food_price;
	}
}