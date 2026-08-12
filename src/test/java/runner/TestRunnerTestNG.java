package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featureFiles",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        dryRun = false,
        tags = "@HC-001"
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
