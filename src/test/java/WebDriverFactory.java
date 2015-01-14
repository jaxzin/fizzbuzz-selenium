import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by vipsy on 1/14/15.
 */
public class WebDriverFactory extends WebActions {

    private static WebDriver driver = null;

    public WebDriverFactory(String browserType) {
        super(getDriver(browserType));
    }

    /*
    Method returns driver based on the browser type provided
     */

    private static WebDriver getDriver(String browserType) {
        if (driver == null) {
            if (browserType.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else if (browserType.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
