package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cr.qa.pages.HomePage;
import com.cr.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		loginPage= new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitletest() {
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	@Test(priority=2)
	public void logintest() throws IOException {
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
