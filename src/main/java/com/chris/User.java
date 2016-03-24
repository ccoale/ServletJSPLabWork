package com.chris;

public class User {
	private String _name;
	private String _email;
	
	
	public User(String name, String email) {
		setName(name);
		setEmail(email);
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setEmail(String email) {
		_email = email;
	}
	
	public String getEmail() {
		return _email;
	}

}
