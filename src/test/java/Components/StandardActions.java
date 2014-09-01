package Components;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandardActions {

	public void click(WebDriver driver,By locator){
		
		driver.findElement(locator).click();
	}
	
@SuppressWarnings("deprecation")
public void VerifyTitle(WebDriver driver,String ExpectedTitle){
		
		String ActualTitle = driver.getTitle();
		ActualTitle.equals(ExpectedTitle);
		Assert.assertTrue(ActualTitle.equals(ExpectedTitle));
	//	Assert.assertEquals(ExpectedTitle, ActualTitle);
	}


public void OpenURL(WebDriver driver,String URL){
	
	driver.get(URL);
}
public void WaitForElement(WebDriver driver,By locator){
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(locator));

}
}

