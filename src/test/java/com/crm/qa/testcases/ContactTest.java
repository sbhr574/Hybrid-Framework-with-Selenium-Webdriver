package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Common;

public class ContactTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	Common takeAction;
	ContactsPage contactTest;
	
	public ContactTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		loginpage = new LoginPage();
		contactTest = new ContactsPage();
		takeAction = new Common();
		String title = loginpage.gettitle();
		Assert.assertEquals(title, "Free CRM software in the cloud for sales and service");
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		try{
		Assert.assertFalse(loginpage.invalidLogin(), "Login in Invalid");
		}catch(org.openqa.selenium.NoSuchElementException e){
			Assert.assertTrue(loginpage.loginConfirmation(), "Login Failed");
			System.out.println("<<<Login Success>>>");
		}
	}
	@Test
	public void contactPageTest() {
		homepage.navigateToContactPage();
		contactTest.ValidateContactPage();
	}
	
	
}
