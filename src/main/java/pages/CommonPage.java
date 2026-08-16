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

    public void clickOnFoodApplication() {
        clickOnElement(By.xpath("//button[@data-testid='choose-food']"));
    }

    public void clickOnECommerceApplication() {
        clickOnElement(By.xpath("//button[@data-testid='choose-ecommerce']"));

    }

    public void clickOnButtonNameContains(String buttonTextContains) {
        String locatorvalue = "//button[contains(text(),'%1$s')] | //a[contains(text(),'%1$s')] | //span[contains(text(),'%1$s')]";
        String locator = String.format(locatorvalue, buttonTextContains);
        clickOnElement(By.xpath(locator));
    }

    public void clickOnLabelCheckBox(String labelName) {
        String locatorValue = "//span[text()='%s']";
        String locator = String.format(locatorValue, labelName);
        if (!isElementSelected(By.xpath(locator))) {
            clickOnElement(By.xpath(locator));
        }
    }

    private boolean isElementSelected(By by) {
        return waitForElementVisibility(by).isSelected();
    }

    public boolean isTextDisplayed(String visibleText) {
        String locatorValue = "//*[text()='%s']";
        String locator = String.format(locatorValue, visibleText);
        return isElementDisplayed(By.xpath(locator));
    }

    public void m2() {
        selectByValueText(By.xpath(""), "");
    }

    public void m1(){
        setTextOnElement(By.xpath(""),"");
        clickOnElement(By.xpath(""));
    }
}