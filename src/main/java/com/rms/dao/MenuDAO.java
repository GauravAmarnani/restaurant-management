package com.rms.dao;

import java.util.ArrayList;

import com.rms.dto.MenuItem;

public interface MenuDAO {
	
	void removeAllMenuItems();
	
	Boolean checkIfMenuItemExists(String id);
	
	void insertListOfRecordsIntoDatabase(ArrayList<MenuItem> listOfMenuItems);
	
	MenuItem getItemById(String id);
}
