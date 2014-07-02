package com.cattleexpert.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ch.vorburger.webdriver.reporting.LoggingTestWatchman;

import com.cattlexpet.objects.CompanyPageObjects;
import com.cattlexpet.objects.LoginPageObjects;
import com.uprr.selenium.impl.DefaultEventCaptureImpl;
import com.uprr.selenium.impl.DefaultPageFactoryImpl;
import com.uprr.selenium.impl.DefaultSeleniumAttributesImpl;
import com.uprr.selenium.impl.DriverFactoryImpl;
import com.uprr.selenium.interfaces.DriverFactory;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;
import com.uprr.selenium.interfaces.UIPageFactory;

public class CompanyProcessingInfoSaveTest {

	public DriverFactory factory;
	private SeleniumAttributesFactory seleniumAttributes;
	private UIPageFactory pkrmPageFactory;
	private static final String URL = "http://172.16.11.80/cattlexpert.ui/CompanyInfo.aspx#?menuName=System_Setup#lnk#";

	private LoginPageObjects loginPageObject;

	@Rule
	public MethodRule logRule = new LoggingTestWatchman(
			DriverFactoryImpl.LOG_FILE_WRITER);

	@Before
	public void setUp() {
		/*
		 * System.setProperty("webdriver.ie.driver",
		 * "./src/test/resources/driverfiles/IEDriverServer.exe");
		 */
		factory = DriverFactoryImpl.getInstance();
		WebDriver webDriver = new FirefoxDriver();
		seleniumAttributes = new DefaultSeleniumAttributesImpl(webDriver, URL);
		webDriver = new DefaultEventCaptureImpl(webDriver).captureEevnt(URL,
				true);
		pkrmPageFactory = new DefaultPageFactoryImpl(webDriver);
		webDriver.manage().window().maximize();

		loginPageObject = pkrmPageFactory.getPage(LoginPageObjects.class);
		loginPageObject.setSeleniumAttributes(seleniumAttributes);
	}

	@Test
	public void MetricSave() {

		CompanyPageObjects cattlecompany = pkrmPageFactory
				.getPage(CompanyPageObjects.class);
		cattlecompany.setSeleniumAttributes(seleniumAttributes);
		loginPageObject.userLogin("cattle", "cattle");
		cattlecompany.processingSave();
		cattlecompany.processingGridAddButton("M", "5");
	}

	@After
	public void tearDown() {
		loginPageObject.userLogout();
		seleniumAttributes.getWebDriver().quit();
	}

}
