package com.web.automation.automation.testbase;

import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.constants.KeyConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor executor;

	public void launchingWebsite(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		// Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		// PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// Launching the URL
		driver.get(KeyConstants.WEBSITE_URL);
	}

	@BeforeSuite
	public void setUp() {
		launchingWebsite("FireFox");
		PropertyConfigurator.configure(FilePathConstants.LOG_HOME);
	}
}
