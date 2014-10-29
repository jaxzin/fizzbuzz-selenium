import junit.framework.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.assertTrue;

public class TestMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("http://espn.go.com");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement we1=	driver.findElement(	By.xpath( "html/body/div[5]/div[4]/div[8]/div/div/ul/ul/li[2]/a"));
				  
	
	//we1.sendKeys(new String[]{ "text" });
	//we1.sendKeys( new String[]{ "dusi.pavan@gmail.com" } );
	Actions builder = new Actions(driver); 
	Actions hoverOverRegistrar = builder.moveToElement(we1);
	hoverOverRegistrar.perform();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	WebElement we2=	driver.findElement(	By.xpath( "html/body/div[5]/div[4]/div[8]/div/div/ul/ul/li[2]/div/div[1]/div/div/ul/li[2]/a"));
												//"html/body/div[5]/div[4]/div[8]/div/div/ul/ul/li[2]/div/div[1]/div/div/ul/li[2]/a
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	we2.click();//at last Menu Item Click
	System.out.println("title:"+driver.getTitle());
	String bodyText = driver.getTitle();
	//Assert.assertTrue("NFL Scoreboard title check", bodyText.contains("NFL Scoreboard"));
	Assert.assertTrue(bodyText.contains("NFL Scoreboard"));
	//assertTrue("Verification failed: Element1 and Element2 are not same.",Element1.equals(driver.findElement(By.id(Element2 )).getText()));
	//assertTrue("Verification Passed : title M",Element1.equals(driver.findElement(By.id(Element2 )).getText()));
	}

}
