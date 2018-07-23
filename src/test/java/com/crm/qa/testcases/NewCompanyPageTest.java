package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Common;
import com.crm.qa.util.XSSFSheetUtil;


public class NewCompanyPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	Common common;
	NewCompanyPage newCompanyPage;
	XSSFSheetUtil excel;

	NewCompanyPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginpage =new LoginPage();
		common =  new Common();
		newCompanyPage = new NewCompanyPage();
		excel = XSSFSheetUtil.getXssfSheetUtil(excelfile);
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		common.switchToFream();
		//Thread.sleep(1000);
		common.moveEle("//a[contains(text(),'Companies')]");
		homepage.ClickOnNewCompanie();
	}
	@Test(priority = 1)
	public void NewCompanyPage() throws Exception{
		//Thread.sleep(1000);
		Assert.assertTrue(newCompanyPage.ValidateNewContactPage(), "Problem : Not able to open New company Page.");
		newCompanyPage.CompanyName(excel.getdata("Sheet1", 0, 0));
	}
//	@Test(priority = 2)
//	public void NewCompanyPage1(){
//		newCompanyPage.CompanyName("Subhajit");
//		Select se = new Select(driver.findElement(By.name("status")));
//		se.selectByVisibleText("Active");
//		newCompanyPage.saveButtonNewCompany();
//		Assert.assertTrue(newCompanyPage.ValidateSavedNewContactPage(), "Problem : Company Page not saved.");
//	}
//	@AfterMethod
//	public void dismiss(){
//		driver.quit();
//	}
	
}
