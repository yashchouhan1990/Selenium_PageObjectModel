package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cr.qa.pages.ContactsPage;
import com.cr.qa.pages.HomePage;
import com.cr.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;	

	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		loginPage= new LoginPage();
		contactsPage = new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact label is missing on page");
	}
	
	@Test(priority=2)
	public void selectContactsPagLabelTest() throws InterruptedException {
		Thread.sleep(2000);
		contactsPage.selectContactByName("Yash Chouhan");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
