package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.util.Common;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	Common common;
	NewCompanyPage newCompanyPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginpage =new LoginPage();
		common =  new Common();
		newCompanyPage = new NewCompanyPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@Test
	public void TestingHomePage() throws InterruptedException{
		common.switchToFream();
		Thread.sleep(1000);
		common.moveEle("//a[contains(text(),'Companies')]");
		//While navigateing to other page/or landing to other page
		newCompanyPage = homepage.ClickOnNewCompanie();//ClickOnNewCompanie is returning NewCompanyPage class object so need to store NewCompanyPage referance variable.
	}
}
