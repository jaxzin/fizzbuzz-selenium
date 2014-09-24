package com.core.testcase;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FizzbuzzSeleniumClick {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  //Using Firefox Driver
    driver = new FirefoxDriver();
    baseUrl = "http://espn.go.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFizzbuzzSelenium() throws Exception {
	  //Navigate to espn.go.com
    driver.get(baseUrl);
	  //Click NFL
    driver.findElement(By.name("&lpos=sitenavdefault&lid=sitenav_nfl")).click();
	  //Click Scores
    driver.findElement(By.linkText("Scores")).click();
	  //Assert page title is NFL Scoreboard
    assertEquals("NFL Football Scores - NFL Scoreboard - ESPN - ESPN", driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
