package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.JSExecutor;

public class LoginPage extends TestBase {

	JSExecutor js=new JSExecutor();
	
	@FindBy(xpath = "//span[text()='Log In']")WebElement logInButton;
	@FindBy(name = "email")WebElement username;
	@FindBy(name = "password")WebElement password;
	@FindBy(xpath = "//div[text()='Login']")@CacheLookup WebElement loginButton;
	@FindBy(xpath = "//td[contains(text(),'CRMPRO')]/..")WebElement logo;
	@FindBy(css = "div[class='ui negative message']")WebElement invalidLogin;
	@FindBy(xpath = "//div[@id='top-header-menu']")WebElement loginPageHeader;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle(){
		return driver.getTitle();
	}
	public HomePage login(String un,String pwd) {
		logInButton.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		js.clickElement(loginButton, driver);
		//This method is returning homepage class object
		return new HomePage();
	}
	public boolean Logo(){
		return logo.isDisplayed();
	}
	public boolean invalidLogin(){
		boolean value = false;
		try{
		return invalidLogin.isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e){
			return value;
		}
	}
	public boolean loginConfirmation(){
		return loginPageHeader.isDisplayed();
	}
}
