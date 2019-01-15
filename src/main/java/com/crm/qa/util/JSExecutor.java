/**
 * 
 */
package com.crm.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

/**
 * @author Subhajit
 *
 */
public class JSExecutor extends TestBase {

	public void clickElement(WebElement element,WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void selectDateByJS(WebDriver driver,WebElement element,String dateval){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", element);
	}
	
}
