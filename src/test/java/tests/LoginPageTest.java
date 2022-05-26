package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mainFinalSurgePage;
import services.LoginPageService;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService = new LoginPageService();

    @Test(description = "Login")
    @Description("Fill all fields on page and login")
    public void loginTest(){
        mainFinalSurgePage userProfilePage = loginPageService.login();
        String actualTextOfUserProfilePage = userProfilePage.getDateOfMainPageSection();
        String expectedPageTexts = "View Calendar";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "The actual text of the page does not expected!");
    }

}
