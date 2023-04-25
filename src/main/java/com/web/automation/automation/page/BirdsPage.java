package com.web.automation.automation.page;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.web.application.automation.action.ElementAction;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.constants.KeyConstants;
import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.application.automation.message.ErrorMessages;
import com.web.application.automation.message.VerifyMessages;
import com.web.application.automation.pages.keys.BasePageKeys;
import com.web.application.automation.pages.keys.BirdsPageKeys;
import com.web.application.automation.pages.keys.FishPageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.verify.Verify;

public class BirdsPage extends Basepage {

	public static final Logger report = Logger.getLogger(BirdsPage.class);
	PropertyFileReader propertyFileReader, propertyFileReaders;

	public BirdsPage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.BIRD_PAGE_PATH);
		propertyFileReaders = new PropertyFileReader(FilePathConstants.BASE_PAGE_PATH);
	}

	public void birdsPageTitle(WebDriver driver) {
		WebElement birdTextXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BirdsPageKeys.BIRDS_PAGE_TITLE_KEY)));
		ElementAction.waitForElementInteractable(birdTextXPath);
		String birdName = ElementAction.Element_text(birdTextXPath);

		boolean status = Verify.verifyString(birdName, birdName, VerifyMessages.VERIFY_BIRDS_PAGE_MESSAGE);

		if (status != true) {
			report.error(ErrorMessages.NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
		}
	}
}
