package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Abstractpage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage clickOnScores() {
		driver.findElement(By.id("menu-nfl")).click();
		
		WebElement menu = driver.findElement(By.id("menu-nfl"));
		//Initiate mouse action using Actions class
		Actions builder = new Actions(driver);    
		// move the mouse to the earlier identified menu option
		builder.moveToElement(menu).build().perform();
		// wait for max of 5 seconds before proceeding. This allows sub menu appears properly before trying to click on it
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[4]/div[8]/div/div/ul/ul/li[2]/div/div[1]/div/div/ul/li[3]/a")));  // until this submenu is found
		//identify menu option from the resulting menu display and click
		WebElement menuOption = driver.findElement(By.xpath("/html/body/div[4]/div[4]/div[8]/div/div/ul/ul/li[2]/div/div[1]/div/div/ul/li[3]/a"));
		menuOption.click();
		return new HomePage(driver);
		}



}
