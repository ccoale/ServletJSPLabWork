package com.chris;

import javax.persistence.Entity;

@Entity
public class DataRecord {
	private String name;
	private String date;
	private String description;
	private int quantity;
	private double price;
	private int userid;
	private int id;
	
	public DataRecord()
	{		
	}
	
	public DataRecord(String name, String date, String desc, int quant, double price) {
		setName(name);
		setDate(date);
		setDescription(desc);
		setQuantity(quant);
		setPrice(price);
		setUserid(0);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
