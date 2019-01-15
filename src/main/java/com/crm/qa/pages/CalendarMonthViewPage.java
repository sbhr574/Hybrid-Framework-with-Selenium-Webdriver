/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;


public class CalendarMonthViewPage extends TestBase {

	@FindBy(id = "crmcalendar")@CacheLookup WebElement verifyMonthView;
	
	
	
}
