package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory
	@FindBy(xpath="//header/div[1]/nav[1]/div[1]/div[1]/a[1]")
	WebElement login;
	
	
	@FindBy(name="email")
	WebElement userName;
	
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//body/div[1]/main[1]/section[1]/a[1]")
	WebElement signUp;
	
	
	@FindBy(xpath="//header/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement crmLogo;
	
	//initialising page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage logIn(String un, String pwd) {
		login.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
