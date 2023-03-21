package com.rms.dto;

import java.util.Random;

public class User {
	
	private String id;
	private String name;
	
	public String getId() {
		return getName().replace(" ", "") + generateRandom();
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public User() { }
	
	public User(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	public int generateRandom() {
		Random rnd = new Random();
        return rnd.nextInt(99999);
	}
	
}
