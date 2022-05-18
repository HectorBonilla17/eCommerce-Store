package com.commerce.Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.Store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
