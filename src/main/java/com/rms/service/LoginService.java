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

package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.dao.StaffDAOImpl;

/**
 * This class helps the {@link ams.com.controller.EntryController} with the login related stuff.
 * 
 * @author GauravAmarnani
 * @version 1.0
 */

@Service
public class LoginService {
	
	/**
	 * Makes connection to database.
	 */
	
	@Autowired
	private StaffDAOImpl staffDAOImpl;
	
	/**
	 * @param username of user.
	 * @return true if user is HOD, false if not.
	 */
	
	public boolean isUserHOD(String username) {
		String authority = staffDAOImpl.getAuthorityByUsername(username);
		return (authority.equals("OWNER")) ? true : false;
	}
}