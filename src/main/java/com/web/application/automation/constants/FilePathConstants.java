package com.web.application.automation.constants;

/*	
  C:\Users\aruroshan.r\eclipse-workspace\taxi_Application_Automation\src\main\resources\locators\hepl.prop
*/

import java.io.File;

public class FilePathConstants {

	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	public static final String MAIN_HOME = USER_HOME + "src" + File.separator + "main" + File.separator;
	public static final String RESOURCE_HOME = MAIN_HOME + "resources" + File.separator;
	public static final String LOCATORS_HOME = RESOURCE_HOME + "locators" + File.separator;
	public static final String TEST_DATA_HOME = RESOURCE_HOME + "testdata" + File.separator;

	// Logj4 Properties
	public static final String LOG_HOME = RESOURCE_HOME + "log4j" + File.separator + "log4j.properties";

	// Home detail path
	public static final String HOME_PAGE_PATH = LOCATORS_HOME + "homepage.properties";

	// Base page xpath
	public static final String BASE_PAGE_PATH = LOCATORS_HOME + "basepage.properties";

	// Bird page detail path
	public static final String BIRD_PAGE_PATH = LOCATORS_HOME + "birdspage.properties";

	// Cat page detail path
	public static final String CAT_PAGE_PATH = LOCATORS_HOME + "catpage.properties";

	// Dogpage detail path
	public static final String DOG_PAGE_PATH = LOCATORS_HOME + "dogpage.properties";

	// Fish page detail path
	public static final String FISH_PAGE_PATH = LOCATORS_HOME + "fishpage.properties";

	// Reptiles page detail path
	public static final String REPTILES_PAGE_PATH = LOCATORS_HOME + "reptilespage.properties";

	// Excel file path for animal data
	public static final String EXCEL_READER_DATA_PATH = TEST_DATA_HOME + "Animals_data.xlsx";

}
