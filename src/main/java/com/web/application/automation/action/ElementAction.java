package com.web.application.automation.action;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.automation.automation.testbase.BaseClass;

/**
 * This class contains different reusable methods for UI elements
 */
public class ElementAction extends BaseClass {
	/**
	 * Check whether the web element is present or not
	 *
	 * @return true or false
	 */

	public static boolean isElementPresent(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Web element is not present");
		} catch (NullPointerException exception) {
			System.out.println("Web element is null");
		}
		return false;
	}

	/**
	 * Check whether the web element is selected or not
	 *
	 * @return true or false
	 */
	public static boolean isElementSelected(WebElement element) {

		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the web element is Enabled or not
	 *
	 * @return true or false
	 */
	public static boolean isElementEnabled(WebElement element) {
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method used to get actual page title of web page
	 *
	 * @return Current page title
	 */
	public static String getPageTitle() {

		return driver.getTitle();
	}

	/**
	 * Check whether the web element is present or not Sending the value for text
	 * box
	 */
	public static void TextBox(WebElement element, String Value) {

		try {
			if (isElementPresent(element)) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				element.sendKeys(Value);

			}
		} catch (NoSuchElementException noSuchElementException) {
			System.out.println("Elements is not present");
		}
	}

	/**
	 * Check whether the web element is selected or not Clicking web elements
	 */
	public static void clickButton(WebElement element) {

		executor = (JavascriptExecutor) driver;
		try {
			if (!isElementSelected(element)) {
				element.click();
			} else {
				System.out.println("WebElement is already selected");
			}
		} catch (ElementClickInterceptedException exception) {
			executor.executeScript("arguments[0].click();", element);
		} catch (StaleElementReferenceException exception) {
			System.out.println("Web page get refreshed");
		}
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements counts
	 */
	public static int Elements_Count(List<WebElement> element) {

		return element.size();
	}

	/**
	 * Getting web element Handling alert popups Accepts alert
	 */
	public static void alert_Accept(WebElement element) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException exception) {
			System.out.println("No such alert is present");
		}
	}

	/**
	 * Getting web element Handling alert popups Cancelling the alert
	 */
	public static void alert_Dismiss(WebElement element) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException exception) {

			System.out.println("No such alert is present");
		}
	}

	/**
	 * Getting web element Check whether the web element is present or not
	 *
	 * @return Web elements text
	 */
	public static String Element_text(WebElement element) {

		if (isElementPresent(element)) {
			System.out.println(element.getText());
			return element.getText();
		} else {
			return null;
		}
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements text
	 */
	public static String Elements_text(List<WebElement> elements) {
		StringBuilder builder = new StringBuilder();
		for (WebElement element : elements) {
			builder.append(element.getText());
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * Getting list of web elements
	 *
	 * @return list of web elements text
	 */
	public static List<String> Elements_text1(List<WebElement> elements) {

		List<String> stringList = new ArrayList<>();
		for (WebElement element : elements) {
			stringList.add(element.getText());
		}
		return stringList;
	}

	/**
	 * This Method is used to take screenshot when exception occurs It stores image
	 * in file and png format.
	 */
	public static void screenShot(WebDriver driver, String filepath) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(filepath);

		try {
			FileHandler.copy(source, file);
		} catch (IOException e) {
			System.out.println("Image is not captured");
		}
	}

	/**
	 * This method is used to check whether element is interactable or not
	 */
	public static void waitForElementInteractable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException exception) {
			System.out.println("Element is not clickable");
		}

	}

	/**
	 * This method is used to check whether element is interactable or not
	 */
	public static void waitForElementInteractable(List<WebElement> element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfAllElements(element));
		} catch (TimeoutException exception) {
			System.out.println("Element is not clickable");
		}

	}
	public static void moveToTheElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
	}
}
