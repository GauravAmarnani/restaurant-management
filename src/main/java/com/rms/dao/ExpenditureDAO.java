package com.rms.dao;

import com.rms.dto.Expenditure;

public interface ExpenditureDAO {
	
	void insertRecordIntoDatabase(Expenditure expenditure, String month);

}
