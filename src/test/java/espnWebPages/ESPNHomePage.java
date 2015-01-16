package espnWebPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import espnWebPages.NFLHomePage;

import espnModule.InitializeTest;

public class ESPNHomePage  {
	
	
	@FindBy(xpath ="//li[@id='menu-nfl']/a")
	WebElement MenuNFLLink;
	
	
	
	public NFLHomePage clickOnMenuNFLLink()
	{
		MenuNFLLink.click();
		return PageFactory.initElements(InitializeTest.getDriver(), NFLHomePage.class);
	}

}
