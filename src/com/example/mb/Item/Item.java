package com.example.mb.Item;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private Integer price;

//-----------------------------Getters and Setters 	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}


		
}
