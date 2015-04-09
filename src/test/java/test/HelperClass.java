package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by ihossain on 4/3/15.
 */
public class HelperClass extends TestBase
{
    //Webdriver wait function
    public static WebElement getWhenVisible(By locator)
    {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        element = wait.until(visibilityOfElementLocated(locator));
        return element;
    }
}
