package seleniumTestProject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestClassSelenium
{
	WebDriver driver = null;
    
	@BeforeMethod
	public void openUrl()
	{
		driver = new FirefoxDriver();
        driver.get("http://espn.go.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	 @Test
		 public void validateTitle()
	{
		WebElement nfl = driver.findElement(By.xpath(".//*[@id='menu-nfl']/a"));
		nfl.click();
		WebElement scores = driver.findElement(By.xpath(".//*[@id='nav-wrapper-container']/div[2]/ul/li[2]/a"));
		scores.click();
	    String title = driver.getTitle();
	    if (title.contains("NFL Scoreboard"))
	    		System.out.println("testcase passed");
	    else
	    	System.out.println("testcase failed");
	    		
	}
	@AfterMethod
     public void afterMethod()
    {
     driver.close();
    }
}
