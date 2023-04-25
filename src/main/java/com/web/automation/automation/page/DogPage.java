package com.web.automation.automation.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.web.application.automation.action.ElementAction;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.message.ErrorMessages;
import com.web.application.automation.message.VerifyMessages;
import com.web.application.automation.pages.keys.DogPageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.verify.Verify;

public class DogPage {

	public static final Logger report = Logger.getLogger(DogPage.class);
	PropertyFileReader propertyFileReader;

	public DogPage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.DOG_PAGE_PATH);
	}

	public void dogPageTitle(WebDriver driver) {
		WebElement dogTextXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(DogPageKeys.DOG_PAGE_TITLE_KEY)));
		ElementAction.waitForElementInteractable(dogTextXPath);
		ElementAction.Element_text(dogTextXPath);

//		boolean status= Verify.verifyBoolean(dogTextXPath.isDisplayed(),true ,
//				VerifyMessages.VERIFY_DOG_PAGE_MESSAGE);
//		if (status != true) {
//			report.error(ErrorMessages.NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
//		}
	}
}
