package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
	WebElement contactsLabel;
	//body/div[contains(text(),'Contacts')]
	
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	
	@FindBy(xpath="//*[@class='ui linkedin button']")
	WebElement save;
	
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();	
	}
	
	public void selectContactBox() {
		driver.findElement(By.xpath("")).click();
	}
	
	public void createNewContact(String ftName, String ltName) {
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		save.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
