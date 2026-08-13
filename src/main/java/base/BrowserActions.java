package base;

import customexception.BrowserInvalidException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * OOPS: Method overloading - Same method name but different parameters
 * OOPS: Encapsulation - Hiding the implementation details and providing a public interface for interaction
 * OOPS: Abstraction - Abstract class providing a blueprint for browser actionsThreadLocal without exposing implementation details
 */


public abstract class BrowserActions {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waitThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<Actions> actionsThreadLocal = new ThreadLocal<>();

//    private BrowserActions(){}

    public static WebDriver start() {
        return start(getBrowserName(), "http://automationbykrishna.com");
    }

    protected WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    protected void mouseHoverAndClick(WebElement mouseHoverElement, WebElement clickElement) {
        actionsThreadLocal.get().moveToElement(mouseHoverElement).click(clickElement).clickAndHold(clickElement).perform();
    }

    public static WebDriver start(String url) {
        return start(getBrowserName(), url);
    }

    public static String getBrowserName() {
        String browser = System.getProperty("browser");
        browser = browser == null ? "chrome" : browser;
        System.out.println("Browser =============> " + browser.toUpperCase());
        return browser.toUpperCase();
    }

    public static String getExecutionMode() {
        String executionMode = System.getProperty("executionMode");//Headless or Headed
        executionMode = executionMode == null ? "" : executionMode;
        System.out.println("Execution Mode =============> " + executionMode.toUpperCase());
        return executionMode.toUpperCase();
    }

    public static WebDriver start(String browser, String url) {
        System.out.println("STEP - Launch browser & hit url");
        String mode = getExecutionMode();
        switch (browser.toUpperCase()) {
            case "CHROME":
                ChromeOptions option = new ChromeOptions();
//                if (mode.length() != 0) {
//                    option.addArguments("--headless");
//                }
                option.addArguments("--start-maximized");
                driverThreadLocal.set(new ChromeDriver(option));
                break;

            case "EDGE":
                driverThreadLocal.set(new EdgeDriver());
                break;

            case "FIREFOX":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driverThreadLocal.set(new FirefoxDriver());
                break;

            default:
                throw new BrowserInvalidException("Given browser not supported");
        }

//        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get(url);
//		driverThreadLocal.manage().window().maximize();
        waitThreadLocal.set(new WebDriverWait(driverThreadLocal.get(), Duration.ofSeconds(16)));
        actionsThreadLocal.set(new Actions(driverThreadLocal.get()));
        //driverThreadLocal.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driverThreadLocal.get();
    }

    protected WebElement waitForElementVisibility(By by) {
        return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilElementMoreThen(By by, int num) {
        waitThreadLocal.get().until(ExpectedConditions.numberOfElementsToBeMoreThan(by, num));
    }

    protected WebElement waitForElementVisibility(By by, boolean shouldWait) {
        if (shouldWait)
            return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(by));
        else
            return driverThreadLocal.get().findElement(by);
    }

    protected WebElement waitForElementVisibility(WebElement element, boolean shouldWait) {
        if (shouldWait)
            return waitThreadLocal.get().until(ExpectedConditions.visibilityOf(element));
        else
            return element;
    }

