package test;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import pageObjects.ResultPage;

public class NFLScoreTest {

	WebDriver driver;
	@Before
	public void testSetUp()
	{
		driver = new FirefoxDriver();
	}
	@After
	public void testShutDown()
	{
		driver.close();
	}
	
	@Test
	public void nflScoreTest()
	{
		HomePage onHomePage = new HomePage(driver);
		onHomePage.navigateToApp();
		onHomePage.clickOnScores();
		ResultPage onresultPage = new ResultPage(driver);
		Assert.assertEquals(onresultPage.getPageTitle(), "NFL Scoreboard");
	}
}
