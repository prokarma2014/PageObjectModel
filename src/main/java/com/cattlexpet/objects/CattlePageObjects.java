package com.cattlexpet.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.uprr.selenium.common.WaitForElements;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;

public class CattlePageObjects {

	// public WebDriver driver = new FirefoxDriver();
	@FindBy(id = "txtUserName")
	private WebElement userName;
	@FindBy(id = "txtPassword")
	private WebElement password;
	@FindBy(id = "btnLogin")
	private WebElement login;
	@FindBy(linkText = "System Setup")
	private WebElement systemSetup;
	@FindBy(xpath = "//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Cattle']")
	private WebElement cattle;
	@FindBy(id = "lnkBreed")
	private WebElement breed;
	@FindBy(xpath = "//a[@id='lnkNewBreedInfo']/span[2]")
	private WebElement newBreed;
	@FindBy(xpath = "//li/ul/li[2]/span")
	private WebElement description;
	@FindBy(id = "txtCode")
	private WebElement breedShortName;
	@FindBy(xpath = "//input[@id='ddlAdgFactor']")
	private WebElement adgfactor;
	@FindBy(id = "btnSave")
	private WebElement save;
	@FindBy(css = "td[title=Dexter]")
	private WebElement desctable;
	
	// Cattle -> Base Weight

	@FindBy(id = "lnkCattleBaseWeight")
	private WebElement cattleBaseWeight;
	@FindBy(xpath = "//a[@id='lnkCattleBaseWeight']/span[2]")
	private WebElement cattleNewBaseWeight;
	@FindBy(id = "txtBaseWeight")
	private WebElement baseWeight;
	@FindBy(id = "txtDeliverPrice")
	private WebElement deliveryPricePerCWT;
	@FindBy(id = "txtInEffective")
	private WebElement inEffect;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement baseWeighttable;

	// Cattle --> Carcass

	@FindBy(id = "lnkCarcassGrid")
	private WebElement carcassGrid;
	@FindBy(xpath = "//a[@id='lnkNewGrid']/span[2]")
	private WebElement newCarcass;
	// @FindBy(xpath ="//li/ul/li[2]/span")
	// private WebElement carcassGridDesc;
	@FindBy(id = "txtGridDescrition")
	private WebElement carcassGridDescription;
	@FindBy(id = "txtCGShortName")
	private WebElement carcassGridShortName;
	@FindBy(id = "btnCarcassGridSave")
	private WebElement carcassGridSave;

	// Cattle --> EstimatedADG Save

	@FindBy(id = "lnkEstimatedAverageDailyGain")
	private WebElement estimatedADG;
	@FindBy(xpath = "//a[@id='lnkNew']/span[2]")
	private WebElement newEstimatedADG;
	@FindBy(id = "txtEstimatedADG")
	private WebElement setEstimatedADG;
	@FindBy(id = "txtWeightMin")
	private WebElement weightMin;
	@FindBy(id = "txtWeightMax")
	private WebElement weightMax;
	@FindBy(id = "ddlGender")
	private WebElement gender;
	@FindBy(id = "ddlBreed")
	private WebElement estmdADGbreed;
	@FindBy(id = "ddlLocation")
	private WebElement estmdADGlocation;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement genderTable;

	// Cattle --> Flesh
	@FindBy(id = "lnkFlesh")
	private WebElement cattleFlesh;
	@FindBy(xpath = "//a[@id='lnkNewFleshInfo']/span[2]")
	private WebElement cattleNewFlesh;
	@FindBy(id = "txtFleshDesc")
	private WebElement fleshDescription;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement fleshDescTable;
	@FindBy(id = "txtFleshShortName")
	private WebElement fleshShortName;
	@FindBy(id = "txtADGFactor")
	private WebElement fleshADG;

	// Cattle --> Gender

	@FindBy(id = "lnkGender")
	private WebElement cattleGender;
	@FindBy(id = "lnkNewGenderInfo")
	private WebElement cattlenewGender;
	@FindBy(id = "txtGenderDesc")
	private WebElement genderDescription;
	@FindBy(id = "txtGenderShortName")
	private WebElement genderShortName;
	@FindBy(id = "txtADGFactor")
	private WebElement genderADGFactor;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement genderDescTable;

	// Cattle --> Places

	@FindBy(id = "lnkPlaces")
	private WebElement cattlePlaces;
	@FindBy(id = "lnkNewPlaceInfo")
	private WebElement cattleNewPlaces;
	@FindBy(id = "txtPlaceDescription")
	private WebElement cattlePlaceDesc;
	@FindBy(id = "txtPlaceShortName")
	private WebElement cattlePlaceShortName;
	@FindBy(id = "ddlCountryPlace")
	private WebElement cattleCountryPlace;

