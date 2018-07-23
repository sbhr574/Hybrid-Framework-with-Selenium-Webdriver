package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewCompanyPage extends TestBase {
	
	//Page factory
	@FindBy(id = "company_name")@CacheLookup WebElement companyName;
	@FindBy(xpath = "(//input[@value='Save'])[1]")WebElement saveButton;// //input[@type='submit' and @value='Save'] 
	@FindBy(xpath = "//legend[contains(text(),'Create New  Company')]")@CacheLookup WebElement validateNewContactPage;
	@FindBy(xpath = "//td[contains(text(),'Company: ')]")@CacheLookup WebElement validateSavedNewContactPage;
	
	//How to initialize the element with the help of the page factory?
	public NewCompanyPage(){
		//PageFactory.initElements(driver, this);//PageFactory=Class and initElements=method here driver is coming from TestBase
		//And this means current class objects
		PageFactory.initElements(driver, NewCompanyPage.this);//both above and this line is same
	}
	
	
	public void CompanyName(String str){
		companyName.sendKeys(str);
	}
	public void saveButtonNewCompany(){
		saveButton.click();
	}
	//Without FindBy : - this type we have to use only when xpath is dynamic.(this is just a example)
	public void varifyNewCompanyPage(){
		driver.findElement(By.xpath("//td[contains(text(),'Company: ')]")).isDisplayed();
	}
	public boolean ValidateNewContactPage(){
		return validateNewContactPage.isDisplayed();
	}
	public boolean ValidateSavedNewContactPage(){
		return validateSavedNewContactPage.isDisplayed();
	}
	
	
	
}
