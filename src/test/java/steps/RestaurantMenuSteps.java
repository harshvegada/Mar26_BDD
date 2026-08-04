package steps;

import io.cucumber.java.en.When;
import pages.RestaurantMenuPage;

public class RestaurantMenuSteps {

    RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();

    @When("user order {string} quantity of {string}")
    public void user_order_entity_of(String quantity, String itemName) {
        restaurantMenuPage.setQuantityOfGivenDish(itemName, quantity);
    }
}
