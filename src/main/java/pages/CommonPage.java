package pages;

import base.BrowserActions;
import org.openqa.selenium.By;


/**
 * Method overriding concept is used here to implement waitForPageLoad method in CommonPage class.
 */
public class CommonPage extends BrowserActions {


    public void waitForPageLoad() {
    }

    public void enterTextInField(String text, String fieldName) {
//        String locator = "//span[text()='" + fieldName + "']/following-sibling::input";
        String locatorString = "//*[text()='%1$s']/following-sibling::input | //*[text()='%1$s']/following-sibling::textarea";
        String locator = String.format(locatorString, fieldName);
        setTextOnElement(By.xpath(locator), text);
    }

    public void clickOnButtonName(String buttonName) {
        String locatorvalue = "//button[text()='%1$s'] | //a[text()='%1$s']";
        String locator = String.format(locatorvalue, buttonName);
        clickOnElement(By.xpath(locator));
    }

    public void clickOnFoodApplication(){
        clickOnElement(By.xpath("//button[@data-testid='choose-food']"));
    }

    public void clickOnECommerceApplication(){
        clickOnElement(By.xpath("//button[@data-testid='choose-ecommerce']"));

    }
}