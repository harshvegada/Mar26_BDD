package steps;

import base.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class AutomationHooks {

    @Before
    public void beforeScenario() {
        BrowserActions.start("http://34.169.203.84/#/access");
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(BrowserActions.takeScreenshotForAllure(), "image/png", scenario.getName());
            Allure.addAttachment(scenario.getName(), "image/jpeg", new ByteArrayInputStream(BrowserActions.takeScreenshotForAllure()), ".jpg");
        }
        BrowserActions.quitBrowser();
    }
}
