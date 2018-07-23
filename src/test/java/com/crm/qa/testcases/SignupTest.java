package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignupPage;
import com.crm.qa.util.Common;

public class SignupTest extends TestBase {
	SignupPage signupPage;
	Common withoutSelectDropDown;

	public SignupTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		signupPage = new SignupPage();
		withoutSelectDropDown = new Common();
	}
//	@Test
//	public void gettitel(){
//		String s=signupPage.validatetitleofpage();
//		System.out.println(s);
//	}
	@Test()
	public void click() throws InterruptedException{
		Thread.sleep(2000);
		signupPage.clickonsignup();
		Thread.sleep(2000);
		String titile = signupPage.validatetitleofpage(); 
		System.out.println(titile);
		boolean flag=signupPage.verifySignUpPage();
		Assert.assertTrue(flag, "sign up UI came in page");
		Thread.sleep(2000);
		withoutSelectDropDown.selectvalueFromDropDown("//select[@id='payment_plan_id']", "Free Edition");
//		signupPage.edition("Free Edition");
		
		
		
		
		
	}

	
}

