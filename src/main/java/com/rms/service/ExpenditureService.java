package com.rms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.BillDAOImpl;
import com.rms.dao.ExpenditureDAOImpl;
import com.rms.dao.MenuDAOImpl;
import com.rms.dto.Bill;
import com.rms.dto.Expenditure;
import com.rms.dto.RecordDTO;

@Service
public class ExpenditureService {
	
	@Autowired
	private ExpenditureDAOImpl expenditureDAOImpl;
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private BillDAOImpl billDAOImpl;
	
	@Autowired
	private MenuDAOImpl menuDAOImpl;
	
	public Double calculateTotalAmount(String expenditures) {
		Double total = 0.0;
		String eachExpenditure[] = expenditures.split(",");
		for(int i = 0; i < eachExpenditure.length; i++) {
			String each[] = eachExpenditure[i].split(":");
			total += Double.valueOf(each[1]);
		}
		return total;
	}
	
	public void storeIntoDatabase(Expenditure expenditure) {
		expenditureDAOImpl.insertRecordIntoDatabase(expenditure, billService.getTableName());
	}
	
	public String getProfitLossStatement() {
		Double amount = expenditureDAOImpl.getAmountForMonth("march_2022");
		amount = amount - (2 * amount);
		Integer temp = 0;
		StringBuffer string = new StringBuffer();
		ArrayList<Bill> listOfBills = billDAOImpl.fetchAllBills("march_2022");
		String value = "";
		for(int i = 0; i < listOfBills.size(); i++) {
			if(i <= 9) {
				int newI = i+1;
				value = "0" + newI;
			}
			else {
				value = i+1 + "";
			}
			if(listOfBills.get(i).getDate().equals(value)) {
				Bill eachBill = listOfBills.get(i);
				temp = eachBill.getAmount();
				amount += temp;
				string.append(eachBill.getDate() + " March : " + temp + " sales. Total Profit. (" + amount + ").\n");
			}
		}
		return new String(string);
	}
	
	public List<RecordDTO> fetchAllRecordsFromTable(String month) {
		return menuDAOImpl.fetchAllItemsForMonth(month);
	}
}
