package steps;

import io.cucumber.java.en.And;
import pages.ProfilePage;

public class ProfileSteps {

    ProfilePage profilePage = new ProfilePage();

    @And("user navigate to profile")
    public void userNavigateToProfile() {
        profilePage.clickOnProfileIcon();
        profilePage.clickOnMyProfileOption();
    }

}
