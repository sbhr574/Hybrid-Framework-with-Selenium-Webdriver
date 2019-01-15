package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarNewEventPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.util.Common;

public class CalendarNewEventTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homePage;
	Common common;
	NewCompanyPage newCompanyPage;
	CalendarNewEventPage calendarNewEventPage;
	
	CalendarNewEventTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		common =  new Common();
		newCompanyPage = new NewCompanyPage();
		calendarNewEventPage = new CalendarNewEventPage();
		homePage = loginpage.login("dejavu","Bangalore*8");
		common.switchToFream();
		common.moveEle("//a[contains(text(),'Calendar')]");
		homePage.NewEvent();
	}
	@Test
	public void CalendarNewEventTest(){
		calendarNewEventPage.saveButtonForCalendarNewEvent();
		calendarNewEventPage.titleBox("New Title");
		calendarNewEventPage.setDate("26-Oct-2019 10:53");
//		calendarNewEventPage.calendarButtonForFrom();
		calendarNewEventPage.calendarDateTo("27-Oct-2019 10:53");
//		calendarNewEventPage.categoryType("Critical");
//		common.selectValue(element, value);
		
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		calendarNewEventPage.helpButtonForTag();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		// Performing the actions on new window
		System.out.println("Help option for Tag button: "+ calendarNewEventPage.confirmTagWindow());
		// Close the new window, if that window no more required
		driver.close();
		String popupmsg = driver.switchTo().alert().getText();
		System.out.println(popupmsg);
		driver.switchTo().alert().accept();
	}
	
}
