package com.web.application.automation.testscripts;

import org.testng.annotations.Test;

import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.automation.automation.page.Basepage;
import com.web.automation.automation.page.CatPage;
import com.web.automation.automation.testbase.BaseClass;

public class CatTest extends BaseClass {

	CatPage catPage = new CatPage();
	Basepage basepage = new Basepage();

	@Test(dataProvider = "data", dataProviderClass = ExcelUtils.class)
	public void catSearchText(String animalName) {
		basepage.catButton(driver);
		catPage.catPageTitle(driver);
		basepage.animalsNameList(driver);
		basepage.searchAnimalName(driver, animalName);
	}
}
