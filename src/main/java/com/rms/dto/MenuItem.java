package com.rms.dto;

public class MenuItem {
	
	@SuppressWarnings("unused")
	public String id;
	private String itemName;
	private String itemQuantity;
	private Integer itemPrice;
	
	public String getId() {
		return itemName+"-"+itemQuantity;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemQuantity() {
		return itemQuantity;
	}
	
	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public Integer getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public MenuItem() { }
	
	public MenuItem(String id, String itemName, String itemQuantity, Integer itemPrice) {
		this.id = id;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}
	
	public MenuItem(String itemName, String itemQuantity, Integer itemPrice) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "ID = " + id + ", Name=" + itemName + ", Quantity=" + itemQuantity + ", Price=" + itemPrice + ".";
	}
}
