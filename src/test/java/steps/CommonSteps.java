package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.CommonPage;

public class CommonSteps {

    CommonPage commonPage = new CommonPage();

    @When("user enter {string} in {string} field")
    public void user_enter_in_field(String text, String fieldName) {
        commonPage.enterTextInField(text, fieldName);
    }

    @When("user click on {string} button")
    public void user_click_on_button(String buttonName) {
        commonPage.clickOnButtonName(buttonName);
    }

    @When("user choose {string} application")
    public void user_choose_application(String applicationName) {
        if (applicationName.equalsIgnoreCase("Food Application")) {
            commonPage.clickOnFoodApplication();
        } else {
            commonPage.clickOnECommerceApplication();
        }
    }

    @When("user click on button text contains {string}")
    public void user_click_on_button_text_contains(String buttonTextContains) {
        commonPage.clickOnButtonNameContains(buttonTextContains);
    }

    @When("user click on checkbox having label as {string}")
    public void user_click_on_checkbox_having_label_as(String labelName) {
        commonPage.clickOnLabelCheckBox(labelName);
    }

    @Then("user verify {string} text should be displayed")
    public void user_verify_text_should_be_displayed(String visibleText) {
        Assertions.assertTrue(commonPage.isTextDisplayed(visibleText), "Text is not displayed: " + visibleText);
    }
}
