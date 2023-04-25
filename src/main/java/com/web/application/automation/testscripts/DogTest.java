package com.web.application.automation.testscripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.automation.automation.page.Basepage;
import com.web.automation.automation.page.DogPage;
import com.web.automation.automation.testbase.BaseClass;

public class DogTest extends BaseClass {

	DogPage dogPage = new DogPage();
	Basepage basepage = new Basepage();

	@Test(dataProvider = "data",dataProviderClass = ExcelUtils.class)
	public void dogSearchText(String animalName) {
		basepage.dogButton(driver);
		dogPage.dogPageTitle(driver);
		basepage.animalsNameList(driver);
		basepage.searchAnimalName(driver, animalName);
	}
}


