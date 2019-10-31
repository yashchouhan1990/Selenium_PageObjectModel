package com.cr.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{


	
	@FindBy(xpath=" //div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;

	
	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	//Action
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input")).click();
	}
	

}
