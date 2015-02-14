package com.zorranlabs.interview.espn;

import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EspnSeleniumTest2 extends TestCase {
    private WebDriver driver;

    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    public void testSimple() throws Exception {
        // WebDriver driver;
        driver.get("http://espn.go.com");

        // Find a link
        WebElement nfl_scores_link = driver.findElement(By.cssSelector("a[href*='http://scores.espn.go.com/nfl/scoreboard']"));
        Assert.assertTrue("http://scores.espn.go.com/nfl/scoreboard link is not found", null != nfl_scores_link);
        System.out.println("Scoreboard link: " + nfl_scores_link.toString());
        nfl_scores_link.click();

        // Get and assert title
        String sScoreboardTitle = driver.getTitle();
        System.out.println("Page title is: " + sScoreboardTitle);
        Assert.assertThat("Verifying scoreboard title", sScoreboardTitle, CoreMatchers.containsString("NFL Scoreboard"));
    }

    public void tearDown() throws Exception {
        // this.driver.quit();
        // Solution came from here: https://code.google.com/p/selenium/issues/detail?id=7506
        try {
            Thread.sleep(5000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
