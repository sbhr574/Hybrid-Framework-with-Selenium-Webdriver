package com.crm.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarNewEventPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Common;

public class SelectingDateFromCalendarTest extends TestBase{
	
	CalendarNewEventPage calendarPage;
	LoginPage loginPage;
	HomePage homePage;
	Common takeAction;
	String day;
	

	public SelectingDateFromCalendarTest(){
		super();
	}
	
	@BeforeTest
	public void setup(){
		initialization();
		loginPage =new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		takeAction = new Common();
		homePage = new HomePage();
		calendarPage = new CalendarNewEventPage();
		takeAction.switchToFream();
		homePage.mouseHoverToCalendar();
	}
	
	@Test
	public void selectingDateFromCalendar() throws Exception{
		
		Thread.sleep(2000);
		calendarPage.calendarButtonForFrom();
		WebElement eval=driver.findElement(By.xpath("//div[contains(@class,'calendar')]/table/tbody"));
		List<WebElement> samePage = eval.findElements(By.tagName("td"));
		for(WebElement cell:samePage){
			 if (cell.getText().contains("3")) {
	            	if(cell.getAttribute("Class").contains("day wn")){
	            		
	            	}else{
	            	Thread.sleep(2000);
	            	day = cell.getText();
	            	System.out.println(day);
		            driver.findElement(By.xpath("//div[contains(@class,'calendar')]/table/tbody/tr/td[text()='"+day+"']")).click();
		                break;
	            	}
	            }
		}
		
	}
	
	
	
	
	
}
