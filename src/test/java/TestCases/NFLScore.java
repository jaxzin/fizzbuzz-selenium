
package TestCases;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Components.*;

import Components.*;
import PageFactory.ESPNHome;
import PageFactory.NFLScorePage;

import org.openqa.selenium.support.PageFactory;
public class NFLScore {
	
	@Test
	public void first_test() throws InterruptedException{
		// Creating objects for various reference classes
		StartBrowser t1 = new StartBrowser();
		StandardActions st = new StandardActions();
		ESPNHome home = new ESPNHome();
		AppURL app = new AppURL();
		NFLScorePage NFL_SP = new NFLScorePage();
		WebDriver driver = t1.ChromeBrowser();
		
		// Actual script for the NFL--> Score --> Page title validation
		st.OpenURL(driver,app.url );
	//	driver.get("http://www.google.com");
		st.click(driver, home.NFLLink);
		st.WaitForElement(driver, home.NFLScoreLink);
		st.click(driver, home.NFLScoreLink);
		st.VerifyTitle(driver, NFL_SP.NFLScoreTitle);
		
		// closing webdriver after waiting for 5 sec
		Thread.sleep(5000);
		driver.quit();
	}

}
