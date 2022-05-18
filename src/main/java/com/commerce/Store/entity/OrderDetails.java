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

	// ---------------------------------

	public OrderDetails() {}

	public OrderDetails(String name, Double price, int quantity, String date) {
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			this.dateOfOrder = date;
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

	public String getDate() {
		return dateOfOrder;
	}

	public void setDate(String date) {
		this.dateOfOrder = date;
	}

}
