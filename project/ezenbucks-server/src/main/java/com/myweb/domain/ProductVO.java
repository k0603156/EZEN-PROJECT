package com.myweb.domain;

public class ProductVO {
	int product_id; 
	String product_name;
	int unit_price; 
	String product_species;
	String temp_opt; 
	String size_opt; 
	
	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_name=" + product_name + ", unit_price=" + unit_price
				+ ", product_species=" + product_species + ", temp_opt=" + temp_opt + ", size_opt=" + size_opt + "]";
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public String getProduct_species() {
		return product_species;
	}
	public void setProduct_species(String product_species) {
		this.product_species = product_species;
	}
	public String getTemp_opt() {
		return temp_opt;
	}
	public void setTemp_opt(String temp_opt) {
		this.temp_opt = temp_opt;
	}
	public String getSize_opt() {
		return size_opt;
	}
	public void setSize_opt(String size_opt) {
		this.size_opt = size_opt;
	}
	
}
