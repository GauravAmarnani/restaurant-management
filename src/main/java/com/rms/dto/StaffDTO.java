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

package com.rms.dto;

import org.springframework.stereotype.Component;

/**
 * This is a DTO Class which corresponds to the Database for HOD and Teachers.
 * 
 * @author GauravAmarnani
 * @version 1.0
 */

@Component
public class StaffDTO {

	/**
	 * The following are the variables for Staff Members in the Database.
	 */

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private Boolean enabled;
	private String role;
	
	public StaffDTO() { }
	
	public StaffDTO(Integer id, String username, String email, String phoneNumber) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return id
	 */
	
	public Integer getId() {
		return id;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param id
	 */
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return username
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param username
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return password
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return email
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return phoneNumber
	 */

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param phoneNumber
	 */

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return enabled
	 */

	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param enabled
	 */

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Getter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @return role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter Method to be used by Spring Framework when we use it as a model
	 * object.
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return Object in the String format.
	 */

	@Override
	public String toString() {
		return "StaffDTO [username=" + username + ", password=" + password + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", enable=" + enabled + ", role=" + role + "]";
	}
}
