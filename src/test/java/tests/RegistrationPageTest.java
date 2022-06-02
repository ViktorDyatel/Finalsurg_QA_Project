package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.RegistrationPageService;

public class RegistrationPageTest extends BaseTest{


    private RegistrationPageService registrationPageService;

    @BeforeClass
    public void setUp() {

        registrationPageService = new RegistrationPageService();
    }

    @Test(description = "RegistrationPageTest")
    @Description("Fill all fields on page and login")
    public void registrationTest(){
        registrationPageService.registration();
        String actualTextOfNewRegistrationPage = registrationPageService.getTextErrorMessage();
        String expectedPageTexts = "Error: There is already a user account associated with this Email Address. Please retrieve your password or create an account with a different address.";
        Assert.assertEquals(actualTextOfNewRegistrationPage, expectedPageTexts, "The actual text of the page does not expected!");
    }

}

