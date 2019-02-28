package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class Common extends TestBase{
	
	public void mouseHover(String xpath){
		Actions hold = new Actions(driver);
		hold.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}
	
	public void switchToFream(){
		driver.switchTo().frame("mainpanel");
	}
	public void moveEle(String xpath){
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}

	public void selectvalueFromDropDown(String xpath,String value){
		List<WebElement> Options = driver.findElements(By.xpath(xpath));
		for(WebElement option : Options){
			if(option.getText().equals(value)){
				option.click();
				break;
			}
			}
		}
	public void selectvalueFromList(String xpath,String value){
		List<WebElement> Options = driver.findElements(By.xpath(xpath));
		for(WebElement option : Options){
			if(option.getText().equals(value)){
				option.click();
				break;
			}
			}
		}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		//Step1:take a screenshot and store it as a file format.
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//output type is file type//coverting driver to take a screen shot TakesScreenshot(I) and then getScreenshotAs this method will execute 
		//Step2:Now copy the screenshot to desire location using copyfile method		
				String currentDir = System.getProperty("user.dir");
				FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
				
				}
	public void selectValue(WebElement element,String value){
		Select options = new Select(element);
		options.selectByVisibleText(value);
	}
	
	
}
