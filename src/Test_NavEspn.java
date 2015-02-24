/*
Test_NavEspn.java * Firefox 35
 * selenium-server-standalone-2.44.0.jar
 * 
 */
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_NavEspn {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://espn.go.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testEspn() throws Exception {
	    driver.get(baseUrl);
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

