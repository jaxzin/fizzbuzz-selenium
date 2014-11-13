fizzbuzz-selenium
=================

This is a QA engineering example. Please perform the following steps:

1. [Fork this repository](https://help.github.com/articles/fork-a-repo)
1. [Create a new branch](https://github.com/blog/1377-create-and-delete-branches)
1. Implement a simple interaction test with Selenium against espn.go.com.
  1. Your test should navigate to NFL > Scores link, click on it, and validate the browser is now on a page titled "NFL Scoreboard".
1. [Create a pull request](https://help.github.com/articles/creating-a-pull-request) and include instructions in the summary on how to run the test and replicate your results.
1. [Setup your fork for continuous integration](http://docs.travis-ci.com/user/languages/java/) using https://travis-ci.org/ and then update this README so it [includes the Travis build status image](http://docs.travis-ci.com/user/status-images/).

==============================
Hi,

I create a Maven Java Project with TestNg and this project will run with simply maven command (mvn test).

Test result will store in 'test-output/index.html'

Selenium code for validating page title
===============================================

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver; import org.openqa.selenium.firefox.FirefoxDriver; import org.testng.Assert; import org.testng.annotations.AfterMethod; import org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;

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
}

@Test
public void main() {

    // Navigate to http://espn.go.com
    driver.navigate().to("http://espn.go.com");

    //Validate current page title is not "NFL Scoreboard".
    Assert.assertFalse(driver.getTitle().equals("NFL Scoreboard"));

}

@AfterMethod
public void afterMethod(){

    //Close current browser
    driver.close();
}
}

Thanks Kamolesh