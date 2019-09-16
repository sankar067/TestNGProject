/**
 * 
 */
package com.wordpagelogin.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.readproperty.ReadPropertyFile;
import com.wordpresslogin.page.LoginPageFactory;
import com.wordpresslogin.page.Loginpage1;

import lib.ExcelConfig;
import pagefactory.helper.BrowserFactory;

/**
 * @author SANKAR
 *
 *
 * 
 */
public class VerifyLoginPageFactory {
	WebDriver driver;
	@Test
	public void CheckValidUser()
	{
		//Initiated browser and opened url
		driver=BrowserFactory.StartBrowser("chrome", "https://wordpress.com/wp-login.php");
		
		//created page object using pagefactory
		LoginPageFactory login_page=PageFactory.initElements(driver, LoginPageFactory.class);
		
		login_page.LoginToWordPress("sankar067","bindas35143");
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
