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

public class CheckPageTitleNflScoresTestng{

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
