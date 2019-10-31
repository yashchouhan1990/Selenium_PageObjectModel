package com.cr.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	


	@FindBy(xpath="//span[contains(text(),'Yash Chouhan')]")
	WebElement userNamelabel;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	//initialize the HomePage Objects
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public boolean verifyCorrectuserName() {
		return userNamelabel.isDisplayed();
	}

	
	
	

}
