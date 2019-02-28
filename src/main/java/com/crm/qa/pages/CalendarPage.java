/**
 * 
 */
package com.crm.qa.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

/**
 * @author Subhajit
 *
 */
public class CalendarPage extends TestBase {

	@FindBy(xpath = "//span[@class='rbc-toolbar-label']")@CacheLookup WebElement verifyMonthDate;
	@FindBy(xpath = "(//span[@class='rbc-btn-group']//button//i)[3]")@CacheLookup WebElement navigateToNextMonth;
	
	public CalendarPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void selectDateFromMonthView(String date){
		String year = date.substring(6);
		String month = date.substring(3, 5);
		String day = date.substring(0, 2);
		String getvalue = verifyMonthDate.getText();
		//Converting month name to month number
				SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
				Calendar cal = Calendar.getInstance();
				try {
					cal.setTime(inputFormat.parse(getvalue));
				} catch (ParseException e) {
					e.toString();
				}
				SimpleDateFormat outputFormat = new SimpleDateFormat("MM"); 
//				System.out.println(outputFormat.format(cal.getTime()));
				String convertedToMonthNumber=outputFormat.format(cal.getTime());
		//Taking the year from getvalue 
				String yearFromgetValue = getvalue.substring(9);
				boolean flag = true;
				while(flag){
		if(convertedToMonthNumber.equals(month) && yearFromgetValue.equals(year)){
			
			flag=false;
		}else{
			navigateToNextMonth.click();
		}
				}
	}
	
}
