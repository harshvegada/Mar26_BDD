package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class RestaurantMenuPage extends CommonPage {

    private final String PROCEED_TO_CHECKOUT_BTN = "//button[@data-testid='proceed-checkout-btn']";
    private final String RESTAURANT_NAME = "//h2[@data-testid='restaurant-name']";
    private final String FIRST_AVAILABLE_DISH = "(//table[@data-testid='menu-table']/tbody/tr/td[4][text()!='0'])[1]/preceding-sibling::td[3]/div/div/div[1]";
    private final String DISH_QUANTITY_INPUT = "//div[text()='%s']/following::input[@type='number'][1]";
    private final String SUB_TOTAL = "//strong[@id='ot-subtotal']";

    public void waitForPage() {
        waitForElementVisibility(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public void clickOnProceedToCheckout() {
        clickOnElement(By.xpath(PROCEED_TO_CHECKOUT_BTN));
    }

    public String getRestaurantName() {
        String restaurantName = getTextFromElement(By.xpath(RESTAURANT_NAME));
        return restaurantName;
    }

    public String getFirstAvailableDish() {
        String firstAvailableDish = getTextFromElement(By.xpath(FIRST_AVAILABLE_DISH));
        return firstAvailableDish;
    }

    public void setQuantityOfGivenDish(String dish, int quantity) {
        clickOnElement(By.xpath(String.format(DISH_QUANTITY_INPUT, dish)));
        for (int count = 1; count <= quantity; count++) {
            actionsThreadLocal.get().sendKeys(Keys.ARROW_UP).perform();
        }
    }

    public void setQuantityOfGivenDish(String dish, String quantity) {
        clickOnElement(By.xpath(String.format(DISH_QUANTITY_INPUT, dish)));
        clearTextOnElement(By.xpath(String.format(DISH_QUANTITY_INPUT, dish)));
        setTextOnElement(By.xpath(String.format(DISH_QUANTITY_INPUT, dish)), quantity);
    }

    public String getSubTotal() {
        String totalPayableAmt = getTextFromElement(By.xpath(SUB_TOTAL));
        return totalPayableAmt;
    }
}
