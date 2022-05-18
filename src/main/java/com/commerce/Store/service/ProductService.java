package com.commerce.Store.service;

import java.util.List;

import com.commerce.Store.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findById(int theId);
	public void save(Product theProduct);
	public void deleteById(int theId);
	public void purchaseCart(List<Product> theProducts);
}
