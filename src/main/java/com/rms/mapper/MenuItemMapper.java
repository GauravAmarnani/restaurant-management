package com.rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rms.dto.MenuItem;

public class MenuItemMapper implements RowMapper<MenuItem>{

	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem menuItem = new MenuItem();
		menuItem.setId(rs.getString(1));
        menuItem.setItemName(rs.getString(2));
        menuItem.setItemQuantity(rs.getString(3));
        menuItem.setItemPrice(rs.getInt(4));
		return menuItem;
	}
}
