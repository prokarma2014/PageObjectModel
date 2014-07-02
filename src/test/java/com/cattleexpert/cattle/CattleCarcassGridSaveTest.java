package com.cattleexpert.cattle;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ch.vorburger.webdriver.reporting.LoggingTestWatchman;









import com.cattle.login.LoginTest;
import com.cattlexpet.objects.CattlePageObjects;
import com.cattlexpet.objects.CompanyPageObjects;
import com.cattlexpet.objects.LoginPageObjects;
import com.pkrm.datadriven.ExcelReader;
import com.uprr.selenium.impl.DefaultEventCaptureImpl;
import com.uprr.selenium.impl.DefaultPageFactoryImpl;
import com.uprr.selenium.impl.DefaultSeleniumAttributesImpl;
import com.uprr.selenium.impl.DriverFactoryImpl;
import com.uprr.selenium.interfaces.DriverFactory;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;
import com.uprr.selenium.interfaces.UIPageFactory;

public class CattleCarcassGridSaveTest  extends LoginTest{

	ExcelReader carCassDataReader;
	public List<Map<String, String>> CarCassdata;
	
	@Rule
	public MethodRule logRule = new LoggingTestWatchman(
			DriverFactoryImpl.LOG_FILE_WRITER);

	@Before
	public void setUp() {
	super.setUp();
	carCassDataReader = new ExcelReader();
	carCassDataReader.setTestData("Sheet1", "Success","C:\\Users\\rchunduri\\cattleexpert\\cattleexpert-sanity\\src\\main\\resources\\datasheets\\CarCass.xls" );
	CarCassdata=carCassDataReader.readData();
	
	}
	
	@Test
	public void carcassGridSaveTest() throws InterruptedException {

		CattlePageObjects carcassGridPageObject = pkrmPageFactory
				.getPage(CattlePageObjects.class);
		carcassGridPageObject.setSeleniumAttributes(seleniumAttributes);
		loginTest();
//		carcassGridPageObject.saveCarcass("carcassgrid1", "cg1");
		for (Map<String, String> entry : CarCassdata) {
			System.out.println(entry.get("CarCass".toUpperCase()));
			carcassGridPageObject.saveCarcass(entry.get("CarCass".toUpperCase()), entry.get("Name".toUpperCase()));
			
			
		}

	}

	@After
	public void tearDown() {
	super.tearDown();
	}
}
