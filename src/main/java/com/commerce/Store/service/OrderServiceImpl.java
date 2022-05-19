package com.commerce.Store.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.Store.dao.OrderRepository;
import com.commerce.Store.entity.OrderDetails;
import com.commerce.Store.entity.Product;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository theOrderRepository;

	@Override
	public void createOrderHistoryForCart(List<Product> theProducts, int id, String currentPrincipalName) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
		for (Product product : theProducts) {
			OrderDetails order;
			if(id < 1) {
				order = new OrderDetails(product.getName(), product.getPrice(), product.getQuantity(), dtf.format(LocalDateTime.now()), currentPrincipalName);			
			} else {
				order = new OrderDetails(product.getName(), product.getPrice(), product.getQuantity(), dtf.format(LocalDateTime.now()), id, currentPrincipalName);			
			}
			
			theOrderRepository.save(order);
		}
	}

	@Override
	public List<OrderDetails> findByAccountId(int id) {
		return theOrderRepository.findByAccountId(id);
	}
}
