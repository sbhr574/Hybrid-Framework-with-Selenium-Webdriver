package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignupPage extends TestBase{

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement clickonSignUP;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement verifySignUP;
	
	@FindBy(name = "payment_plan_id")
	WebElement dropd;
	
	public SignupPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action
	
	public String validatetitleofpage(){
		return driver.getTitle();
	}
	public boolean verifySignUpPage(){
		return verifySignUP.isDisplayed();
	}
	public void edition(String str){
		Select dredi = new Select(dropd);
		dredi.selectByValue(str);
	}
	
	
	public void clickonsignup() throws InterruptedException{
//		Thread.sleep(2000);
		clickonSignUP.click();
	}
	
	
	
	
}
