package com.web.automation.automation.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.web.application.automation.action.ElementAction;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.constants.KeyConstants;
import com.web.application.automation.message.ErrorMessages;
import com.web.application.automation.message.VerifyMessages;
import com.web.application.automation.pages.keys.BasePageKeys;
import com.web.application.automation.utility.PropertyFileReader;
import com.web.application.automation.utility.Utility;
import com.web.application.automation.verify.Verify;

import groovyjarjarantlr4.v4.codegen.model.Action;

public class Basepage extends Utility {
	public static final Logger report = Logger.getLogger(Basepage.class);
	PropertyFileReader propertyFileReader;

	public Basepage() {
		propertyFileReader = new PropertyFileReader(FilePathConstants.BASE_PAGE_PATH);
	}

	public void fishButton(WebDriver driver) {
		WebElement fishButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.FISH_LINKTEXT_KEY)));
		ElementAction.waitForElementInteractable(fishButtonXPath);
		ElementAction.clickButton(fishButtonXPath);
	}

	public void birdsButton(WebDriver driver) {
		WebElement birdsButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.BIRDS_LINKTEXT_KEY)));
		ElementAction.waitForElementInteractable(birdsButtonXPath);
		ElementAction.clickButton(birdsButtonXPath);
	}

	public void catButton(WebDriver driver) {
		WebElement catButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.CAT_LINKTEXT_KEY)));
		ElementAction.waitForElementInteractable(catButtonXPath);
		ElementAction.clickButton(catButtonXPath);
	}

	public void reptilesButton(WebDriver driver) {
		WebElement reptilesButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.REPTILES_LINKTEXT_KEY)));
		ElementAction.waitForElementInteractable(reptilesButtonXPath);
		ElementAction.clickButton(reptilesButtonXPath);
	}

	public void dogButton(WebDriver driver) {
		WebElement dogButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.DOG_LINKTEXT_KEY)));
		ElementAction.waitForElementInteractable(dogButtonXPath);
		ElementAction.clickButton(dogButtonXPath);
	}

	public void animalsNameList(WebDriver driver) {
		List<WebElement> amimalsName = driver
				.findElements(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.ANIMAL_NAME_KEY)));
		ElementAction.waitForElementInteractable(amimalsName);
		writeToExcelSheet(driver, "Name", amimalsName, "animal" , FilePathConstants.EXCEL_READER_DATA_PATH);
	}

	public void searchAnimalName(WebDriver driver, String animalName) {
		WebElement searchTextBoxXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.SEARCH_BOX_KEY)));
		searchTextBoxXPath.clear();
		ElementAction.TextBox(searchTextBoxXPath, animalName);
		WebElement searchBoxXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.SEARCH_BUTTON_KEY)));
		ElementAction.clickButton(searchBoxXPath);

		WebElement animalNamesXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.SEARCHING_ANIMALS_KEY)));
		String pageTitle = ElementAction.Element_text(animalNamesXPath);

		boolean status = Verify.verifyString(pageTitle, pageTitle,
				VerifyMessages.VERIFY_ANIMAL_LIST_MESSAGE);
		if (status != status) {
			report.error(ErrorMessages.NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);

		}
		WebElement backButtonXPath = driver
				.findElement(By.xpath(propertyFileReader.getPropertyValue(BasePageKeys.RETURN_TO_BACK_BUTTON_KEY)));
		ElementAction.clickButton(backButtonXPath);
	}
}
