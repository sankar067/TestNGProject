import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SeleniumChromeClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//load driver
		System.setProperty("webdriver.chrome.driver", "R:/drivers/chromedriver.exe");
		// create driver object
		WebDriver chrome = new ChromeDriver();
		chrome.get("http://www.gmail.com");
		//create file object and read file
		File fs=new File("/MyLearningProject/Data/Book1.xlsx");
		FileInputStream fstr= new FileInputStream(fs);
		//create work book
		//XSSFWorkbook for .xlsx file
		//HSSFWorkbook for .xls file
		XSSFWorkbook wb = new XSSFWorkbook(fstr);  //or new HSSFWorkbook();
		//Read excel sheet
		XSSFSheet sheet=wb.getSheetAt(0);
		//get number of rows
		int	row=sheet.getLastRowNum();
		for(int i=0;i<=row;i++){
			String cd=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Cell data  : "+cd);	
			Boolean st=chrome.findElement(By.id("Email")).isDisplayed();
			System.out.println("Status : "+st);	
			chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			chrome.findElement(By.name("Email")).sendKeys(cd);
//			chrome.findElement(By.name("signIn")).click();
		}
		wb.close();
		fstr.close();
		
		
//		chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		
//		Boolean pswd=chrome.findElement(By.id("login-username")).isDisplayed();
//		System.out.println("Status : "+pswd);	
////		chrome.findElement(By.id("passwd-field")).sendKeys("password");
////		chrome.findElement(By.className("login-input  pure-u-1")).sendKeys("password");
//		chrome.findElement(By.id("login-signin")).click();
		chrome.quit();
	}

}
