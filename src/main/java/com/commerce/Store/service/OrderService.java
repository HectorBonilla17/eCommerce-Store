package com.commerce.Store.service;

import java.util.List;

import com.commerce.Store.entity.OrderDetails;
import com.commerce.Store.entity.Product;

public interface OrderService {
	public void createOrderHistoryForCart(List<Product> theProducts, int id, String currentPrincipalName);
	public List<OrderDetails> findByAccountId(int id);
}
