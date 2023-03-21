package com.rms.service;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rms.dao.MenuDAOImpl;
import com.rms.dto.MenuItem;

@Service
public class ExcelSheetService {
	
	@Autowired
	private MenuDAOImpl menuDAOImpl;

	public ArrayList<MenuItem> fetchRecordsFromExcelSheet(HSSFSheet worksheet) {
		ArrayList<MenuItem> listOfStudentsFromExcelSheet = new ArrayList<MenuItem>();
		for (int i = 0; i < worksheet.getPhysicalNumberOfRows(); i++) {
			HSSFRow row = worksheet.getRow(i);
			MenuItem staffDTO = new MenuItem();
			staffDTO.setItemName(row.getCell(0).getStringCellValue());
			staffDTO.setItemQuantity(row.getCell(1).getStringCellValue());
			staffDTO.setItemPrice(Integer.valueOf((row.getCell(2).getStringCellValue()).substring(1)));
			listOfStudentsFromExcelSheet.add(staffDTO);
		}
		return listOfStudentsFromExcelSheet;
	}

	public String getErrorMessage(String message) {
		String[] parts = message.split("-");
		return "Problem found at Row No. " + parts[1];
	}
	
	public Boolean checkIfListOfMenuItemsExist(ArrayList<MenuItem> listOfMenuItems) {
		try {
		ArrayList<String> allMenuItemIds = new ArrayList<String>();
		for(MenuItem eachItem : listOfMenuItems) 
			allMenuItemIds.add(eachItem.getId());
		for(int i = 0; i < allMenuItemIds.size(); i++)
			if(menuDAOImpl.checkIfMenuItemExists(allMenuItemIds.get(i))) {
				return true;
			}
		return false; 
		} catch(EmptyResultDataAccessException emptyResultDataAccessException) {
			return false;
		}
	}
	
	public void removeAllMenuItems() {
		menuDAOImpl.removeAllMenuItems();
	}
}
