package com.web.automation.automation.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.web.application.automation.action.ElementAction;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.message.ErrorMessages;
import com.web.application.automation.message.VerifyMessages;
import com.web.application.automation.pages.keys.FishPageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.verify.Verify;

public class FishPage {

	public static final Logger report = Logger.getLogger(FishPage.class);
	PropertyFileReader propertyFileReader;

	public FishPage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.FISH_PAGE_PATH);
	}

	public void fishPageTitle(WebDriver driver) {
		WebElement fishButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(FishPageKeys.FISH_PAGE_TITLE_KEY)));
		String fishName = ElementAction.Element_text(fishButtonXPath);

		boolean status= Verify.verifyString(fishName, fishName, VerifyMessages.VERIFY_FISH_PAGE_MESSAGE);
		if (status != true) {
			report.error(ErrorMessages.NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
		}
	}
}
