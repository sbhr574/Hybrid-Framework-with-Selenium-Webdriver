package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.JSExecutor;

public class HomePage extends TestBase{

	JSExecutor js=new JSExecutor();

	 @FindBy(xpath = "//a[contains(text(),'Companies')]")@CacheLookup WebElement clickOnCompanies;
	 @FindBy(xpath = "//a[contains(text(),'New Company')]")WebElement clickOnNewCompanie;
	 @FindBy(xpath = "//a[contains(text(),'Contacts')]")@CacheLookup WebElement contacts;
	 @FindBy(xpath = "//a[contains(text(),'New Event')]")@CacheLookup WebElement newEvent;
	 @FindBy(xpath = "//a[contains(text(),'Month View')]")@CacheLookup WebElement monthView;

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
		js.clickElement(newEvent, driver);
	}
	public CalendarMonthViewPage navigateToMonthView(){
		js.clickElement(monthView, driver);
		return new CalendarMonthViewPage();
	}
	
}
