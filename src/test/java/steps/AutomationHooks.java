package steps;

import base.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AutomationHooks {

    @Before
    public void beforeScenario() {
        BrowserActions.start("http://34.169.203.84/#/access");
    }

    @After
    public void afterScenario() {
//        BrowserActions.quitBrowser();
    }
}
