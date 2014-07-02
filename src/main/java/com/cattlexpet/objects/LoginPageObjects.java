package com.cattlexpet.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.uprr.selenium.common.WaitForElements;
import com.uprr.selenium.interfaces.SeleniumAttributesFactory;

public class LoginPageObjects {

	// Login Objects
	@FindBy(id = "txtUserName")
	private WebElement userName;
	@FindBy(id = "txtPassword")
	private WebElement password;
	@FindBy(id = "btnLogin")
	private WebElement login;

	// LogOut Objects
	@FindBy(id = "btnLogOut")
	private WebElement logout;

	@FindBy(id = "btnConnect")
	private WebElement connectButton;

	private SeleniumAttributesFactory seleniumAttributes;
	private WaitForElements wait = new WaitForElements();;

	public void userLogin(String UserName, String Password) {
		wait.waitforElementPresence(By.id("txtUserName"));
		userName.sendKeys(UserName);
		wait.waitforElementPresence(By.id("txtPassword"));
		password.sendKeys(Password);
		login.click();
		wait.waitforElementPresence(By.id("btnConnect"));
		connectButton.click();

	}

	public void userLogout() {
		wait.waitforElementPresence(By.id("btnLogOut"));
		logout.click();
	}

	public void setSeleniumAttributes(
			SeleniumAttributesFactory seleniumAttributes) {
		this.seleniumAttributes = seleniumAttributes;
		wait.setSeleniumAttributes(seleniumAttributes);
	}

}
