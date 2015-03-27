package pageObjects;

import org.openqa.selenium.WebDriver;

public class ResultPage extends Abstractpage {
	
	public ResultPage(WebDriver driver) {
		super(driver);
	}


	public String getPageTitle() {
		
		return  driver.getTitle();
	}


	

}
