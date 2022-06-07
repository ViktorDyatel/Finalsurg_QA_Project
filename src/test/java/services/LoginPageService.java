package services;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainFinalSurgePage;

import java.time.Duration;

import static utils.StringConstants.*;


public class LoginPageService {


    protected LoginPage loginPage = new LoginPage();


    @Step("Opening login page and fill all fields, after that click button login")
    public MainFinalSurgePage login(String email,String password, String url) {
        loginPage.openPage(url)
                .fillInEmail(email)
                .fillInPassword(password)
                .clickLoginButton();
        return new MainFinalSurgePage();
    }



    public String getErrorTextOfLoginPage() {

       return  loginPage.getErrorTextOfLoginPage();


    }




}
