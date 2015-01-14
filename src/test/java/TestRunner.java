import org.junit.Test;

/**
 * Created by vipsy on 1/14/15.
 */
public class TestRunner {

    @Test
    public void runTest() {

        WebDriverFactory actions = new WebDriverFactory("firefox");

        actions.navigateTo("url");
        actions.clickElement("nfl");
        actions.clickElement("scores");
        actions.verifyPageDisplayed("NFL Football Scores - NFL Scoreboard - ESPN - ESPN");
        actions.tearDown();

    }


}
