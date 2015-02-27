package espnTest;
/*
 * Firefox 35
 * selenium-server-standalone-2.44.0.jar
 * 
 * Note I am still integration Saucelab
 * I am not using Maven which would import dependencies used by Saucelab
 * that will come next.
 * I am using Ant which I wanted to try
 */
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import com.saucelabs.junit.Parallelized;
//import com.saucelabs.junit.ConcurrentParameterized;
//import com.saucelabs.junit.SauceOnDemandTestWatcher;

public class Test_NavEspn {
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private String browserName = "firefox"; //firefox, chrome, internet explorer, safari, opera, iPad, iPhone, android
	  private String osName =  "MAC";          // MAC, WIN8, XP, WINDOWS, ANY, ANDROID
//	  public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("rduvalXXXX", "XXX87483-1bfd-4635-87a6-7b90546396c9");

	  @Before
	  public void setUp() throws Exception {
	/* Links on capabilities
	 * https://code.google.com/p/selenium/wiki/DesiredCapabilities
	 * http://www.browserstack.com/automate/capabilities
	 */
		  
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName );
       capabilities.setCapability(CapabilityType.PLATFORM, osName);
       capabilities.setCapability("name", "Test_NavEspn");
       driver = new FirefoxDriver();
       baseUrl = "http://espn.go.com/";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testEspn() throws Exception {
	    homePage(driver,baseUrl);
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("ESPN: The Worldwide Leader In Sports".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("ESPN: The Worldwide Leader In Sports", driver.getTitle());
	    driver.findElement(By.linkText("NFL")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("NFL Football Teams, Scores, Stats, News, Standings, Rumors - National Football League - ESPN".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertEquals("NFL Football Teams, Scores, Stats, News, Standings, Rumors - National Football League - ESPN", driver.getTitle());
	    driver.findElement(By.linkText("Scores")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("NFL Football Scores - NFL Scoreboard - ESPN - ESPN".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

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

