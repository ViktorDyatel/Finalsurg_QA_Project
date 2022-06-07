package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainFinalSurgePage;
import services.LoginPageService;


import static utils.StringConstants.URL_LOGIN_PAGE;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeMethod
    public void setUp() {

        loginPageService = new LoginPageService();
    }

    @Test(description = "LoginPageTestWithCorrectDate")
    @Description("Fill all fields on page and login")
    public void loginTest(){
        User user = EntitiesFactory.getUser();
        MainFinalSurgePage userProfilePage = loginPageService.login(user.getEmail(), user.getPassword(), URL_LOGIN_PAGE);
        String actualTextOfUserProfilePage = userProfilePage.getTextOfMainPageSection();
        String expectedPageTexts = "View Calendar";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User not logged in!");

    }

    @Test(description = "LoginPageTestWithWrongPassword")
    @Description("Fill all fields on page and login")
    public void loginWithWrongPassword(){
        User user = EntitiesFactory.getUserWithIncorrectPassword();
        loginPageService.login(user.getEmail(), user.getPassword(),URL_LOGIN_PAGE);
        String actualTextOfUserProfilePage = loginPageService.getErrorTextOfLoginPage();
        String expectedPageTexts = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User logged in with wrong password!");
    }

    @Test(description = "LoginPageTestWithWrongEmail")
    @Description("Fill all fields on page and login")
    public void loginWithWrongEmail(){
        User user = EntitiesFactory.getUserWithIncorrectEmail();
        loginPageService.login(user.getEmail(), user.getPassword(),URL_LOGIN_PAGE);
        String actualTextOfUserProfilePage = loginPageService.getErrorTextOfLoginPage();
        String expectedPageTexts = "Invalid login credentials. Please try again.";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "User logged in with wrong email");
    }

}
