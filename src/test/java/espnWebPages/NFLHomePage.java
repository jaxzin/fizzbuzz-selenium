package espnWebPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import espnModule.InitializeTest;


public class NFLHomePage extends InitializeTest{
	
	@FindBy(linkText="Scores")
	WebElement MenuScoresLink;
	
	
	public void clickMenuScoresLink()
	{
		MenuScoresLink.click();
	}
	
	

}
