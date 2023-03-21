package com.rms.dao;

import java.util.ArrayList;

import com.rms.dto.Bill;
import com.rms.dto.RecordDTO;

public interface BillDAO {
	
	void addRecordsIntoTable(String tableName, RecordDTO recordDTO);
	
	ArrayList<RecordDTO> fetchAllItemRecordsFromTable(String tableName);
	
	void updateItemRecordsForTable(String tableName, String item, Integer updatedValue);
	
	void insertListOfRecordsIntoDatabase(ArrayList<RecordDTO> listOfRecord, String tableName);
	
	ArrayList<Bill> fetchAllBills();
	
	String getContentById(String id);
}
