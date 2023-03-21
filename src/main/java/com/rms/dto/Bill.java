package com.rms.dto;

import java.util.Random;

public class Bill {
	
	private String displayId;
	private String id;
	private String month;
	private String date;
	private Integer amount;
	private String content;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDisplayId() {
		return displayId;
	}

	public void setDisplayId(String displayId) {
		this.displayId = displayId;
	}

	public Bill() { }
	
	public Bill(String userId, String month, String date, Integer amount) {
		id = "Bill" + generateRandom() + "_" + userId;
		this.month = month;
		this.date = date;
		this.amount = amount;
	}
	
	public Bill(String userId, String month, String date, Integer amount, String content) {
		id = "Bill" + generateRandom() + "_" + userId;
		this.month = month;
		this.date = date;
		this.amount = amount;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", month=" + month + ", date=" + date + ", amount=" + amount + "\ncontent=" + content + "]";
	}
	
	public int generateRandom() {
		Random rnd = new Random();
        return rnd.nextInt(99999);
	}
}
