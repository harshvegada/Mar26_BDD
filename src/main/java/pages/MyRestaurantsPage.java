package pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class MyRestaurantsPage extends CommonPage {


    private String MY_RESTAURANT_TAB = "//a[@data-nav='ownerRestaurants']";
    private String UPLOAD_IMAGE_BUTTON = "//span[text()='Upload / change logo']";


    public void clickOnMyRestaurantsTab() {
        clickOnElement(By.xpath(MY_RESTAURANT_TAB));
    }

    public void rightClickOnRestaurant(String restaurantName) {
        String restaurantElement = "//span[text()='" + restaurantName + "']/ancestor::tr/td[6]/button";
        rightClickOnElement(By.xpath(restaurantElement));
    }

    public void clickOnUploadImage() {
        clickOnElement(By.xpath(UPLOAD_IMAGE_BUTTON));
    }

    public void uploadImage(String imagePath) throws AWTException {

        StringSelection selection = new StringSelection(imagePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();
        robot.delay(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public String getRestaurantImageDetails(String restaurantName) throws InterruptedException {
        Thread.sleep(4000);
        String restaurantImageDetails = "//span[text()='" + restaurantName + "']/preceding-sibling::img";
        return getElementAttribute(By.xpath(restaurantImageDetails),"src");
    }

}
