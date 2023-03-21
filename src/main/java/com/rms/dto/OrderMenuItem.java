package com.rms.dto;

public class OrderMenuItem {
	
	@SuppressWarnings("unused")
	private String id;
	private String itemName;
	private String itemQuantity;
	private Integer itemPrice;
	private Integer itemNumber = 0;
	
	public String getId() {
		return getItemName() + "-" + getItemQuantity();
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
	
	public Integer getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public OrderMenuItem() { }

	public OrderMenuItem(String id, String itemName, String itemQuantity, Integer itemPrice, Integer itemNumber) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemNumber = itemNumber;
	}
	
	public OrderMenuItem(MenuItem menuItem) {
		id = menuItem.getId();
		itemName = menuItem.getItemName();
		itemQuantity = menuItem.getItemQuantity();
		itemPrice = menuItem.getItemPrice();
	}
	
	public OrderMenuItem(MenuItem menuItem, Integer number) {
		id = menuItem.getId();
		itemName = menuItem.getItemName();
		itemQuantity = menuItem.getItemQuantity();
		itemPrice = menuItem.getItemPrice();
		itemNumber = number;
	}

	@Override
	public String toString() {
		return "OrderMenuItem [id=" + getId() + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", itemPrice="
				+ itemPrice + ", itemNumber=" + itemNumber + "]";
	}
}
