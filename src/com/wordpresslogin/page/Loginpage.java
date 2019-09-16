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
public class Loginpage {

	WebDriver driver;
	By username=By.id("user_login");
	By password=By.id("user_pass");
	By loginbutton=By.name("wp-submit");
	
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void typeusername()
	{
		driver.findElement(username).sendKeys("sankar067");
	}
	
	public void typepassword()
	{
		driver.findElement(password).sendKeys("bindas35143");
	}
	public void clickloginbutton()
	{
		driver.findElement(loginbutton).click();
	}
}
