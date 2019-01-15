package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarNewEventPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.util.Common;

public class NewDealTest extends TestBase{

	LoginPage loginpage;
	HomePage homePage;
	Common common;
	NewCompanyPage newCompanyPage;
	CalendarNewEventPage calendarNewEventPage;
	
	NewDealTest(){
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
		

	}
	
	@Test
	public void NewDealTest(){
		homePage.newDeal();
	}
	
	
	
}
