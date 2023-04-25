package com.web.application.automation.testscripts;

import org.testng.annotations.Test;

import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.automation.automation.page.Basepage;
import com.web.automation.automation.page.BirdsPage;
import com.web.automation.automation.testbase.BaseClass;

public class BirdsTest extends BaseClass {

	BirdsPage birdsPage = new BirdsPage();
	Basepage basepage = new Basepage();

	@Test(dataProvider = "data", dataProviderClass = ExcelUtils.class)
	public void birdsSearchText(String animalName) {
		basepage.birdsButton(driver);
		birdsPage.birdsPageTitle(driver);
		basepage.animalsNameList(driver);
		basepage.searchAnimalName(driver, animalName);
	}
}
