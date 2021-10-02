package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}

	//note:testcases should be independent
	//before each test cases -- launches the browser and login
	//@Test -- execute the test case
	//after each test cases -- close the browser
	@BeforeMethod
	public void setUp() {
		initialisation();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitile = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitile, "Cogmento CRM","HomePage title not matched");
	}
	
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	
	@Test(priority = 3)
	public void verifyContactsLinkSymbol() {
		contactsPage = homePage.clickOnContacts();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
