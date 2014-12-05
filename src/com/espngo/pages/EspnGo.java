package com.espngo.pages;
import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EspnGo {
	
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
		Assert.assertEquals(driver.getTitle(),"NFL Football Scores - NFL Scoreboard - ESPN - ESPN");
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
		//element = driver.findElement(By.linkText(subCategory));
		
		List<WebElement> el = driver.findElements(By.xpath("//*[@id='menu-"+category+"']/div/div[1]/div/div/ul/li"));
		System.out.println(el.size());
		for (int i=0; i<=el.size();i++){
			System.out.println(el.get(i).getText());
			if (el.get(i).getText().equalsIgnoreCase(subCategory)){
				System.out.println(el.get(i).getText());
				//a.click(el.get(i)).perform();
				driver.findElement(By.xpath("//*[@id='menu-"+category+"']/div/div[1]/div/div/ul/li["+(i+1)+"]/a")).click();
				break;
			}
			
		}
		
//		driver.findElement(By.xpath("//*[@id='menu-'"+"'"+category+"']/div/div[1]/div/div/ul/li[2]/a")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		a.click(element).perform();
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
	//	driver.close();
		driver.quit();
		driver = null;
		
	}

}
