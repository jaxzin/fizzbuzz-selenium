package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static test.HelperClass.getWhenVisible;

/**
 * Created by ihossain on 4/3/15.
 */
public class PageObjects
{
    //NFL link object
    public void nflLink()
    {
        WebElement link = getWhenVisible(By.name("&lpos=sitenavdefault+sitenav_nfl"));
        link.click();
    }

    //Scores link object
    public void clickScoresLink()
    {
        WebElement link = getWhenVisible(By.name("&lpos=sitenavdefault+nfl_nfl+scoreboard"));
        link.click();
    }
}
