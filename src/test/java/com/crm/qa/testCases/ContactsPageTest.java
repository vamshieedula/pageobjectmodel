package com.crm.qa.testCases;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	Logger log = Logger.getLogger(ContactsPageTest.class);

	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		testutil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacts();
		
		log.info("clicked on contacts");
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
		log.info("verified the contatPageLabel");//logs
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test(priority = 2, dataProvider="getCRMTestData")
	public void validateCreateNewcontact(String firstName, String lastName) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Tom", "lisa");
		contactsPage.createNewContact(firstName, lastName);
		
		log.info("entered as data firstName "+firstName+" and lastName "+ lastName);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("test execution completed successfully");
		
	}
	
	
	

}
