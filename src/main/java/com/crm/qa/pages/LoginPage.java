package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = ".btn.btn-small")
	WebElement submit;
	
	
	@FindBy(xpath = "//td[contains(text(),'CRMPRO')]/..")WebElement logo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String gettitle(){
		return driver.getTitle();
	}
	public HomePage login(String un,String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		//This method is returning homepage class objetc
		return new HomePage();
	}
	public boolean Logo(){
		return logo.isDisplayed();
	}
	
	
}
