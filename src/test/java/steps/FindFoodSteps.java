package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FindFoodPage;

public class FindFoodSteps {

    FindFoodPage findFoodPage = new FindFoodPage();

    @And("user should be navigated to find food page")
    public void user_should_be_navigated_to_find_food_page() {
        System.out.println("VERIFY - User is navigated to Find Food Page");
    }

    @Then("user should see the welcome message")
    public void user_should_see_the_welcome_message() {
        System.out.println("VERIFY - User should see the welcome message");
    }

    @When("user open menu for restaurant {string}")
    public void user_open_menu_for_restaurant(String restaurantName) {

    }
}
