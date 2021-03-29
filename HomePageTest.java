package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage clickOnContactsLink;
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserName() {
		
		boolean verifyUserName = homePage.verifyUserName();
		Assert.assertEquals(verifyUserName, true);
	}
	
	@Test(priority = 3)
	public void verifyContacts() {
		
		clickOnContactsLink = homePage.clickOnContactsLink();
	}
	
	/*
	 * @AfterMethod public void tearDown() {
	 * 
	 * webDriver.quit(); }
	 */
	
	
}