	// Cattle --> Projection Defaults

	@FindBy(id = "lnkProjectDefaults")
	private WebElement cattleProjectionDefaults;
	@FindBy(id = "lnkProjectionDefault")
	private WebElement cattleNewProjectionDefault;
	@FindBy(id = "ddlelement")
	private WebElement defaultDescription;
	@FindBy(id = "txtElementValue")
	private WebElement projectionDefaultShortName;
	@FindBy(id = "txtStartMonth")
	private WebElement startMonth;
	@FindBy(id = "txtEndMonth")
	private WebElement endMonth;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement projectionDefaultDescTable;

	// Cattle --> Seasonal ADG

	@FindBy(id = "lnkSeasonADG")
	private WebElement cattleSeasonalADG;
	// @FindBy(xpath ="//tr[2]/td")
	// private WebElement seasonADGMonthTable;
	@FindBy(id = "lnkNewSeasonAdgInfo")
	private WebElement newSeasonAdgInfo;
	@FindBy(id = "ddlSeasonAdgMonth")
	private WebElement ADGMonth;
	@FindBy(id = "txtSeasonAdgFactor")
	private WebElement ADGFactor;

	private SeleniumAttributesFactory seleniumAttributes;
	private WaitForElements wait = new WaitForElements();;

	public void breedSelection(String lcldescription, String shortname,
			String ADGFactor) throws InterruptedException {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkBreed"));
		breed.click();
		wait.waitforElementPresence(By
				.xpath("//a[@id='lnkNewBreedInfo']/span[2]"));
		newBreed.click();
		// wait.waitforElementPresence(By.cssSelector("td[title=Dexter]"));
		// desctable.click();
		wait.waitforElementPresence(By.xpath("//li/ul/li[2]/span"));
		description.sendKeys(lcldescription);
		breedShortName.sendKeys(shortname);
		adgfactor.sendKeys(ADGFactor);
		save.click();
	}

