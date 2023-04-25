package com.web.application.automation.verify;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * This class contains assert method.
 * 
 * @author arunroshan.r
 *
 */
public class Verify {

	public static final Logger report = Logger.getLogger(Verify.class);
	/**
	 * This method verifies string value whether the actual and excepted result is
	 * true or not.
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 * @return
	 */

	public static boolean verifyString(String actualText, String expectedText, String messageInfo) {
		try {
			Assert.assertEquals(actualText, expectedText);
			report.info(messageInfo + " Pass " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText); 
			return true;
		} catch (AssertionError assertionError) {
			Assert.assertNotEquals(actualText, expectedText);
			report.info(messageInfo + " Fail " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return false;
		}
	}

	/**
	 * This method verifies Boolean whether the actual and excepted result is true
	 * or not.
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 * @return
	 */
	public static boolean verifyBoolean(Boolean actualText, Boolean expectedText, String messageInfo) {
		try {
			Assert.assertEquals(actualText, expectedText);
			report.info(messageInfo + " PASS " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return true;
		} catch (AssertionError assertionError) {
			Assert.assertNotEquals(actualText, expectedText);
			report.info(messageInfo + " FAIL " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return false;
		}
	}

	/**
	 * This method verifies Boolean whether the actual and excepted result is true
	 * or not.
	 * 
	 * @param actualText
	 * @param expectedText
	 * @param messageInfo
	 * @return
	 */
	public static boolean verifyBoolean(WebElement actualText, WebElement expectedText, String messageInfo) {
		try {
			Assert.assertEquals(actualText, expectedText);
			report.info(messageInfo + " PASS " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return true;
		} catch (AssertionError assertionError) {
			Assert.assertNotEquals(actualText, expectedText);
			report.info(messageInfo + " FAIL " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return false;
		}
	}
	public static boolean verifyAsserttrue(Boolean actualText, String expectedText, String messageInfo) {
		try {
			Assert.assertTrue(actualText);
			System.out.println(messageInfo + " Pass " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return true;
		} catch (AssertionError assertionError) {
			Assert.assertFalse(actualText);
			System.out.println(messageInfo + " Fail " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return false;
		}
	}

	public static boolean verifyTrue(Boolean actualText, Boolean expectedText, String messageInfo) {
		try {
			Assert.assertTrue(actualText);
			System.out.println(messageInfo + " PASS " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return true;
		} catch (AssertionError assertionError) {

			System.out.println(messageInfo + " FAIL " + " Actual Result :: " + expectedText + " :: "
					+ " Expected Result :: " + actualText);
			return false;
		}

	}

}