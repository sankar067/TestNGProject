/**
 * 
 */
package com.wordpagelogin.Testcases;

import org.testng.annotations.Test;

import com.wordpresslogin.page.Loginpage1;


/**
 * @author SANKAR
 *
 */
public class LoginExtendClass extends BaseClass{

	
	@Test(dataProvider="wordpresslogindata")
	public void VerifyWordpressLogin(String uid,String pwd) throws Exception
	{

		Loginpage1 login = new Loginpage1(driver);
		login.logintowordpress(uid,pwd);	
	}
	

}
