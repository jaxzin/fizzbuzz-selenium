package Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NFLTest {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	WebElement element = null;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void checkScores(){
		
		gotoHomepage();
		System.out.println(driver.getTitle());
		flyOutChooseAny("nfl", "Scores");
		
		System.out.println(driver.getTitle());
		takeScreenShot("NFL-SCORE BOARD");
		Assert.assertEquals("NFL Football Scores - NFL Scoreboard - ESPN - ESPN", driver.getTitle());
		System.out.println("NFL-ScoredBoard Test finished!");
		
	}
	
	//Go to Homepage method
	public void gotoHomepage(){
		
		driver.navigate().to("http://www.espn.go.com");
	}
	
	
	// Reusable dynamic fly out menu method. Pass any parameters ("mlb","Players" or "nascar","CUP Schedule"
	public void flyOutChooseAny(String category, String subCategory){
		
		Actions a = new Actions(driver);
				 
		a.moveToElement(driver.findElement(By.id("menu-"+category))).perform();
		element = driver.findElement(By.linkText(subCategory));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		a.click(element).perform();
	} 
	
	//Take a Screenshot
	public void takeScreenShot(String fileName) {
		File srcFile = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
	    try {
	    	FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\src\\ScreenShots\\"+fileName+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.close();
		driver.quit();
		driver = null;
		
	}

}