    protected List<WebElement> waitForAllElementVisibility(By by) {
        return waitThreadLocal.get().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitForElementToBe(By by, int num) {
        waitThreadLocal.get().until(ExpectedConditions.numberOfElementsToBe(by, num));
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return waitThreadLocal.get().until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return waitThreadLocal.get().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForElementVisibility(String locatorType, String locator) {
        switch (locatorType.toUpperCase()) {
            case "XPATH":
                return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            case "ID":
                return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

            case "NAME":
                return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));

            case "LINKTEXT":
                return waitThreadLocal.get().until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));

        }
        return null;
    }

    public static void quitBrowser() {
        driverThreadLocal.get().quit();
    }

    public static void takeScreenshot(String methodName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driverThreadLocal.get();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(srcFile, new File(String.format(FilePaths.FAILED_TEST_CASES, methodName)));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

//    public static byte[] takeScreenshotForAllure() {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driverThreadLocal;
//        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
//    }

    public static byte[] takeScreenshotForAllure() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driverThreadLocal.get();
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

    protected void setTextOnElement(WebElement element, String text) {
        WebElement ele = waitForElementVisibility(element, true);
        if (ele.isEnabled())
            ele.sendKeys(text);
        else
            throw new ElementNotInteractableException("Element is not interactable");
    }

    protected void setTextOnElement(By by, String text) {
        waitForElementVisibility(by, true).sendKeys(text);
    }

    protected void clearTextOnElement(By by) {
        waitForElementVisibility(by, true).clear();
    }

    protected void clickOnElement(WebElement element) {
        waitForElementToBeClickable(element).click();
    }

    protected void clickOnElement(By by) {
//        waitForElementToBeClickable(by).click();
        waitUntilPageLoad();
        try {
            Thread.sleep(1000); // Adding a small delay to ensure the element is ready for interaction
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForElementVisibility(by).click();
    }

    protected List<String> getAllOptionsFromDropDown(By by) {
        Select select = new Select(waitForElementVisibility(by));
        List<WebElement> elementList = select.getOptions();
        List<String> options = new ArrayList<>();
        for (WebElement element : elementList) {
            options.add(element.getText());
        }
        return options;
    }

    protected List<WebElement> getAllElements(By by) {
        return waitForAllElementVisibility(by);
    }

    protected int getSizeOfElements(By by) {
        return getAllElements(by).size();
    }

    protected void selectByVisibleText(By by, String dropDownVisibleText) {
        Select locationSelect = new Select(waitForElementVisibility(by));
        locationSelect.selectByVisibleText(dropDownVisibleText);
    }

    protected void selectByValueText(By by, String dropDownVisibleText) {
        Select locationSelect = new Select(waitForElementVisibility(by));
        locationSelect.selectByValue(dropDownVisibleText);
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return waitForElementVisibility(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(By by, boolean shouldWait) {
        try {
            if (shouldWait) {
                return waitForElementVisibility(by).isDisplayed();
            } else {
                return driverThreadLocal.get().findElement(by).isDisplayed();
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String getTextFromElement(By by) {
        return waitForElementVisibility(by).getText().trim();
    }

    protected void waitUntilWindowsCount(int windowsCount) {
        waitThreadLocal.get().until(ExpectedConditions.numberOfWindowsToBe(windowsCount));
    }

    protected void switchToWindowByTitle(String windowTitle) {
        Set<String> allWindowHandleIds = driverThreadLocal.get().getWindowHandles();

        for (String id : allWindowHandleIds) {
            driverThreadLocal.get().switchTo().window(id);
            String currentTitle = driverThreadLocal.get().getTitle();
            if (currentTitle.equals(windowTitle)) {
                break;
            }
        }
    }

    protected String getPageTitle() {
        return driverThreadLocal.get().getTitle();
    }

    protected String getElementAttribute(By by, String attributeName) {
        return waitForElementVisibility(by).getAttribute(attributeName);
    }

    public static String getEnv() {
        String env = System.getProperty("environment");
        env = env == null ? "QA" : env; //To Handle when stand alone script runs
        System.out.println("Env =============> " + env.toUpperCase());
        return env.toUpperCase();
    }

    protected void rightClickOnElement(By by) {
        WebElement element = waitForElementVisibility(by);
        actionsThreadLocal.get().contextClick(element).build().perform();
    }

    public void waitUntilPageLoad() {
        Wait<WebDriver> wait = new FluentWait<>(driverThreadLocal.get())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(driver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            while(!js.executeScript("return document.readyState").toString().equals("complete")) {
                System.out.println("Waiting for page to load...");
            }
            return null;
        });
    }
}
