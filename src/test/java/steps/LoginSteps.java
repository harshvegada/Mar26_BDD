package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("STEP - Navigate to login page");
    }

    @When("user enter valid username")
    public void user_enter_valid_username() {
        System.out.println("STEP - Enter valid username");
    }

    @Given("user enter valid password")
    public void user_enter_valid_password() {
        System.out.println("STEP - Enter valid password");
    }

    @Then("user click on sign in button")
    public void user_click_on_sign_in_button() {
        System.out.println("STEP - Click on sign in button");
    }

    @When("user enter invalid username")
    public void user_enter_invalid_username() {
        System.out.println("STEP - Enter invalid username");
    }

    @When("user enter invalid password")
    public void user_enter_invalid_password() {
        System.out.println("STEP - Enter invalid password");
    }


    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        System.out.println("VERIFY - User is navigated to login page");
    }

    @When("user enter {string} credentials")
    public void user_enter_credentials(String profile) {
        System.out.println("STEP - Enter " + profile + " credentials");
    }

    @When("user login with {string} credentials")
    public void user_login_with_credentials(String profile) {
        if(profile.equalsIgnoreCase("customer")){
            loginPage.doLoginForCustomer();
        } else if (profile.equalsIgnoreCase("owner")) {
            loginPage.doLoginForOwner();
        } else if (profile.equalsIgnoreCase("admin")) {
            loginPage.doLoginForAdmin();
        }
    }

    @And("user login to {string} application with {string} credentials")
    public void userLoginToApplicationWithCredentials(String appName, String profile) {
        loginPage.doLogin(appName, profile);
    }
}
