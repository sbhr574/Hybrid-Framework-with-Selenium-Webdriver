/**
 * 
 */
package com.crm.qa.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarNewEventPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCompanyPage;
import com.crm.qa.util.Common;

/**
 * @author MONIDEEPA
 *
 */
public class CalendarMonthViewTest extends TestBase {

	private String today;
	
	LoginPage loginpage;
	HomePage homePage;
	Common common;
	NewCompanyPage newCompanyPage;
	CalendarNewEventPage calendarNewEventPage;
	
	CalendarMonthViewTest(){
		super();
	}
	
	//Get The Current Day
    private String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DATE);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
    }
 
	
//	@BeforeMethod
//	public void setup() throws InterruptedException{
//		initialization();
//		loginpage = new LoginPage();
//		common =  new Common();
//		newCompanyPage = new NewCompanyPage();
//		calendarNewEventPage = new CalendarNewEventPage();
//		homePage = loginpage.login("dejavu","Bangalore*8");
//		common.switchToFream();
//		Thread.sleep(1000);
//		common.moveEle("//a[contains(text(),'Calendar')]");
//		homePage.navigateToMonthView();
//	}
	@Test
	public void CalendarMonthViewTest() throws Exception{
		 today = getCurrentDay();
	        System.out.println("Today's number: " + today + "\n");
	        WebElement dateWidgetFrom = driver.findElement(By.xpath(".//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody"));
	        //Row= //div[@class='k-scheduler-content']/table/tbody/tr
	        
     //Click and open the datepickers
//     driver.findElement(By.xpath("")).click();
	      //This are the rows of the from date picker table
	        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
	 
	        //This are the columns of the from date picker table
	        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
	  
	        //DatePicker is a table. Thus we can navigate to each cell
	        //and if a cell matches with the current date then we will click it.
	        for (WebElement cell: columns) {
	            Thread.sleep(1000);
	            //If you want to click 18th Date
	            if (cell.getText().contains("23")) {
	            
	            //Select Today's Date
//	            if (cell.getText().equals(today)) {
//	            	System.out.println(cell.getText());
	            	Thread.sleep(2000);
	            	
	            	System.out.println("test1");
	            	cell.click();
	                break;
	            }
	        }
 	
	}
	}
	
	
	
	
	
	

