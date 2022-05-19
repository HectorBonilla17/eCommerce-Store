package com.commerce.Store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_history")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private Double price;

	private int quantity;
	
	private String dateOfOrder;
	
	private Integer accountId;
	
	private String username;

	// ---------------------------------

	public OrderDetails() {}
	
	public OrderDetails(String name, Double price, int quantity, String date, String username) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.dateOfOrder = date;
		this.username = username;
}

	public OrderDetails(String name, Double price, int quantity, String date, int accountId, String username) {
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			this.dateOfOrder = date;
			this.accountId = accountId;
			this.username = username;
	}

	// ---------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(String dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
