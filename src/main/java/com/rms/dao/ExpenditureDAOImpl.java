package com.rms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rms.annotations.Dao;
import com.rms.dto.Expenditure;
import com.rms.utility.SQLUtility;

@Dao
public class ExpenditureDAOImpl implements ExpenditureDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertRecordIntoDatabase(Expenditure expenditure, String month) {
		String sql = SQLUtility.STORE_EXPENDITURE;
		Object args[] = {month, expenditure.getAllExpenditures(), expenditure.getTotal()};
		jdbcTemplate.update(sql, args[0], args[1], args[2]);
	}
	
	public Double getAmountForMonth(String month) {
		String sql = SQLUtility.FETCH_AMOUNT_FOR_MONTH;
		return jdbcTemplate.queryForObject(sql, Double.class, month);
	}
}