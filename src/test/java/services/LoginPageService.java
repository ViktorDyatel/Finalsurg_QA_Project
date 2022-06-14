package services;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MainFinalSurgePage;

public class LoginPageService {

    protected LoginPage loginPage = new LoginPage();

    protected static final String URL_LOGIN_PAGE = "https://log.finalsurge.com/";

    @Step("Opening login page and fill all fields, after that click button login")
    public MainFinalSurgePage login(String email, String password) {
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
