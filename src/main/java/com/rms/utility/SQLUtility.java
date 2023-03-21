/*
 * Copyright 2021-2022 Gaurav Amarnani.
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

package com.rms.utility;

import com.rms.annotations.Utility;

/**
 * This class contains SQL Queries which are used by DAO Classes after
 * connecting to database.
 * 
 * @author GauravAmarnani
 * @version 1.0
 */

@Utility
public class SQLUtility {

	public static final String AUTHORITY_BY_USERNAME = "SELECT role FROM rms.users WHERE username = ?;";
	
	public static final String ADD_LIST_OF_MENU_ITEMS = "INSERT INTO rms.menuitems (id, itemName, itemQuantity, itemPrice) VALUES (?, ?, ?, ?);";
	
	public static final String CHECK_IF_MENU_ITEM_EXISTS = "SELECT itemName FROM rms.menuitems WHERE id = ?;";
	
	public static final String TRUNCATE_MENU_ITEMS = "TRUNCATE TABLE rms.menuitems;";
	
	public static final String FETCH_ALL_ITEMS = "SELECT * FROM rms.menuitems;";
	
	public static final String FETCH_ITEM_WITH_ID = "SELECT * FROM rms.menuitems WHERE id = ?;";
	
	public static final String STORE_RECORD = "INSERT INTO rms.bills (id, month, date, amount, content) VALUES (?, ?, ?, ?, ?);";

	public static final String FETCH_ALL_BILLS = "SELECT * FROM rms.bills;";
	
	public static final String CONTENT_BY_ID = "SELECT content FROM rms.bills WHERE id = ?;";
	
	public static final String STORE_EXPENDITURE = "INSERT INTO rms.expenditure (month, expenditurelist, amount) VALUES (?, ?, ?);";

	public static final String FETCH_AMOUNT_FOR_MONTH = "SELECT amount FROM rms.expenditure WHERE month = ?;";
}