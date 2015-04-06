package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ihossain on 4/3/15.
 */
public class TestBase
{
    static WebDriver driver;

    //Start driver
    @Before
    public void setUp()
    {
        //start ff driver
        driver = new FirefoxDriver();
        //go to url
        driver.get("http://espn.go.com");
        //maximize window
        driver.manage().window().maximize();
    }

    //Tear down function to quit driver, print console errors, or take screenshots on error
    @After
    public void tearDown()
    {
        driver.quit();
    }



    /*
     * The following are functions that I use in my testing to check for console errors
     * and record screenshots if there are failures in the tests
     */

    //Method to check for console errors
//    public void getConsoleErrors()
//    {
//        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//        for (LogEntry entry : logEntries)
//        {
//            if (entry.getLevel() == Level.SEVERE)
//            {
//                System.out.println(entry.getLevel() + " " + entry.getMessage());
//                try
//                {
//                    assertNull(entry);
//                }
//                catch (AssertionFailedError e)
//                {
//                    driver.quit();
//                    throw e;
//                }
//            }
//            else
//            {
//                System.out.println(entry.getLevel() + " " + entry.getMessage());
//            }
//        }
//    }

    //Take screenshot on fail
//    @Rule
//    public TestRule testWatcher = new TestWatcher()
//    {
//        @Override
//        public void failed(Throwable e, Description test)
//        {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
////            String dir = "/qa/var/screenshots/errorScreenshots/";
//            String dir = "target/surefire-reports/";
//            String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
//            String timeStamp = new SimpleDateFormat("_HHmmss").format(Calendar.getInstance().getTime());
//            String formattedPathOfTest = test.getClassName().replace("smartasset.tests.", "") + "." + test.getMethodName();
//            String fileName = dir + formattedPathOfTest + timeStamp + ".jpg";
////                    dir + date + "/" + formattedPathOfTest + timeStamp + ".jpg";
//            try
//            {
//                FileUtils.copyFile(scrFile, new File(fileName));
//                System.out.println("Screenshot of error: " + fileName);
//            }
//            catch (IOException e1)
//            {
//                e1.printStackTrace();
//            }
//        }
//
//        //Check for console errors and quit driver
//        @Override
//        protected void finished(Description description)
//        {
////            getConsoleErrors();
//            driver.quit();
//        }
//    };
}
