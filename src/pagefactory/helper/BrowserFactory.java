/**
 * 
 */
package pagefactory.helper;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.readproperty.ReadPropertyFile;

/**
 * @author SANKAR
 *
 */
public class BrowserFactory {
	
static WebDriver driver;
static ReadPropertyFile property;

	public static WebDriver StartBrowser(String browsername,String Url)
	{
		property = new ReadPropertyFile();
		
		if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",property.GetPropertyData("chromedriver"));
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",property.GetPropertyData("chromedriver"));
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",property.GetPropertyData("iedriver"));
			driver=new InternetExplorerDriver();	
		}
		
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
