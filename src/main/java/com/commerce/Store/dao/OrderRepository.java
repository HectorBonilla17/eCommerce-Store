package com.commerce.Store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.Store.entity.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {
	List<OrderDetails> findByAccountId(int id);
}
