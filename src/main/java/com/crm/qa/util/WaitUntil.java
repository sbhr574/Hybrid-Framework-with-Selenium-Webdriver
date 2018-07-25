package com.crm.qa.util;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class WaitUntil extends TestBase{
	
	public void check(WebElement locator){
		WebDriverWait wait = new WebDriverWait(driver,30);
	    WebElement element = wait.until(
	                        ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}
	public void clickOn(WebDriver driver,WebElement locator,int timeout) throws InterruptedException{
		new WebDriverWait(driver,timeout).ignoring(NoSuchElementException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		Thread.sleep(100);
		locator.click();
	}

	public void sendKey(WebDriver driver,WebElement locator,int timeout,String value){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
	}
}
