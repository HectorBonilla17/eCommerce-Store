package com.commerce.Store.entity;

import java.util.List;

public interface ShoppingCart {
	
	public List<Product> getCart();

	public void addToCart(Product product);
	
	public void removeFromCart(int id);
	
	public String getTotal();
	
	public List<Integer> getProductIds();
}
