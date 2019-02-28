/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")@CacheLookup WebElement verifyContactPage;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	@FindBy(xpath = "//a[contains(text(),'Combined Form')]")
	WebElement forCombinedForm;
	
	@FindBy(xpath = "//legend[contains(text(),'Contct Information')]")
	WebElement PageVerify;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void NewContact(){
		newContact.click();
	}
	public boolean ValidateContactPage(){
		boolean value = false;
		try{
			value = verifyContactPage.isDisplayed();
			System.out.println("<<<Successfully Navigate to Contact Page>>>");
			return value;
		}catch(org.openqa.selenium.NoSuchElementException e){
			System.out.println("<<<Failed to navigate at Contact Page>>>");
			return value;
		}
	}
	public void dynaminxpath(String name){
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
}
