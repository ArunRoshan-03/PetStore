package com.web.automation.automation.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.web.application.automation.action.ElementAction;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.constants.KeyConstants;
import com.web.application.automation.message.ErrorMessages;
import com.web.application.automation.message.VerifyMessages;
import com.web.application.automation.pages.keys.FishPageKeys;
import com.web.application.automation.pages.keys.ReptilesPageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.verify.Verify;

public class ReptilesPage {

	public static final Logger report = Logger.getLogger(ReptilesPage.class);
	PropertyFileReader propertyFileReader;

	public ReptilesPage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.REPTILES_PAGE_PATH);
	}

	public void reptilesPageTitle(WebDriver driver) {
		WebElement reptilesTextXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(ReptilesPageKeys.REPTILES_PAGE_TITLE_KEY)));
		ElementAction.waitForElementInteractable(reptilesTextXPath);
		ElementAction.Element_text(reptilesTextXPath);
	}
}
