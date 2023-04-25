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
import com.web.application.automation.pages.keys.CatPageKeys;
import com.web.application.automation.pages.keys.FishPageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.verify.Verify;

public class CatPage {

	public static final Logger report = Logger.getLogger(CatPage.class);
	PropertyFileReader propertyFileReader;

	public CatPage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.CAT_PAGE_PATH);
	}

	public void catPageTitle(WebDriver driver) {
		WebElement catTextXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(CatPageKeys.CAT_PAGE_TITLE_KEY)));
//		boolean result = driver
//				.findElement(By.xpath(propertyFileReader.getPropertyValue(CatPageKeys.CAT_PAGE_TITLE_KEY)))
//				.isDisplayed();
		ElementAction.Element_text(catTextXPath);

		boolean status = Verify.verifyTrue(catTextXPath.isDisplayed(), true, VerifyMessages.VERIFY_CAT_PAGE_MESSAGE);
		if (status != true) {
			report.error(ErrorMessages.NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
		}
	}
}