	public void saveCattleBaseWeight(String basewt, String DelPricePerCWT,
			String date) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkCattleBaseWeight"));
		cattleBaseWeight.click();
		wait.waitforElementPresence(By
				.xpath("//a[@id='lnkCattleBaseWeight']/span[2]"));
		cattleNewBaseWeight.click();
		wait.waitforElementPresence(By.id("txtBaseWeight"));
		baseWeight.sendKeys(basewt);
		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// baseWeighttable.click();
		// wait.waitforElementPresence(By.id("txtDeliverPrice"));
		deliveryPricePerCWT.sendKeys(DelPricePerCWT);
		inEffect.sendKeys(date);
		save.click();
	}

	public void saveCarcass(String description, String CGShName) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkCarcassGrid"));
		carcassGrid.click();
		wait.waitforElementPresence(By.xpath("//a[@id='lnkNewGrid']/span[2]"));
		newCarcass.click();
		wait.waitforElementPresence(By.id("txtGridDescrition"));
		carcassGridDescription.sendKeys("description");
		// wait.waitforElementPresence(By.xpath("//li/ul/li[2]/span"));
		// carcassGridDesc.getAttribute("Carcass");
		carcassGridShortName.sendKeys(CGShName);
		carcassGridSave.click();
	}

	/*public void saveEstimatedADG(String EsmdADG, String minwt, String maxwt,
			String lclgender, String estdADGbreed, String location) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkEstimatedAverageDailyGain"));
		estimatedADG.click();
		wait.waitforElementPresence(By.xpath("//a[@id='lnkNew']/span[2]"));
		newEstimatedADG.click();
		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// genderTable.click();
		setEstimatedADG.sendKeys(EsmdADG);
		wait.waitforElementPresence(By.id("txtEstimatedADG"));
		weightMin.sendKeys(minwt);
		weightMax.sendKeys(maxwt);
		gender.sendKeys(lclgender);
		estmdADGbreed.sendKeys(estdADGbreed);
		estmdADGlocation.sendKeys(location);
		save.click();
	}*/

	public void saveFlesh(String description, String shortname,
			String lclfleshADG) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();

		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Cattle']"));
		cattle.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkFlesh"));
		cattleFlesh.click();

		wait.waitforElementPresence(By
				.xpath("//a[@id='lnkNewFleshInfo']/span[2]"));
		cattleNewFlesh.click();
		wait.waitforElementPresence(By.id("txtFleshDesc"));
		fleshDescription.sendKeys(description);
		fleshShortName.sendKeys(shortname);

		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// fleshDescTable.click();
		// wait.waitforElementPresence(By.id("txtADGFactor"));
		fleshADG.sendKeys(lclfleshADG);
		save.click();

	}

	public void saveGender(String genderdesc, String gendershname,
			String adgFactor) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkGender"));
		cattleGender.click();
		wait.waitforElementPresence(By.id("lnkNewGenderInfo"));
		cattlenewGender.click();
		wait.waitforElementPresence(By.id("txtGenderDesc"));
		genderDescription.sendKeys(genderdesc);
		genderShortName.sendKeys(gendershname);
		genderADGFactor.sendKeys(adgFactor);
		save.click();

	}

	public void savePlaces(String description, String placeshname,
			String country) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();

		wait.waitForElementVisibiltyByAttribute(By
				.xpath("//a[text()='System Setup']/ancestor::li/descendant::li/a[text()='Cattle']"));
		cattle.click();
		wait.waitForElementVisibiltyByAttribute(By.id("lnkPlaces"));
		cattlePlaces.click();

		wait.waitforElementPresence(By.id("lnkNewPlaceInfo"));
		cattleNewPlaces.click();
		wait.waitforElementPresence(By.id("txtPlaceDescription"));
		cattlePlaceDesc.sendKeys(description);
		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// placesDescTable.click();
		cattlePlaceShortName.sendKeys(placeshname);
		cattleCountryPlace.sendKeys(country);
		save.click();

	}

	public void saveProjectionDefaults(String description,
			String projectionshname, String startmonth, String endmonth,
			String date) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkProjectDefaults"));
		cattleProjectionDefaults.click();
		wait.waitforElementPresence(By.id("lnkProjectionDefault"));
		cattleNewProjectionDefault.click();
		wait.waitforElementPresence(By.id("ddlelement"));
		defaultDescription.sendKeys(description);
		projectionDefaultShortName.sendKeys(projectionshname);
		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// projectionDefaultDescTable.click();
		// wait.waitforElementPresence(By.id("txtElementValue"));
		startMonth.sendKeys(startmonth);
		endMonth.sendKeys(endmonth);
		inEffect.sendKeys(date);
		save.click();

	}

	public void saveSeasonADG(String month, String adgFactor) {

		wait.waitforElementPresence(By.linkText("System Setup"));
		systemSetup.click();
		wait.waitforElementPresence(By.linkText("Cattle"));
		cattle.click();
		wait.waitforElementPresence(By.id("lnkSeasonADG"));
		cattleSeasonalADG.click();
		// wait.waitforElementPresence(By.xpath("//tr[2]/td"));
		// seasonADGMonthTable.click();
		wait.waitforElementPresence(By.id("lnkNewSeasonAdgInfo"));
		newSeasonAdgInfo.click();
		wait.waitforElementPresence(By.id("ddlSeasonAdgMonth"));
		ADGMonth.sendKeys(month);
		// wait.waitforElementPresence(By.id("txtSeasonAdgFactor"));
		ADGFactor.clear();
		ADGFactor.sendKeys(adgFactor);
		save.click();

	}
	
public void saveEstimatedADG(String EsmdADG,String minwt,String maxwt,String lclgender,String estdADGbreed,String location) {
        
        wait.waitforElementPresence(By.linkText("System Setup"));
        systemSetup.click();
        wait.waitforElementPresence(By.linkText("Cattle"));
        cattle.click();
        wait.waitforElementPresence(By.id("lnkEstimatedAverageDailyGain"));
        estimatedADG.click();
        wait.waitforElementPresence(By.xpath("//a[@id='lnkNew']/span[2]"));
        newEstimatedADG.click();
        //wait.waitforElementPresence(By.xpath("//tr[2]/td"));
        //genderTable.click();
        setEstimatedADG.sendKeys(EsmdADG);
        wait.waitforElementPresence(By.id("txtEstimatedADG"));
        weightMin.sendKeys(minwt);
        weightMax.sendKeys(maxwt);
        gender.sendKeys(lclgender);
        estmdADGbreed.sendKeys(estdADGbreed);
        estmdADGlocation.sendKeys(location);
        save.click();
    }

	public void setSeleniumAttributes(
			SeleniumAttributesFactory seleniumAttributes) {
		this.seleniumAttributes = seleniumAttributes;
		wait.setSeleniumAttributes(seleniumAttributes);

	}
}
