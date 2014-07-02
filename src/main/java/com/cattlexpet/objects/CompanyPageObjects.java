package com.cattlexpet.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.uprr.selenium.common.WaitForElements;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;

public class CompanyPageObjects {
	
	@FindBy(linkText = "System Setup")
	private WebElement systemSetup;
	@FindBy(xpath = "//a[contains(text(),'System Setup')]/ancestor::li/descendant::a[contains(text(),'Company')]")
	private WebElement companyLink;
	@FindBy(id = "lnkCompanyInfo")
	private WebElement companyInfoLink;
	@FindBy(id = "txtAddress")
	private WebElement companyInfoAddress;
	@FindBy(id = "txtCity")
	private WebElement companyInfoCity;
	@FindBy(id = "txtEmail")
	private WebElement companyInfoEmail;
	@FindBy(id = "btnSave")
	private WebElement Save;
	@FindBy(id = "lnkAccounting")
	private WebElement accountingLink;
	@FindBy(id = "txtCattleCompany")
	private WebElement accountCompanyID;
	@FindBy(id = "txtFeedyardCompany")
	private WebElement accountingFeedyardCompanyID;
	@FindBy(id = "lnkBenchmarking")
	private WebElement benchmarkingLink;
	@FindBy(id = "txtSourceName")
	private WebElement benchmarkingSourceName;
	@FindBy(id = "txtFeedyardName")
	private WebElement benchmarkingFeedyardName;
	@FindBy(id = "lnkGeneral")
	private WebElement generalInfoLink;
	@FindBy(id = "chkMultiSelect")
	private WebElement generalInfoMultiselectchk;
	@FindBy(id="lnkAddMetric")
	private WebElement metricLink;
	@FindBy(id = "chkCommodities")
	private WebElement metricCommoditieschk;
	@FindBy(id = "chkFeeding")
	private WebElement metricFeedingchk;
	@FindBy(id = "CattleWeights")
	private WebElement metricCattleWeightschk;
	@FindBy(id = "lnkProcess")
	private WebElement processingLink;
	@FindBy(id = "chkanimalSort")
	private WebElement processAnimalRecordsSort;
	@FindBy(id = "btnAddRow")
	private WebElement processAddrow;
	@FindBy(id = "SeqTypeCd")
	private WebElement processSequenceType;
	@FindBy(id = "sData")
	private WebElement processSubmit;
	@FindBy(id = "Number")
	private WebElement processNumber;

	private WebElement saveButton;
	private SeleniumAttributesFactory seleniumAttributes;
	private WaitForElements wait = new WaitForElements();;

	public void companyInfoSave(String CompanyAddress, String companyEmail,
			String Companycity) {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();		
		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Company']"));
		companyLink.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkCompanyInfo"));	
		companyInfoLink.click();
		wait.waitforElementPresence(By.id("txtAddress"));
		companyInfoAddress.clear();
		companyInfoAddress.sendKeys(CompanyAddress);
		companyInfoCity.clear();
		companyInfoCity.sendKeys(Companycity);
		companyInfoEmail.clear();
		companyInfoEmail.sendKeys(companyEmail);
		wait.waitforElementPresence(By.id("btnSave"));
		Save.click();
	}

	public void accountingInfoSave(String Accountcompanyid,
			String FeedyardCompanyID) {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Company"));
		companyLink.click();
		wait.waitforElementPresence(By.id("lnkAccounting"));
		accountingLink.click();
		wait.waitforElementPresence(By.id("txtCattleCompany"));
		accountCompanyID.clear();
		accountCompanyID.sendKeys(Accountcompanyid);
		accountingFeedyardCompanyID.clear();
		accountingFeedyardCompanyID.sendKeys(FeedyardCompanyID);
		wait.waitforElementPresence(By.id("btnSave"));
		Save.click();

	}

	public void benchmarkingInfoSave(String SourceName, String FeedyardName) {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Company"));
		companyLink.click();
		wait.waitforElementPresence(By.id("lnkBenchmarking"));
		benchmarkingLink.click();
		wait.waitforElementPresence(By.id("txtSourceName"));
		benchmarkingSourceName.clear();
		benchmarkingSourceName.sendKeys(SourceName);
		benchmarkingFeedyardName.clear();
		benchmarkingFeedyardName.sendKeys(FeedyardName);
		wait.waitforElementPresence(By.id("btnSave"));
		Save.click();

	}

	public void generalInfoSave() {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		
		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Company']"));
		companyLink.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkGeneral"));	
		generalInfoLink.click();
		wait.waitforElementPresence(By.id("chkMultiSelect"));
		generalInfoMultiselectchk.click();
		Save.click();

	}

	public void metricSave() {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Company']"));
		companyLink.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkAddMetric"));	
		metricLink.click();		
		
		wait.waitforElementPresence(By.id("chkCommodities"));
		metricCommoditieschk.click();
		metricFeedingchk.click();
		metricCattleWeightschk.click();
		wait.waitforElementPresence(By.id("btnSave"));
		Save.click();

	}

	public void processingSave() {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Company']"));
		companyLink.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkProcess"));	
		processingLink.click();
		processAnimalRecordsSort.click();
		Save.click();

	}

	public void processingGridAddButton(String SequenceType, String Number) {
		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Company']"));
		companyLink.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkProcess"));	
		processingLink.click();
		processAddrow.click();
		processSequenceType.sendKeys(SequenceType);
		processNumber.sendKeys(Number);
		processSubmit.click();

	}

	public void setSeleniumAttributes(
			SeleniumAttributesFactory seleniumAttributes) {
		this.seleniumAttributes = seleniumAttributes;
		wait.setSeleniumAttributes(seleniumAttributes);

	}

}
