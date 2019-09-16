import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:/Users/SANKAR/Downloads/geckodriver-v0.13.0-win64/geckodriver.exe");

		WebDriver chrome = new FirefoxDriver();
		chrome.get("http://www.yahoomail.com");
	}

}
