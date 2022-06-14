package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.RegistrationPageService;

import static services.RegistrationPageService.URL_REGISTRATION_PAGE;

public class RegistrationPageTest extends BaseTest {

    public static final String REGISTRATION_FIRST_NAME = "Viktor";

    public static final String REGISTRATION_LAST_NAME = "Dyatel";

    private RegistrationPageService registrationPageService;

    @BeforeClass
    public void setUp() {
        registrationPageService = new RegistrationPageService();
    }

    @Test(description = "RegistrationPageTest")
    @Description("Filling in all fields and pressing the register button")
    public void registrationTest() {
        User user = EntitiesFactory.getUser();
        registrationPageService.registration(URL_REGISTRATION_PAGE, REGISTRATION_FIRST_NAME, REGISTRATION_LAST_NAME, user.getEmail(), user.getPassword(), user.getPassword());
        String actualTextOfNewRegistrationPage = registrationPageService.getTextErrorMessage();
        String expectedPageTexts = "Error: There is already a user account associated with this Email Address. Please retrieve your password or create an account with a different address.";
        Assert.assertEquals(actualTextOfNewRegistrationPage, expectedPageTexts, "User registered with the same email");
    }

}

