package selenium.fizzbuzz;

import static org.junit.Assert.fail;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucelabs.common.SauceOnDemandAuthentication;

public class FizzbuzzSeleniumClickTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  //Using Firefox Driver
    driver = new FirefoxDriver();
    baseUrl = "http://espn.go.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //Set Up Sauce Lab
    SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("emilyburch", "f52a0166-5b08-466b-850d-6aef91319313");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
    capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
    this.driver = new RemoteWebDriver(
            new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
            capabilities);
  }

  @Test
  public void testFizzbuzzSelenium() throws Exception {
	  //Navigate to espn.go.com
    driver.get(baseUrl);
	  //Click NFL
    driver.findElement(By.name("&lpos=sitenavdefault&lid=sitenav_nfl")).click();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Scores")));
     	//Click Scores
    driver.findElement(By.linkText("Scores")).click();

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
