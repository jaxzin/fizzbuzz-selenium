package ESPN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by cheikhniass1 on 2/17/15.
 */
public class EspnNflScores {
//
    String url = "http://www.nfl.com";
    WebDriver driver = null;
    @BeforeMethod
    public void navigateToespnscores(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyLink() throws InterruptedException{

        driver.navigate().to(url);
        driver.findElement(By.cssSelector(".top-nav.scores-single")).click();


        Thread.sleep(3000);

                String expected = "http://www.nfl.com/scores";
        try {
            Assert.assertEquals("http://www.nfl.com/scores", expected);
        }
        catch (Exception e){
            System.out.println("Couldnt find the specify link");

        }


    }

    @AfterMethod
    public void after(){
        driver.close();
    }

}
