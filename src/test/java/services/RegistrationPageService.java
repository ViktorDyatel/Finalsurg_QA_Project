package services;

import io.qameta.allure.Step;
import models.User;
import pages.RegistrationPage;


public class RegistrationPageService {

    protected RegistrationPage registrationPage = new RegistrationPage();
    protected User user = User.builder().password(System.getProperty("password")).email(System.getProperty("email")).build();


    @Step("Opening registration page and fill all fields, after that click button login")
    public void registration(String urlRegistration, String firstName, String lastName, String emailForRegistration, String passwordForRegistration, String passwordForRegistrationRetype) {
        registrationPage.openRegistrationPage(urlRegistration)
                .fillInFirstName(firstName)
                .fillInLastName(lastName)
                .fillInEmailRegistration(emailForRegistration)
                .fillInPassword(passwordForRegistration)
                .fillInRetypePassword(passwordForRegistrationRetype)
                .clickCreateNewAccountButton();

    }

    public String getTextErrorMessage() {


        return registrationPage.getTextErrorMessage();
    }
}

