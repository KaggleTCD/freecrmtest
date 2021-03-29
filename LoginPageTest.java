package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
	}

	/*
	 * @Test(priority = 1) public void loginPageTitleTest() {
	 * 
	 * String loginPageTitle = loginPage.validateLoginPageTitle();
	 * Assert.assertEquals(loginPageTitle,
	 * "#1 Free CRM customer relationship management software cloud"); }
	 */
	
	@Test(priority = 2)
	public void login() {
		
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		webDriver.quit();
	}
}
