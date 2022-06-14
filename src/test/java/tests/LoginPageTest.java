package tests;


import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainFinalSurgePage;
import services.LoginPageService;


public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    private MainFinalSurgePage mainFinalSurgePage;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        mainFinalSurgePage = new MainFinalSurgePage();
    }

    @Test(description = "LoginPageTestWithCorrectData", priority = 1)
    @Description("Fill all fields on page and login")
    public void loginTest() {
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
        String actualTextOfUserProfilePage = mainFinalSurgePage.getTextOfMainPageSection();
        String expectedPageTexts = "View Calendar";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User not logged in!");
    }

    @Test(description = "LoginPageTestWithWrongEmail")
    @Description("Fill all fields on page and login")
    public void loginWithWrongEmail() {
        User user = User.builder().password("423424235").email(System.getProperty("email")).build();
        loginPageService.login(user.getEmail(), user.getPassword());
        String actualTextOfUserProfilePage = loginPageService.getErrorTextOfLoginPage();
        String expectedPageTexts = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User logged in with wrong email");
    }

    @Test(description = "LoginPageTestWithWrongPassword")
    @Description("Fill all fields on page and login")
    public void loginWithWrongPassword() {
        User user = User.builder().password("423424235").email(System.getProperty("email")).build();
        loginPageService.login(user.getEmail(), user.getPassword());
        String actualTextOfUserProfilePage = loginPageService.getErrorTextOfLoginPage();
        String expectedPageTexts = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User logged in with wrong password!");
    }

}
