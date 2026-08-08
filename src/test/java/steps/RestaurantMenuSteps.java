package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.RestaurantMenuPage;

import java.util.List;
import java.util.Map;

public class RestaurantMenuSteps {

    RestaurantMenuPage restaurantMenuPage = new RestaurantMenuPage();
    CommonPage commonPage = new CommonPage();

    @When("user order {string} quantity of {string}")
    public void user_order_entity_of(String quantity, String itemName) {
        restaurantMenuPage.setQuantityOfGivenDish(itemName, quantity);
    }

    @And("user place order with below details")
    public void userPlaceOrderWithBelowDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//        0 -> key=value,key1=value1,
//        1 -> key=value,key2=value2,
//        [
//   list -> 0  (Map)   {quantity=1, foodItem=Dal Tadaka, address=45 ICON, mobileNumber=8905714840, paymentMethod=Card},
//   list -> 1  (Map)   {quantity=1, foodItem=Dal Tadaka, address=45 ICON, mobileNumber=8905714840, paymentMethod=Card}
//        ]

        for (Map<String, String> coloums : rows) {
            String qnty = coloums.get("quantity");
            String foodItem = coloums.get("foodItem");

            restaurantMenuPage.setQuantityOfGivenDish(foodItem, qnty);
        }
        commonPage.clickOnButtonNameContains("Proceed to Checkout");
    }
}
