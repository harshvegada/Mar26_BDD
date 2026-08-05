package pages;

import base.BrowserActions;
import constant.FilePaths;
import org.openqa.selenium.By;
import utility.PropertyOperations;

/**
 * OOPS: Method overriding concept is used here to implement waitForPageLoad method in FindFoodPage class.
 * OOPS: Encapsulation concept is used here to keep the locators private and provide public methods to interact with the elements on the page.
 * OOPS: Inheritance concept is used here to extend the CommonPage class and inherit its methods and properties.
 * OOPS: Method overloading concept is used here to provide multiple methods with the same name but different parameters to interact with the elements on the page.
 */
public class LoginPage extends CommonPage {

    PropertyOperations configProperty = new PropertyOperations(FilePaths.CONFIG_FILE_PATH);

    private final String STUDENT_ID_INPUT = "//input[@data-testid='access-student-id']";
    private final String ACCESS_CODE_INPUT = "//input[@data-testid='access-code']";
    private final String CONTINUE_BUTTON = "//button[text()= 'Continue']";
    private final String CHOOSE_FOOD_APP = "//button[@data-testid='choose-food']";
    private final String USER_AUTO_FILL_BUTTON = "//button[@data-testid='roster-fill-customer']";
    private final String OWNER_AUTO_FILL_BUTTON = "//button[@data-testid='roster-fill-owner']";
    private final String ADMIN_AUTO_FILL_BUTTON = "//button[@data-testid='roster-fill-admin']";

    private final String OWNER_ICON = "//button[@data-role='owner']";
    private final String ADMIN_ICON = "//button[@data-role='admin']";

    private final String LOGIN_BUTTON = "//button[@data-testid='login-submit-btn']";

    public void doLoginForCustomer() {
//        System.out.println("STEP - Enter Student id");
//        setTextOnElement(By.xpath(STUDENT_ID_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".STUDENTID"));
//
//        System.out.println("STEP - Enter Access code");
//        setTextOnElement(By.xpath(ACCESS_CODE_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".ACCESSCODE"));
//
//        System.out.println("STEP - Click on continue button");
//        clickOnElement(By.xpath(CONTINUE_BUTTON));
//
//        System.out.println("STEP - Click on Sign In Food link");
//        clickOnElement(By.xpath(CHOOSE_FOOD_APP));

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(By.xpath(USER_AUTO_FILL_BUTTON));

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

        // System.out.println("STEP - Enter password");
        // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

//        System.out.println("STEP - click on login button");
//        clickOnElement(By.xpath(LOGIN_BUTTON));
    }

    public void doLoginForOwner() {
//        System.out.println("STEP - Enter Student id");
//        setTextOnElement(By.xpath(STUDENT_ID_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".STUDENTID"));
//
//        System.out.println("STEP - Enter Access code");
//        setTextOnElement(By.xpath(ACCESS_CODE_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".ACCESSCODE"));
//
//        System.out.println("STEP - Click on continue button");
//        clickOnElement(By.xpath(CONTINUE_BUTTON));
//
//        System.out.println("STEP - Click on Sign In Food link");
//        clickOnElement(By.xpath(CHOOSE_FOOD_APP));
        clickOnElement(By.xpath(OWNER_ICON));

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(By.xpath(OWNER_AUTO_FILL_BUTTON));

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

        // System.out.println("STEP - Enter password");
        // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

//        System.out.println("STEP - click on login button");
//        clickOnElement(By.xpath(LOGIN_BUTTON));
    }

    public void doLoginForAdmin() {
//        System.out.println("STEP - Enter Student id");
//        setTextOnElement(By.xpath(STUDENT_ID_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".STUDENTID"));
//
//        System.out.println("STEP - Enter Access code");
//        setTextOnElement(By.xpath(ACCESS_CODE_INPUT), configProperty.getValue(BrowserActions.getEnv() + ".ACCESSCODE"));
//
//        System.out.println("STEP - Click on continue button");
//        clickOnElement(By.xpath(CONTINUE_BUTTON));
//
//        System.out.println("STEP - Click on Sign In Food link");
//        clickOnElement(By.xpath(CHOOSE_FOOD_APP));

        clickOnElement(By.xpath(ADMIN_ICON));

        System.out.println("STEP - Click on AutoFill & SignIn as customer");
        clickOnElement(By.xpath(ADMIN_AUTO_FILL_BUTTON));

        //System.out.println("STEP - Enter email");
        //driver.findElement(By.xpath("//input[@data-testid='login-email']")).sendKeys("raghu.customer@technocredits.com");

        // System.out.println("STEP - Enter password");
        // driver.findElement(By.xpath("//input[@data-testid='login-password']")).sendKeys("raghuCust@12345");

//        System.out.println("STEP - click on login button");
//        clickOnElement(By.xpath(LOGIN_BUTTON));
    }


    public void doLogin(String appName, String profile) {

    }
}
