package services;

import io.qameta.allure.Step;
import models.User;
import pages.LoginPage;
import pages.MainFinalSurgePage;

import static utils.StringConstants.*;


public class LoginPageService {


    protected LoginPage loginPage = new LoginPage();


    @Step("Opening login page and fill all fields, after that click button login")
    public MainFinalSurgePage login(String email,String password) {
        loginPage.openPage(URL_LOGIN_PAGE)
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();
        return new MainFinalSurgePage();
    }



    public String getErrorTextOfLoginPage() {

       return loginPage.getErrorTextOfLoginPage();

    }




}
