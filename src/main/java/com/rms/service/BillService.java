package com.rms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.BillDAOImpl;
import com.rms.dao.MenuDAOImpl;
import com.rms.dto.Bill;
import com.rms.dto.MenuItem;
import com.rms.dto.OrderMenuItem;
import com.rms.dto.RecordDTO;
import com.rms.dto.User;

@Service
public class BillService {
	
	@Autowired
	private BillDAOImpl billDAOImpl;
	
	@Autowired
	private MenuDAOImpl menuDAOImpl;
	
	public HashMap<String, Integer> getNumberOfEachItemOrdered(List<OrderMenuItem> listOfOrderMenuItem) {
		HashMap<String, Integer> eachItemDetails = new HashMap<String, Integer>();
		if(listOfOrderMenuItem != null) 
			for(OrderMenuItem eachItem: listOfOrderMenuItem) 
				eachItemDetails.put(eachItem.getId(), eachItem.getItemNumber());
		return eachItemDetails;
	}
	
	public String getTableName() {
		Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getAlphabeticalMonth(cal.get(Calendar.MONTH) + 1) + "_" + cal.getWeekYear();
	}
	
	private String getAlphabeticalMonth(int month) {
        HashMap<Integer, String> alphabeticalMonth = new HashMap<Integer, String>();
        alphabeticalMonth.put(1, "january");
        alphabeticalMonth.put(2, "february");
        alphabeticalMonth.put(3, "march");
        alphabeticalMonth.put(4, "april");
        alphabeticalMonth.put(5, "may");
        alphabeticalMonth.put(6, "june");
        alphabeticalMonth.put(7, "july");
        alphabeticalMonth.put(8, "august");
        alphabeticalMonth.put(9, "september");
        alphabeticalMonth.put(10, "october");
        alphabeticalMonth.put(11, "november");
        alphabeticalMonth.put(12, "december");
        return alphabeticalMonth.get(month);
    }
	
	public HashMap<String, Integer> getListOfAllItemsFromTable() {
		HashMap<String, Integer> myHashMap = new HashMap<String, Integer>();
		List<RecordDTO> listOfRecordDTO = billDAOImpl.fetchAllItemRecordsFromTable(getTableName());
		for(RecordDTO eachRecord : listOfRecordDTO) {
			myHashMap.put(eachRecord.getId(), eachRecord.getNumber());
		}
		return myHashMap;
	}
	
	public void populateTables(String tableName) {
		List<MenuItem> listOfMenuItem = menuDAOImpl.fetchAllItems();
		for(MenuItem eachItem: listOfMenuItem) {
			RecordDTO recordDTO = new RecordDTO(eachItem.getId(), 0);
			billDAOImpl.addRecordsIntoTable(tableName, recordDTO);
		}
	}
	
	public HashMap<String, Integer> updateNumberOfItem(List<OrderMenuItem> listOfOrderMenuItem) {
		HashMap<String, Integer> allItems = getListOfAllItemsFromTable();
		HashMap<String, Integer> orderedItems = getNumberOfEachItemOrdered(listOfOrderMenuItem);
		for(String eachKey : orderedItems.keySet()) {
			if(allItems.containsKey(eachKey)) {
				allItems.replace(eachKey, (allItems.get(eachKey) + orderedItems.get(eachKey)));
			}
			else {
				allItems.put(eachKey, orderedItems.get(eachKey));
			}
		}
		return allItems;
	}
	
	public void storeIntoTable(HashMap<String, Integer> updatedRecords) {
		ArrayList<RecordDTO> listOfRecord = new ArrayList<RecordDTO>();
		for (Map.Entry<String, Integer> pair : updatedRecords.entrySet()) {
		    RecordDTO recordDTO = new RecordDTO(pair.getKey(), pair.getValue());
		    listOfRecord.add(recordDTO);
		}
		billDAOImpl.insertListOfRecordsIntoDatabase(listOfRecord, getTableName());
	}
	
	public Integer generateAmount(List<OrderMenuItem> listOfOrderMenuItem) {
		Integer sum = 0;
		for(OrderMenuItem eachItem : listOfOrderMenuItem) 
			sum += eachItem.getItemNumber() * eachItem.getItemPrice();
		return sum;
	}
	
	public String generateDate() {
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd");  
	    return myDateObj.format(myFormatObj);
	}
	
	public String generateFormatOfItems(List<OrderMenuItem> listOfOrderMenuItem) {
		StringBuffer formattedItems = new StringBuffer();
		for(OrderMenuItem eachItem : listOfOrderMenuItem) {
			int sum = eachItem.getItemNumber() * eachItem.getItemPrice();
			formattedItems.append(eachItem.getItemName() + "             " + eachItem.getItemQuantity() + "             " + eachItem.getItemPrice() + " * " + eachItem.getItemNumber() + " = " + sum + ".\n");
		}
			
		return new String(formattedItems);
	}
	
	public Bill generateBill(List<OrderMenuItem> listOfOrderMenuItem, User user) {
		Integer amount = generateAmount(listOfOrderMenuItem);
		Integer gst = (amount * 5 / 100);
		Integer newAmount = (gst * 2) + amount;
		String month = getTableName();
		String formattedDate = generateDate();
		Bill bill = new Bill(user.getId(), month, formattedDate, newAmount);
		String listOfItems = generateFormatOfItems(listOfOrderMenuItem);
		String myBill = "WELCOME TO INDIA RESTAURANT!\nBill No: " + bill.getId() + "\nCustomer Name: " + user.getName() + "\nItems: \n" + listOfItems + "Total : " + amount + "\nGST : " + gst + "\nCGST : " + gst + "\nGrand Total : " + newAmount + "\nTHANKYOU FOR VISITING!\nHAVE A GOOD DAY.";
		bill.setContent(myBill);
		return bill;
	}
	
	public void storeIntoTable(Bill bill) {
		billDAOImpl.storeBill(bill);
	}
	
	public List<String> getListOfAllBillIdsAlongWithMonthAndDateAndAmount() {
		ArrayList<Bill> listOfBills = billDAOImpl.fetchAllBills();
		ArrayList<String> list = new ArrayList<String>();
		for(Bill eachBill : listOfBills) 
			list.add(new String(eachBill.getId() + " - " + eachBill.getMonth() + " - " + eachBill.getDate() + " - " + eachBill.getAmount()));
		return list;
	}
	
	public String getContentFromDatabase(String tempId) {
		String[] args = tempId.split(" - ");
		return billDAOImpl.getContentById(args[0]);
	}
}
