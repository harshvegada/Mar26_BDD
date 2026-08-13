package pages;

import org.openqa.selenium.By;

public class ProfilePage extends CommonPage {

    private String PROFILE_ICON = "//button[@id='fd-profile-btn']";
    private String MY_PROFILE_OPTION = "//a[contains(text(),'My Profile')]";

    public void clickOnMyProfileOption() {
        clickOnElement(By.xpath(MY_PROFILE_OPTION));
    }

    public void clickOnProfileIcon() {
        clickOnElement(By.xpath(PROFILE_ICON));
    }
}
