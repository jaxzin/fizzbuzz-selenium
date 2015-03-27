package pageObjects;

import org.openqa.selenium.WebDriver;

public class Abstractpage {

	protected WebDriver driver;
	public Abstractpage (WebDriver driver)
	{
		this.driver=driver;
	}
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public HomePage navigateToApp()
	{
		driver.navigate().to("http://espn.go.com/");
		return new HomePage(driver);
	}

}
