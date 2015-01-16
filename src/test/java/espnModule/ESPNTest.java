package espnModule;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import espnWebPages.ESPNHomePage;
import espnWebPages.NFLHomePage;

public class ESPNTest {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		InitializeTest.initalise();
		driver=InitializeTest.getDriver();
	}
	
	
	@Test
	public void test() 
	{
		
		 ESPNHomePage espnHomePage=PageFactory.initElements(driver, ESPNHomePage.class);
	     NFLHomePage nflHomePage=  espnHomePage.clickOnMenuNFLLink();
	     nflHomePage.clickMenuScoresLink();
	     Assert.assertEquals(driver.getTitle(),"NFL Football Scores - NFL Scoreboard - ESPN - ESPN");
	  

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
		
		
	}
	
	


