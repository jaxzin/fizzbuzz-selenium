package org.espn.selenium.test;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPageTitleNflScores{

@ Before
public void setup(){
Webdriver driver = new FirefoxDriver();
driver.get("http://www.espn.go.com/");
Thread.Sleep(500);
}
@Test
public void checkPageTitle() throws Exception{
 WebElement NHL = driver.findElement(By.linkText("NHL"));
 WebElement Scores = (new WebDriverWait(driver, 10))
.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Scores")));
 Scores.click();
 Thread.Sleep(300);
String pageTitle = driver.getTitle();
assertEquals("NFL Scoreboard",pageTitle);
}
@After
public void teardown(){
driver.close();
driver.quit();
}
}

-------------------------------
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestJunit.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println(result.wasSuccessful());
   }
} 
 ==================================================================================
 //Using TestNG  makes it more simple by creating a test and executing that test in an xml file
 
package org.espn.selenium.test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPageTitleNflScores{

@ Before
public void setup(){
Webdriver driver = new FirefoxDriver();
driver.get("http://www.espn.go.com/");
}
@Test
public void checkPageTitle() throws Exception{
 WebElement NHL = driver.findElement(By.linkText("NHL"));
 WebElement Scores = (new WebDriverWait(driver, 10))
.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Scores")));
 Scores.click();
 Thread.Sleep(300);a
String pageTitle = driver.getTitle();
assertEquals("NFL Scoreboard",pageTitle);
}
@After
public void teardown(){
driver.close();
driver.quit();
}
}
----------
<?xml version="1.0" encoding="UTF-8"?>
http://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
  <test name="espntest">
    <classes>
       <class name="CheckPageTitleNflScores"/>
    </classes>
  </test>
</suite>


/*
This is a test created to check the page title of Scores in the espn website.
To Execute these tests and replicate the result
Create a work space for Juint /TestNg{Depends on which testing framework you prefer}

Using Test NG
C:\TestNG_WorkSpace/javac  CheckPageTitleNflScores.java
C:\java -cp "C:\TestNG_WORKSPACE" org.testng.TestNG testng.xml
 // testng.xml is the maven file we created to test include the test case.

Using Junit
C:\Junit_WorkSpace/javac  CheckPageTitleNflScores.java
C:\Junit_WORKSPACE\java TestRunner
*/
