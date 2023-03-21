/*
 * Copyright 2021-2022 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rms.annotations.Dao;
import com.rms.utility.SQLUtility;

/**
 * This is the implementation class of {@link ams.com.dao.StaffDAO}. It provides
 * the concrete methods for the interface connecting with databases and
 * performing some business logic as well.
 * 
 * @author GauravAmarnani
 * @version 1.0
 */

@Dao
public class StaffDAOImpl implements StaffDAO {

	/**
	 * Used to make connection to database and fetch back the results.
	 */

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getAuthorityByUsername(String username) {
		String sql = SQLUtility.AUTHORITY_BY_USERNAME;
		Object[] args = { username };
		String authority = (String) jdbcTemplate.queryForObject(sql, String.class, args);
		return authority;
	}
}