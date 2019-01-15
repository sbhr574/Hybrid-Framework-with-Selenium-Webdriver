package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.JSExecutor;

public class LoginPage extends TestBase {

	JSExecutor js=new JSExecutor();
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = ".btn.btn-small")@CacheLookup WebElement submit;
	
	
	@FindBy(xpath = "//td[contains(text(),'CRMPRO')]/..")WebElement logo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle(){
		return driver.getTitle();
	}
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		js.clickElement(submit, driver);
		//This method is returning homepage class objetc
		return new HomePage();
	}
	public boolean Logo(){
		System.out.println("weew");
		return logo.isDisplayed();
	}
	
	
}
