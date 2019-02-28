package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
	
	@BeforeClass
	public void setup(){
		initialization();
		loginpage =new LoginPage();
	}
	
	@Test(priority = 0)
	public void validatetitle(){
		String title = loginpage.gettitle();
		Assert.assertEquals(title, "Free CRM software in the cloud for sales and service");
	}
	@Test(dependsOnMethods = { "validatetitle" })
	public void loginOperation() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
//		try{
//		Assert.assertFalse(loginpage.invalidLogin(), "Login in Invalid");
//		}catch(org.openqa.selenium.NoSuchElementException e){
//			Assert.assertTrue(loginpage.loginConfirmation(), "Login Failed");
//			System.out.println("<<<Login Success>>>");
//		}
		assertEquals(true, loginpage.invalidLogin());
	}
	
	
	

}
	

