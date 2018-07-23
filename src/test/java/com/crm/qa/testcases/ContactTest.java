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
		loginpage =new LoginPage();
		contactTest = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		takeAction = new Common();
		takeAction.switchToFream();
	}
	@Test
	public void contactPageTest() throws InterruptedException{
		
		takeAction.mouseHover("//a[contains(text(),'Contacts')]");
		Thread.sleep(2000);
		contactTest.NewContact();
		Assert.assertTrue(contactTest.contactPageVerify(), "lebel is missing");
	}
	
	
}
