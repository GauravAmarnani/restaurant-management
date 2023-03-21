package com.rms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.rms.annotations.Dao;
import com.rms.dto.Bill;
import com.rms.dto.RecordDTO;
import com.rms.utility.SQLUtility;

@Dao
public class BillDAOImpl implements BillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addRecordsIntoTable(String tableName, RecordDTO recordDTO) {
		Object args[] = {recordDTO.getId(), recordDTO.getNumber()};
		jdbcTemplate.update("INSERT INTO " + tableName + " (id, number) VALUES (?, ?)", args[0], args[1]);
	}
	
	public void updateItemRecordsForTable(String table, String item, Integer newValue) {
		
	}

	public ArrayList<RecordDTO> fetchAllItemRecordsFromTable(String tableName) {
		String sql = "SELECT * FROM " + tableName + ";";
		return jdbcTemplate.query(sql, new ResultSetExtractor<ArrayList<RecordDTO>>(){
			public ArrayList<RecordDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<RecordDTO> mapRet= new ArrayList<RecordDTO>();
				while(rs.next())
				    mapRet.add(new RecordDTO(rs.getString(1), rs.getInt(2)));
				return mapRet;
			}
		});
	}
	
	public void insertListOfRecordsIntoDatabase(final ArrayList<RecordDTO> listOfRecord, String tableName) {
		String sql = "UPDATE rms." + tableName + " SET number = ? WHERE id = ?;";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				RecordDTO recordDTO = listOfRecord.get(i);
				ps.setInt(1, recordDTO.getNumber());
				ps.setString(2, recordDTO.getId());
			}

			public int getBatchSize() {
				return listOfRecord.size();
			}
		});
	}
	
	public void storeBill(Bill bill) {
		String sql = SQLUtility.STORE_RECORD;
		Object args[] = {bill.getId(), bill.getMonth(), bill.getDate(), bill.getAmount(), bill.getContent()};
		jdbcTemplate.update(sql, args[0], args[1], args[2], args[3], args[4]);
	}

	public ArrayList<Bill> fetchAllBills() {
		String sql = SQLUtility.FETCH_ALL_BILLS;
		return jdbcTemplate.query(sql, new ResultSetExtractor<ArrayList<Bill>>(){
			
		    public ArrayList<Bill> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        ArrayList<Bill> mapRet= new ArrayList<Bill>();
		        while(rs.next()){
		        	Bill bill = new Bill();
		        	bill.setId(rs.getString(1));
		        	bill.setMonth(rs.getString(2));
		        	bill.setDate(rs.getString(3));
		        	bill.setAmount(rs.getInt(4));
		        	mapRet.add(bill);
		        }
		        return mapRet;
		    }
		});
	}
	
	public ArrayList<Bill> fetchAllBills(String month) {
		String sql = "SELECT * FROM rms.bills WHERE month='" + month +"';";
		return jdbcTemplate.query(sql, new ResultSetExtractor<ArrayList<Bill>>(){
			
		    public ArrayList<Bill> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        ArrayList<Bill> mapRet= new ArrayList<Bill>();
		        while(rs.next()){
		        	Bill bill = new Bill();
		        	bill.setId(rs.getString(1));
		        	bill.setMonth(rs.getString(2));
		        	bill.setDate(rs.getString(3));
		        	bill.setAmount(rs.getInt(4));
		        	mapRet.add(bill);
		        }
		        return mapRet;
		    }
		});
	}

	public String getContentById(String id) {
		String sql = SQLUtility.CONTENT_BY_ID;
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
}
