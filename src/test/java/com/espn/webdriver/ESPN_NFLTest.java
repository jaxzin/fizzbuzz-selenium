package com.espn.webdriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ESPN_NFLTest {
	public WebDriver driver;
	 
	 
	  @BeforeMethod
	  public void beforeMethod() {
		  //Initializing WebDriver
		  String PathtoChromeDriver = "C://Users//spawa1//selenium//chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",PathtoChromeDriver );
		  driver = new ChromeDriver();
	      }
	  
	  /**
		 * NAME: verify NFL Sport navigation 
		 * <P>
		 * DESCRIPTION: Validates NFL ScoreBoard link navigates to expected NFL Scores Page.
		 * 
		 * NOTE: 
		 * a] Test use TestNG framework.
		 * b] Require Selenium libraries
		 * c] Require Path to Chrome Driver
		 */
	  @Test
	  public void navigationtoNFLScoreBoardTest() {
	   //Navigating to ESPN home Page.
		driver.navigate().to("http://espn.go.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Verifying Home page Logo");
		String ESPN_Title = driver.findElement(By.cssSelector(".espn-logo")).getText();
		Assert.assertEquals(ESPN_Title, "ESPN"," Verify ESPN Header is Displayed");
		
		//Wait for NFL option is Clickable.
		WebElement NFL_GlobalNav = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#nfl-event']")));
		System.out.println("Clicking NFL Menu option");
		NFL_GlobalNav.click();

      //Wait for NFL ScoreBoard link		
		WebElement NFL_ScoreBoardLink = (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fullLink")));
		System.out.println("Clicking NFL ScoreBoard Link");
		NFL_ScoreBoardLink.click();
		
		//OnClick is navigated to Expected Url
		System.out.println("Validating Navigated Url");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl.contains("nfl/scoreboard"), true, "Verify current url contains NFL scoreboard text");

		System.out.println("Validating Title and Link Status");
		//Verify NFL ScoreBoard Page Title 
		String NFL_ScoreBoard_Title = driver.findElement(By.cssSelector(".espn-logo .section-title")).getText();
		Assert.assertEquals(NFL_ScoreBoard_Title, "NFL Scoreboard"," Verify ESPN NFL ScoreBoard Header is Displayed");
	 
		//Verify NFL menu is selected
		WebElement NFL_Menu = driver.findElement(By.cssSelector("#menu-nfl"));
		String Nflclass = NFL_Menu.getAttribute("class");
		Assert.assertEquals(Nflclass.contains("selected"), true," NFL menu is Selected");

		//Verify  NFL Scores sub-menu is active
		WebElement NFLScore_SubMenu = driver.findElement(By.cssSelector(".nav-main-secondary>ul>li.active>a"));
		Assert.assertEquals(NFLScore_SubMenu.getText(), "Scores"," Verify Scores submenu is active");
		}
	 
	 
	  @AfterMethod
	  public void afterMethod() {
	    driver.quit();
	   }

}
