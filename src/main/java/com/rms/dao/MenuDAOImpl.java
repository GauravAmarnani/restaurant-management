package com.rms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.rms.annotations.Dao;
import com.rms.dto.MenuItem;
import com.rms.dto.RecordDTO;
import com.rms.mapper.MenuItemMapper;
import com.rms.utility.SQLUtility;

@Dao
public class MenuDAOImpl implements MenuDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertListOfRecordsIntoDatabase(final ArrayList<MenuItem> listOfMenuItems) {
		String sql = SQLUtility.ADD_LIST_OF_MENU_ITEMS;
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				MenuItem menuItem = listOfMenuItems.get(i);
				ps.setString(1, menuItem.getId());
				ps.setString(2, menuItem.getItemName());
				ps.setString(3, menuItem.getItemQuantity());
				ps.setInt(4, menuItem.getItemPrice());
			}

			public int getBatchSize() {
				return listOfMenuItems.size();
			}
		});
	}

	public Boolean checkIfMenuItemExists(String id) {
		String sql = SQLUtility.CHECK_IF_MENU_ITEM_EXISTS;
		Object[] args = { id };
		String name = (String) jdbcTemplate.queryForObject(
	            sql, args, String.class);
		return !(name.isBlank());
	}

	public void removeAllMenuItems() {
		String sql = SQLUtility.TRUNCATE_MENU_ITEMS;
		jdbcTemplate.execute(sql);
	}
	
	public List<MenuItem> fetchAllItems() {
		String sql = SQLUtility.FETCH_ALL_ITEMS;
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<MenuItem>>(){
			
		    public List<MenuItem> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        ArrayList<MenuItem> mapRet= new ArrayList<MenuItem>();
		        while(rs.next()){
		        	mapRet.add(new MenuItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		        }
		        return mapRet;
		    }
		});
	}

	public MenuItem getItemById(String id) {
		String sql = SQLUtility.FETCH_ITEM_WITH_ID;
		return jdbcTemplate.queryForObject(sql, new MenuItemMapper(), id);
	}
	
	public List<RecordDTO> fetchAllItemsForMonth(String tableName) {
		String sql = "SELECT * FROM rms." + tableName + ";";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<RecordDTO>>(){
					
				    public List<RecordDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				        ArrayList<RecordDTO> mapRet= new ArrayList<RecordDTO>();
				        while(rs.next()){
				        	mapRet.add(new RecordDTO(rs.getString(1), rs.getInt(2)));
				        }
				        return mapRet;
				    }
				});
	}
}
