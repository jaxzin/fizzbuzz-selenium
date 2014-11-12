package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void titleValidation(){
		
		//Create instance of Firefox driver
		driver = new FirefoxDriver();
		
		// Set globel time out for driver (Untill and maximun)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Windows maximize
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}
	
	@Test
	public void main() throws InterruptedException {
		
		// Navigate to http://espn.go.com
		driver.navigate().to("http://espn.go.com");
		
		WebElement nfl= driver.findElement(By.name("&lpos=sitenavdefault&lid=sitenav_nfl"));
		new Actions(driver).moveToElement(nfl).perform();
		driver.findElement(By.name("&lpos=sitenavdefault&lid=nfl_scores")).click();
		
		
		//Validate current page title is not "NFL Scoreboard".
		Assert.assertFalse(driver.getTitle().equals("NFL Scoreboard"));
		
	}
	
	@AfterMethod
	public void afterMethod(){
		
		//Close current browser
		driver.close();
	}
	
}
