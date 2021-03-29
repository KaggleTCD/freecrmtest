package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory or object repository
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	//Initializing
	public LoginPage() {
		
		PageFactory.initElements(webDriver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return webDriver.getTitle();
	}
	
	public HomePage login(String email,String pass) {
		
		emailId.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
		
		return new HomePage();
	}

}
