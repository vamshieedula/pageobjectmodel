package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//span[contains(text(),'Vamshi Reddy')]")
	WebElement userNameLabel;
	

	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/a[1]/i[1]")
	WebElement contactsSymbol;
	
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]/i[1]")
	WebElement newContacts;
	
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]/i[1]")
	WebElement dealsSymbol;
	
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement deals;
	
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[6]/a[1]/i[1]")
	WebElement tasksSymbol;
	
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasks;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	
	public ContactsPage clickOnContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsSymbol).perform();
		contacts.click();
		return new ContactsPage();
	}
	
	
	public DealsPage clickOnDeals() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsSymbol).perform();
		deals.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickOnTasks() {
		Actions action = new Actions(driver);
		action.moveToElement(tasksSymbol).perform();
		tasks.click();
		return new TasksPage();
	}
	
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsSymbol).perform();
		newContacts.click();
		
	}
	
}
