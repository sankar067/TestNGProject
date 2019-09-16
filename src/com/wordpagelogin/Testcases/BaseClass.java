/**
 * 
 */
package com.wordpagelogin.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.readproperty.ReadPropertyFile;

import lib.ExcelConfig;


/**
 * @author SANKAR
 *
 *
 * 
 */
public class BaseClass {
	
	WebDriver driver;
	ReadPropertyFile property;
	
	@BeforeMethod
	public void Setupapplication()
	{
		Reporter.log("====== Browser Session Started =======", true);
		property = new ReadPropertyFile();
		System.out.println(property.GetPropertyData("chromedriver"));
		System.setProperty("webdriver.chrome.driver",property.GetPropertyData("chromedriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(property.GetPropertyData("Url"));	
		Reporter.log("====== Application Setup Done =======", true);
	}

	@DataProvider(name="wordpresslogindata")
	public Object[][] passdata()
	{
		property = new ReadPropertyFile();
		ExcelConfig excel=new ExcelConfig(property.GetPropertyData("ExcelPath"));
		int rows = excel.GetRowCount(0);
		Object[][] darr = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			darr[i][0]=excel.GetData(0, i, 0);
			darr[i][1]=excel.GetData(0, i, 1);
		}
		
		return darr;
	}	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		Reporter.log("====== Browser Session Ended =======", true);
	}
}
