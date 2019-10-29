package com.cr.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	/*
	 *  Used to mark a field on a Page Object to indicate an alternative mechanism for locating the 
	 element or a list of elements. Used in conjunction with org.openqa.selenium.support.PageFactory 
	 this allows users to quickly and easily create PageObjects.

It can be used on a types as well, but will not be processed by default.

You can either use this annotation by specifying both "how" and "using" or by specifying one of the 
location strategies (eg: "id") with an appropriate value to use. Both options will delegate down to
 the matching org.openqa.selenium.By methods in By class.

For example, these two annotations point to the same element:

 @FindBy(id = "foobar") WebElement foobar; 
 @FindBy(how = How.ID, using = "foobar") WebElement foobar;
 
and these two annotations point to the same list of elements:

 @FindBy(tagName = "a") List<WebElement> links;
 @FindBy(how = How.TAG_NAME, using = "a") List<WebElement> links
	 */
	
	
	//Page Factory - OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[conatins(text(), 'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//img[conatins(@class,'img-responsive')]")
	WebElement crmLogo;

	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	//Now we will define our different functionalities available on login page
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();		//After login, it will be redirecting to the home page, So here we are returning the HomePage class object
	}

}
