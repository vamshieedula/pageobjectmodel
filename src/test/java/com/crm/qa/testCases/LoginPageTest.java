package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
		
	}
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	
	
	@Test(priority = 2)
	public void crmLogoImgTest() {
		boolean flag = loginPage.validatecrmLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
