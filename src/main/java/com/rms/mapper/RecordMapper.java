package com.rms.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rms.dto.RecordDTO;

public class RecordMapper implements RowMapper<RecordDTO>{

	public RecordDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RecordDTO recordDTO = new RecordDTO();
		recordDTO.setId(rs.getString(1));
		recordDTO.setNumber(rs.getInt(2));
		return recordDTO;
	}
	
}