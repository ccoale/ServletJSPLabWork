package com.chris;

public class DataRecord {
	private String _name;
	private String _date;
	private String _description;
	private int _quantity;
	private double _price;
	
	public DataRecord(String name, String date, String desc, int quant, double price) {
		setName(name);
		setDate(date);
		setDescription(desc);
		setQuantity(quant);
		setPrice(price);
	}
	
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getDate() {
		return _date;
	}
	
	public void setDate(String date) {
		_date = date;
	}
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String description) {
		_description = description;
	}
	
	public int getQuantity() {
		return _quantity;
	}
	
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}
	
	public double getPrice() {
		return _price;
	}
	
	public void setPrice(double price) {
		_price = price;
	}
}
