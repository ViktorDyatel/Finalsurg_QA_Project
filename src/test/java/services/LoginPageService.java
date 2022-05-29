package services;

import io.qameta.allure.Step;
import models.User;
import pages.LoginPage;
import pages.mainFinalSurgePage;
import utils.AllureUtils;

import static utils.StringConstants.*;


public class LoginPageService {
  protected  LoginPage loginPage = new LoginPage();
    protected User user = new User();

    @Step("Opening login page and fill all fields, after that click button login")
    public mainFinalSurgePage login() {
        loginPage.openPage(URL_LOGIN_PAGE)
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new mainFinalSurgePage();
    }
}
