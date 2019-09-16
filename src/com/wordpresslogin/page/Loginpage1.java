/**
 * 
 */
package com.wordpresslogin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author SANKAR
 *
 *this will store all locators and  methods of java
 *
 */
public class Loginpage1 {

	WebDriver driver;
	By username=By.id("user_login");
	By password=By.id("user_pass");
	By loginbutton=By.name("wp-submit");
	
	public Loginpage1(WebDriver driver)
	{
		this.driver = driver;
	}

	public void logintowordpress(String uid,String pwd)
	{
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
	}
	
}
