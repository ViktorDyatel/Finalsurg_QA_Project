package services;

import io.qameta.allure.Step;
import models.User;
import pages.RegistrationPage;


public class RegistrationPageService {

    public static final String URL_REGISTRATION_PAGE = "https://log.finalsurge.com/register.cshtml?page_redirect=%2f";
    public static final String REGISTRATION_FIRST_NAME = "Viktor";
    public static final String REGISTRATION_LAST_NAME = "Dyatel";


    protected RegistrationPage registrationPage = new RegistrationPage();
    protected User user = User.builder().password(System.getProperty("password")).email(System.getProperty("email")).build();


    @Step("Opening registration page and fill all fields, after that click button login")
    public void registration() {
        registrationPage.openRegistrationPage(URL_REGISTRATION_PAGE)
                .fillInFirstName(REGISTRATION_FIRST_NAME)
                .fillInLastName(REGISTRATION_LAST_NAME)
                .fillInEmailRegistration(user.getEmail())
                .fillInPassword(user.getPassword())
                .fillInRetypePassword(user.getPassword())
                .clickCreateNewAccountButton();

    }

    public String getTextErrorMessage() {

        return registrationPage.getTextErrorMessage();
    }
}

