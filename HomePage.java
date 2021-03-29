package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display']")
	@CacheLookup //This cache will allow selenium to look for this webelement form cache rather than going to the web page again and again.This will speed up the process.
	//Disadvantage is if the page gets refreshed then the cache memory will lose its contents.
	WebElement userName;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contacts;
	
	//Initializing page objects
	public HomePage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	public String verifyHomePageTitle() {
		
		return webDriver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		
		contacts.click();
		return new ContactsPage();
	}
	
	public boolean verifyUserName() {
		
		return userName.isDisplayed();
		
	}
}
