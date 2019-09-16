package datadriventestng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelConfig;

public class DataDrivenType2 {
	WebDriver driver;
	@Test(dataProvider="wordpresslogindata")
	public void wordpresslogin(String username, String password) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C://Users//SANKAR//Downloads//chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://wordpress.com/wp-login.php");
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		
		driver.findElement(By.id("user_pass")).sendKeys(password);
		
		driver.findElement(By.id("wp-submit")).click();
		
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Reader"), "Login Not Successful");
		System.out.println("User Successfully Login");
		

	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@DataProvider(name="wordpresslogindata")
	//method 
	//2D array
	//retun type is object(which will handle any data type)
	public Object[][] passdata()
	{
		//Reading data from excel
		ExcelConfig excel = new ExcelConfig("C:/Users/SANKAR/workspace2/MyTest/Data/Book1.xlsx");
		int rows = excel.GetRowCount(0);
		
		//declaring 2D array 'darr' datatype object and with intialize data
		Object[][] darr = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			darr[i][0]=excel.GetData(0, i, 0);
			darr[i][1]=excel.GetData(0, i, 1);
		}
		
		return darr;
	}
	
}
