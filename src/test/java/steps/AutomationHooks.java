package steps;

import base.BrowserActions;
import constant.FilePaths;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utility.PropertyOperations;

import java.io.ByteArrayInputStream;

public class AutomationHooks {

    PropertyOperations propertyOperations = new PropertyOperations(FilePaths.CONFIG_FILE_PATH);

    @Before
    public void beforeScenario() {
        String environment = System.getProperty("environment");
        if (environment == null || environment.isEmpty()) {
            environment = "QA"; // default environment
        }
        BrowserActions.start(propertyOperations.getValue(environment + ".URL"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(BrowserActions.takeScreenshotForAllure(), "image/png", scenario.getName());
            Allure.addAttachment(scenario.getName(), "image/jpeg", new ByteArrayInputStream(BrowserActions.takeScreenshotForAllure()), ".jpg");
        }
//        BrowserActions.quitBrowser();
    }
}
