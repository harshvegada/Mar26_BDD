package standAlone;

import base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MissingLinkExample {

    public static void main(String[] args) throws IOException {
        WebDriver driver = BrowserActions.start("file:///C:/Users/Harsh/Downloads/Broken_Link_Form.html");

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        for (WebElement link : links) {
            String linkValue = link.getAttribute("href");
            if (linkValue == null || linkValue.isEmpty()) {
                System.out.println("Missing Link : " + link.getText());
            }
            if (linkValue != null && linkValue.length() > 0) {
                boolean flag = checkIfLinkWorking(linkValue);
                System.out.println(link.getText() + " is working link : " + flag);
            }
        }
        driver.quit();
    }

    static boolean checkIfLinkWorking(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        int statusCode = connection.getResponseCode();
        if (statusCode < 400) {
            return true;
        } else
            return false;
    }
}
