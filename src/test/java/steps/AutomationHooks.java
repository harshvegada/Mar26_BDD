package steps;

import base.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AutomationHooks {

    @Before
    public void beforeScenario() {
        BrowserActions.start("http://34.66.197.232/#/access");
    }

    @After
    public void afterScenario() {
        BrowserActions.quitBrowser();
    }
}
