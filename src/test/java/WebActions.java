import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * Created by vipsy on 1/14/15.
 */
public class WebActions {
    private static WebDriver driver;
    private Properties prop = null;
    private FileInputStream fp = null;

    WebActions(WebDriver driver) {
        this.driver = driver;
        prop = new Properties();
        try {
            fp = new FileInputStream(System.getProperty("user.dir") + "/src/test/or.properties");
            prop.load(fp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void navigateTo(String url) {
        driver.navigate().to(prop.getProperty(url));
        Assert.assertTrue(driver.getTitle().equals("ESPN: The Worldwide Leader In Sports"));
    }

    public void tearDown() {
        driver.quit();
        driver = null;
    }

    public void clickElement(String locator) {
        WebElement element = getElement(prop.getProperty(locator));
        if (element != null) {
            element.click();
        } else {
            System.out.println("taking screen shot on error");
        }
    }

    public void setData(String locator, String testDate) {
        WebElement element = getElement(prop.getProperty(locator));
        if (element != null) {
            element.sendKeys(testDate);
        } else {
            System.out.println("taking screen shot on error");
        }

    }

    public void verifyPageDisplayed(String pageName) {
        try {
            Assert.assertTrue(driver.getTitle().equals(pageName));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Expected page not displayed");
        }
    }

    /*
    returns element based on the xpath property provided
     */
    private WebElement getElement(String xpath) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(xpath));

        } catch (NoSuchElementException ne) {
            ne.printStackTrace();
        }
        return element;
    }
}
