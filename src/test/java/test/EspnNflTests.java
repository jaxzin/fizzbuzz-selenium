package test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ihossain on 4/3/15.
 */
public class EspnNflTests extends TestBase
{
    PageObjects pageObjects = new PageObjects();

    //Assert that the links go to the NFL Scoreboard page
    @Test
    public void test()
    {
        pageObjects.nflLink();
        System.out.println("Clicked on NFL link");

        pageObjects.clickScoresLink();
        System.out.println("Clicked on Scores link");

        Assert.assertEquals("http://espn.go.com/nfl/scoreboard", driver.getCurrentUrl());

        System.out.println("Links successfully navigate to http://espn.go.com/nfl/scoreboard");
    }
}
