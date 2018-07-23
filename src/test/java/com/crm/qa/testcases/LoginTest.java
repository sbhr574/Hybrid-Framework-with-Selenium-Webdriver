package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage =new LoginPage();
	}
	
//	@Test
//	public void validatetitle(){
//		String title = loginpage.gettitle();
//		Assert.assertEquals(title, "sdjsdfjdfj");
//	}
	@Test
	public void usernametype() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
}
