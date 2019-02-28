/**
 * 
 */
package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

/**
 * @author Subhajit
 *
 */
public class DateSelectFromCalendarTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	CalendarPage calendarPage;
	
	public DateSelectFromCalendarTest(){
		super();
	}
	
	@BeforeClass
	public void setup(){
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		calendarPage = new CalendarPage();
	}
	
	@Test(priority = 0)
	public void validatetitle(){
		String title = loginpage.gettitle();
		Assert.assertEquals(title, "Free CRM software in the cloud for sales and service");
	}
	@Test(dependsOnMethods = { "validatetitle" })
	public void loginOperation() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
//		assertEquals(false, loginpage.invalidLogin());
		}
	@Test(dependsOnMethods = "loginOperation")
	public void navigateCalendarPage() {
		homepage.navigateToCalendarPage();
	}
	@Test(dependsOnMethods = "navigateCalendarPage")
	public void SelectingDateFromCalendar(){
		calendarPage.selectDateFromMonthView("26/02/2020");
	}
	
}
