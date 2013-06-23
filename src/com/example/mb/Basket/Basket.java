package com.example.mb.Basket;

import java.io.Serializable;

public class Basket implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Name;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	
}
