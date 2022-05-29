package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mainFinalSurgePage;
import services.LoginPageService;
import utils.Retry;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService = new LoginPageService();

    @Test(description = "LoginPageTest")//, retryAnalyzer = Retry.class )//не работает retry
    @Description("Fill all fields on page and login")
    public void loginTest(){
        mainFinalSurgePage userProfilePage = loginPageService.login();
        String actualTextOfUserProfilePage = userProfilePage.getTextOfMainPageSection();
        String expectedPageTexts = "Viw Calendar";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "The actual text of the page does not expected!");
    }

}
