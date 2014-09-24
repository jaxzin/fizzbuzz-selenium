package com.core.testcase;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzbuzzSeleniumHover {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	//Use Firefox driver
    driver = new FirefoxDriver();
    baseUrl = "http://espn.go.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFizzbuzzSeleniumJava() throws Exception {
	//Go to espn.go.com
    driver.get(baseUrl);
    //Hover over menu (NFL)
    Actions actions = new Actions(driver);
    WebElement menuHoverLink = driver.findElement(By.name("&lpos=sitenavdefault&lid=sitenav_nfl"));
    actions.moveToElement(menuHoverLink).perform();
    
    //Click sublink (Scores)
    WebElement subLink = driver.findElement(By.name("&lpos=sitenavdefault&lid=nfl_scores"));
    actions.moveToElement(subLink);
    actions.click();
    actions.perform();
    
    try {
    	//Test for title NFL Scoreboard. Fail fast if not validated
        WebElement el =  driver.findElement(By.className("section-title"));
        String strng = el.getText();
        Assert.assertEquals("NFL Scoreboard", strng);
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @After
  //Close window and write error to string
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

