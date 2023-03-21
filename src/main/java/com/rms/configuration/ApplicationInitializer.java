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

package com.rms.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ApplicationInitializer Class essentially replaces the web.xml file here.
 * 
 * It has many functionalities such as Initializing the Application by setting
 * the Configuration Class, setting DispatcherServlet Mappings along with many
 * other things like Custom Registration.
 * 
 * @author Gaurav Amarnani
 * @version 1.0
 */

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class[] arr = { ApplicationConfiguration.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arr = { "/" };
		return arr;
	}
}
