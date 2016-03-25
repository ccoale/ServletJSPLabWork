package com.chris;

public class User {
	private String name;
	private String email;
	private int id;
	
	
	public User(String name, String email) {
		setName(name);
		setEmail(email);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
