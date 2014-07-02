package com.cattle.login;

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

import com.cattlexpet.objects.LoginPageObjects;
import com.uprr.selenium.impl.DefaultEventCaptureImpl;
import com.uprr.selenium.impl.DefaultPageFactoryImpl;
import com.uprr.selenium.impl.DefaultSeleniumAttributesImpl;
import com.uprr.selenium.impl.DriverFactoryImpl;
import com.uprr.selenium.interfaces.DriverFactory;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;
import com.uprr.selenium.interfaces.UIPageFactory;
import com.pkrm.datadriven.*;

public class LoginTest {

	public DriverFactory factory;
	protected SeleniumAttributesFactory seleniumAttributes;
	protected UIPageFactory pkrmPageFactory;
	private static final String URL = "http://172.16.11.235/cattlexpert.ui/CompanyInfo.aspx#?";

	private LoginPageObjects loginPageObject;
	public ExcelReader reader;
	public List<Map<String, String>> data;

	@Rule
	public MethodRule logRule = new LoggingTestWatchman(
			DriverFactoryImpl.LOG_FILE_WRITER);

	@Before
	public void setUp() {

		factory = DriverFactoryImpl.getInstance();
		WebDriver webDriver = new FirefoxDriver();
		seleniumAttributes = new DefaultSeleniumAttributesImpl(webDriver, URL);
		webDriver = new DefaultEventCaptureImpl(webDriver).captureEevnt(URL,
				true);
	webDriver.manage().window().maximize();
		pkrmPageFactory = new DefaultPageFactoryImpl(webDriver);
		loginPageObject = pkrmPageFactory.getPage(LoginPageObjects.class);

		reader = new ExcelReader();
		reader.setTestData("Sheet1",
				".\\src\\main\\resources\\datasheets\\Login.xls");

		data = reader.readData();
	}

	
	public void loginTest() {

		for (Map<String, String> entry : data) {

			loginPageObject.setSeleniumAttributes(seleniumAttributes);
			loginPageObject.userLogin(entry.get("UserName".toUpperCase()),
					entry.get("Password".toUpperCase()));
		}
		

	}

	@After
	public void tearDown() {
		loginPageObject.userLogout();
		seleniumAttributes.getWebDriver().quit();
	}
}
