package pages;

import org.openqa.selenium.By;


/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class PaymentPage extends CommonPage {

    private static final String UPI_TAB = "//button[@data-testid='pm-tab-UPI']";
    private static final String NETBANKING_TAB = "//button[@data-testid='pm-tab-NetBanking']";
    private static final String CARD_TAB = "//button[@data-testid='pm-tab-Card']";

    private final String PAY_PLACE_ORDER_BTN = "//button[@id='pay-btn']";
    private final String TOTAL_PAYABLE = "//span[@data-testid='payment-total']";
    private final String ERROR_CAPTCHA_MSG = "//p[text()='Please confirm the captcha before paying']";
    private final String CAPTCHA_CHECKBOX = "//input[@id='pay-captcha']";
    private final String UPI_ID_ERROR_MSG = "//p[text()='UPI ID is required']";
    private final String UPI_ID_INPUT = "//input[@id='f-upi']";

    public void waitForPageLoad() {
        waitForElementVisibility(By.xpath(PAY_PLACE_ORDER_BTN));
    }

    public void clickOnPayPlaceOrderBtn() {
        clickOnElement(By.xpath(PAY_PLACE_ORDER_BTN));
    }

    public String getTotalPayable() {
        String totalPayable = getTextFromElement(By.xpath(TOTAL_PAYABLE));
        return totalPayable;
    }

    public boolean isErrorCaptaDisplayed() {
        return isElementDisplayed(By.xpath(ERROR_CAPTCHA_MSG));
    }

    public void clickOnCaptaCheckbox() {
        clickOnElement(By.xpath(CAPTCHA_CHECKBOX));
    }


    public boolean isUPIIdErrorNotificationDisplayed() {
        return isElementDisplayed(By.xpath(UPI_ID_ERROR_MSG));
    }

    public void setUPIId(String upiId) {
        setTextOnElement(By.xpath(UPI_ID_INPUT), upiId);
    }

    public void makePaymentUsing(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("UPI")) {
            clickOnElement(By.xpath(UPI_TAB));
            makePaymentUsingUPI();
        } else if (paymentMethod.equalsIgnoreCase("Card")) {
            clickOnElement(By.xpath(CARD_TAB));
            makePaymentUsingCard();
        } else if (paymentMethod.equalsIgnoreCase("Net Banking")) {
            clickOnElement(By.xpath(NETBANKING_TAB));
            makePaymentUsingNetbanking();
        }
    }

    public void makePaymentUsingUPI() {
        setTextOnElement(By.xpath(UPI_ID_INPUT), "harshhpatel07@okicici");
    }

    public void makePaymentUsingCard() {
        setTextOnElement(By.xpath("//input[@id='f-card']"), "1234 5678 9012 3456");
        setTextOnElement(By.xpath("//input[@id='f-expiry']"), "12/25");
        setTextOnElement(By.xpath("//input[@id='f-cvv']"), "123");
    }

    public void makePaymentUsingNetbanking() {
        setTextOnElement(By.xpath("//input[@id='f-nbuser']"), "hdfcadmin");
        setTextOnElement(By.xpath("//input[@id='f-nbpass']"), "technocredits");
        clickOnElement(By.xpath("//button[text()='Authenticate']"));
    }
}
