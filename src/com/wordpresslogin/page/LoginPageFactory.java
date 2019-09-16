package com.wordpresslogin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactory {
	
	WebDriver driver;
	
	public LoginPageFactory(WebDriver ldriver) {
		// TODO Auto-generated constructor stub
		this.driver=ldriver;
		
	}

	@FindBy(id="user_login") 
	WebElement username;
	
	@FindBy(how=How.ID,using="user_pass")
	WebElement pass;
	
	@FindBy(how=How.NAME,using="wp-submit")
	WebElement login_button;
	
	@FindBy(how=How.LINK_TEXT,using="Lost your password?")
	WebElement forgot_pass_link;
	
	@FindBy(how=How.CLASS_NAME,using="click-register")
	WebElement register_link;
	
	public void LoginToWordPress(String uid,String password)
	{
		username.sendKeys(uid);
		pass.sendKeys(password);
		login_button.click();
	}
}
