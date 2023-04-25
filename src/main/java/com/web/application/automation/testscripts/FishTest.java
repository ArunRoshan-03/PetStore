package com.web.application.automation.testscripts;

import org.testng.annotations.Test;
import com.web.application.automation.constants.FilePathConstants;
import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.automation.automation.page.Basepage;
import com.web.automation.automation.page.FishPage;
import com.web.automation.automation.testbase.BaseClass;

public class FishTest extends BaseClass {

	FishPage fishPage = new FishPage();
	Basepage basepage = new Basepage();

	@Test(dataProvider = "data", dataProviderClass = ExcelUtils.class)
	public void fishSearchText(String animalname) {
		basepage.fishButton(driver);
		fishPage.fishPageTitle(driver);
		basepage.animalsNameList(driver);
		basepage.searchAnimalName(driver, animalname);
	}
}
