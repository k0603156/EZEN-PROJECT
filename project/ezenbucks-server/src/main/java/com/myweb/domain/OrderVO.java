package com.myweb.domain;

import java.util.List;

public class OrderVO {
	ShopVO shop; 
	List<OrderedItemDTO> products; 
	int total;
	String order_date;
	
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ShopVO getShop() {
		return shop;
	}
	public void setShop(ShopVO shop) {
		this.shop = shop;
	}
	public List<OrderedItemDTO> getProducts() {
		return products;
	}
	public void setProducts(List<OrderedItemDTO> products) {
		this.products = products;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		int sum = 0; 
		for(OrderedItemDTO dto : this.products) {
			sum += dto.getSubTotal();
		}
		this.total = sum; 
	} 
}
