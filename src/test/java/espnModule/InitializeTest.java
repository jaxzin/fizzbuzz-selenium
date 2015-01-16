package espnModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeTest {
	public static WebDriver driver=null;
	
	public static void initalise()
	{
		driver= new FirefoxDriver();
		driver.get("http://espn.go.com/");
		driver.manage().window().maximize();
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
		

}
