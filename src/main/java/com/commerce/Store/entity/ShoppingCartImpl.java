package com.commerce.Store.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ShoppingCartImpl implements ShoppingCart {

	private List<Product> cart = new ArrayList();

	public List<Product> getCart() {
		return cart;
	}

	public void addToCart(Product product) {
		
		boolean state = true;
		for (Product tempProduct : cart) {
			if(product.getId() == tempProduct.getId()) {
				cart.set(cart.indexOf(tempProduct), product);
				state = false;
			}
		}
		
		if(state) {
			cart.add(product);
		}
	}
	
	public void removeFromCart(int id) {
		cart.removeIf(name -> name.getId() == id);
	}

	@Override
	public String getTotal() {
		double total = 0.00;
		for (Product product : cart) {
			total += (product.getPrice() * product.getQuantity());
		}
		
		return "Cart Total: $" + String. format("%.2f", total);
	}
	
	public List<Integer> getProductIds() {
		List<Integer> cartProductIds = new ArrayList();
		
		for(Product cartProduct: cart) {
			cartProductIds.add(cartProduct.getId());
		}
		
		return cartProductIds;
	}
	
	public boolean compareQuantity(Product product) {
		
		if(product.getQuantity() == 0) {
			return true;
		}
		
		Product temp = cart.stream().filter(current -> product.getId() == current.getId()).findAny().orElse(null);
		
		if(temp != null) {
			if(product.getQuantity() < temp.getQuantity()) {
				return true;
			} else {
				return false;
			}	
		}
		
		return false;
	}
}
