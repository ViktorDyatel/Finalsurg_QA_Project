package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainFinalSurgePage;
import services.LoginPageService;
import services.RegistrationPageService;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeMethod
    public void setUp() {

        loginPageService = new LoginPageService();
    }

    @Test(description = "LoginPageTest")//, retryAnalyzer = Retry.class )//не работает retry
    @Description("Fill all fields on page and login")
    public void loginTest(){
        User user = EntitiesFactory.getUser();
        MainFinalSurgePage userProfilePage = loginPageService.login(user.getEmail(), user.getPassword());
        String actualTextOfUserProfilePage = userProfilePage.getTextOfMainPageSection();
        String expectedPageTexts = "View Calendar";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "The actual text of the page does not expected!");
    }

    @Test(description = "LoginPageTestWithWrongPassword")//, retryAnalyzer = Retry.class )//не работает retry
    @Description("Fill all fields on page and login")
    public void loginWithWrongPassword(){
        User user = EntitiesFactory.getIncorrectUser();
        loginPageService.login(user.getEmail(), user.getPassword());
        String actualTextOfUserProfilePage = loginPageService.getErrorTextOfLoginPage();
        String expectedPageTexts = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "The actual text of the page does not expected!");
    }

}
