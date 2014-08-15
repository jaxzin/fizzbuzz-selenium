package espn_go;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Espn_NFL {
	public WebDriver driver = null;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://www.espn.go.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void TestCase1(){
		driver.findElement(By.cssSelector("a[href='#nfl-scores']")).click();
		driver.findElement(By.cssSelector("a[href='http://scores.espn.go.com/nfl/scoreboard']")).click();
		String NFLTitle  = driver.findElement(By.cssSelector("a[href='http://espn.go.com/nfl/']")).getText();
		Assert.assertEquals(NFLTitle,"NFL Scoreboard");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
