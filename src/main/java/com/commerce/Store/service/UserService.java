package com.commerce.Store.service;

import java.util.List;

import com.commerce.Store.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(int theId);
	public void save(User theUser);
	public User findByUsername(String name);
}
