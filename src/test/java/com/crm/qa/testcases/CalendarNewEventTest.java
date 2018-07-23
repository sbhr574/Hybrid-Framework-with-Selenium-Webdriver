package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.util.Common;

public class CalendarNewEventTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homePage;
	Common common;
	NewCompanyPage newCompanyPage;

	CalendarNewEventTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		common =  new Common();
		newCompanyPage = new NewCompanyPage();
		homePage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		common.switchToFream();
		//Thread.sleep(1000);
		common.moveEle("//a[contains(text(),'Calendar')]");
		homePage.NewEvent();
	}
	@Test
	public void test(){
		System.out.println("korboi");
	}
}
