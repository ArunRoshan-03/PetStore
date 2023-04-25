package com.web.application.automation.testscripts;

import org.testng.annotations.Test;

import com.web.application.automation.dataprovider.ExcelUtils;
import com.web.automation.automation.page.Basepage;
import com.web.automation.automation.page.ReptilesPage;
import com.web.automation.automation.testbase.BaseClass;

public class ReptilesTest extends BaseClass {

	ReptilesPage reptilesPage = new ReptilesPage();
	Basepage basepage = new Basepage();

	@Test(dataProvider = "data", dataProviderClass = ExcelUtils.class)
	public void reptilesSearchText(String animalName) {
		basepage.reptilesButton(driver);
		reptilesPage.reptilesPageTitle(driver);
		basepage.animalsNameList(driver);
		basepage.searchAnimalName(driver, animalName);
	}
}
