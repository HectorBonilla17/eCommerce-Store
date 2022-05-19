package com.commerce.Store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.Store.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String name);
}
