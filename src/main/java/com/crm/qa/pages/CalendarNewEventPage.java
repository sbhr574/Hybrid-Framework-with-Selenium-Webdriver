/**
 * 
 */
package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.JSExecutor;

/**
 * @author Subhajit
 *
 */
public class CalendarNewEventPage extends TestBase{

	JSExecutor js=new JSExecutor();
	
	@FindBy(id = "f_trigger_c_start")@CacheLookup WebElement calendarButtonFrom;
	@FindBy(id = "f_trigger_c_end")@CacheLookup WebElement calendarButtonTo;
	@FindBy(id = "fieldId_start")@CacheLookup WebElement calendarDateFrom;
	@FindBy(id = "title")@CacheLookup WebElement titleBox;
	@FindBy(id = "fieldId_end")@CacheLookup WebElement calendarDateTo;
	@FindBy(name = "category")@CacheLookup WebElement categoryType;
	@FindBy(id = "email_alert")@CacheLookup WebElement emailAlert;
	@FindBy(xpath = "//input[@id='tags']/following-sibling::input")@CacheLookup WebElement helpButtonForTag;
	@FindBy(xpath = "(//input[@type='submit'])[1]")@CacheLookup WebElement saveButtonForCalendarNewEvent;
	
	public CalendarNewEventPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void setDate(String dateValue){
		js.selectDateByJS(driver, calendarDateFrom, dateValue);
	}
	public void test(){
		List<WebElement> list = driver.findElements(By.partialLinkText(""));
		for(int i=0;i<list.size();i++){
			if(list.get(i).getText().equals("")){
				
			}
		}	
	}

	public void selectLastOption() {    //This is way to select the last option from a dropdown
		Select options = new Select(categoryType);
		int i=options.getOptions().size();
		options.selectByIndex(i-1);
	}
	public void titleBox(String title){
		titleBox.sendKeys(title);
	}
	public void calendarButtonForFrom(){
		calendarButtonFrom.click();
	}
	public void calendarButtonForTo(){
		calendarButtonTo.click();
	}
	public void calendarDateTo(String dateValue){
		js.selectDateByJS(driver, calendarDateTo, dateValue);
	}
	public void categoryType(String category){
		Select options = new Select(categoryType);
		options.selectByVisibleText(category);
	}
	public void emailAlertCheckBox(){
		emailAlert.click();
	}
	public void helpButtonForTag(){
		helpButtonForTag.click();
	}
	public boolean confirmTagWindow(){
		boolean flag = driver.findElement(By.xpath("//span[text()='Tagging']")).isDisplayed();
		return flag;
	}
	public void saveButtonForCalendarNewEvent(){
		saveButtonForCalendarNewEvent.click();
	}
	
	
}
