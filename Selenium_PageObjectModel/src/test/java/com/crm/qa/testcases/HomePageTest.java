package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cr.qa.pages.CalendarPage;
import com.cr.qa.pages.ContactsPage;
import com.cr.qa.pages.HomePage;
import com.cr.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;	
	CalendarPage calendarPage;
	
	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		loginPage= new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page Title not matched !!");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectuserName());
	}
	
	@Test(priority=3)
	public void verifycontactsLinkTest() throws IOException, InterruptedException {
		contactsPage= homePage.clickOnContactsLink();
		Thread.sleep(1000);
	}
	
	@Test(priority=4)
	public void verifycalendarLinkTest() throws InterruptedException {
		calendarPage= homePage.clickOnCalendarLink();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
