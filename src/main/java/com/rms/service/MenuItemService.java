package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.MenuDAOImpl;
import com.rms.dto.MenuItem;
import com.rms.dto.OrderMenuItem;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuDAOImpl menuDAOImpl;
	
	public List<MenuItem> fetchAllItems() {
		return menuDAOImpl.fetchAllItems();
	}
	
	public ArrayList<OrderMenuItem> convertMenuItemToOrderMenuItem(List<MenuItem> listOfMenuItems) {
		ArrayList<OrderMenuItem> listOfOrderMenuItems = new ArrayList<OrderMenuItem>();
		for(MenuItem eachMenuItem : listOfMenuItems) {
			OrderMenuItem orderMenuItem = new OrderMenuItem();
			orderMenuItem.setId(eachMenuItem.getId());
			orderMenuItem.setItemName(eachMenuItem.getItemName());
			orderMenuItem.setItemQuantity(eachMenuItem.getItemQuantity());
			orderMenuItem.setItemPrice(eachMenuItem.getItemPrice());
			orderMenuItem.setItemNumber(0);
			listOfOrderMenuItems.add(orderMenuItem);
		}
		return listOfOrderMenuItems;
	}
	
	public List<String> getListOfAllMenuItemIds() {
		List<MenuItem> listOfMenuItem = menuDAOImpl.fetchAllItems();
		List<String> listOfAllMenuItemIds = new ArrayList<String>();
		for(MenuItem eachItem: listOfMenuItem) 
			listOfAllMenuItemIds.add(eachItem.getId());
		return listOfAllMenuItemIds;
	}
	
	public MenuItem getMenuItemById(String id) {
		return menuDAOImpl.getItemById(id);
	}
}
