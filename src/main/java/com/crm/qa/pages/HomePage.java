package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{


	 @FindBy(xpath = "//a[contains(text(),'Companies')]")@CacheLookup WebElement clickOnCompanies;
	 @FindBy(xpath = "//a[contains(text(),'New Company')]")WebElement clickOnNewCompanie;
	 @FindBy(xpath = "//a[contains(text(),'Contacts')]")@CacheLookup WebElement contacts;
	 @FindBy(xpath = "//a[contains(text(),'New Event')]")@CacheLookup WebElement newEvent;

	 public HomePage(){
			PageFactory.initElements(driver, this);
		}

	public NewCompanyPage ClickOnNewCompanie() {
		clickOnNewCompanie.click();
		return new NewCompanyPage();

	}
	public ContactsPage contacts(){
		contacts.click();
		return new ContactsPage();
	}
	public void NewEvent(){
		newEvent.click();
	}
	
}
