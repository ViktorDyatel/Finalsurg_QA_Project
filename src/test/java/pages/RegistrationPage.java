package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    @FindBy(xpath = "//input[@id='create_first']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='create_last']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='create_email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@id='password_meter']")
    private WebElement passwordAtRegistration;

    @FindBy(xpath = "//input[@id='create_passwordmatch']")
    private WebElement reTypePasswordAtRegistration;

    @FindBy(xpath = "//button[@class='btn btn-beoro-1']")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement alertError;

    public String getTextErrorMessage() {

        return alertError.getText();
    }


    @Step("Opening Registration Page")
    public RegistrationPage openRegistrationPage(String urlForRegistration) {
        driver.get(urlForRegistration);
        logger.atInfo().log("Passing url and opening registration page");
        return this;
    }

    @Step("Fill in the first name")
    public RegistrationPage fillInFirstName(String keyFirstName) {
        waitVisibilityOf(firstName).clear();
        firstName.sendKeys(keyFirstName);
        logger.atInfo().log("User firstname input");
        return this;
    }

    @Step("Fill in the last name")
    public RegistrationPage fillInLastName(String keyLastName) {
        lastName.clear();
        lastName.sendKeys(keyLastName);
        logger.atInfo().log("User lastname input");

        return this;
    }

    @Step("Fill email")
    public RegistrationPage fillInEmailRegistration(String keyEmail) {
        emailAddress.clear();
        emailAddress.sendKeys(keyEmail);
        logger.atInfo().log("User email input");
        return this;
    }

    @Step("Fill password Field")
    public RegistrationPage fillInPassword(String keyPassword) {
        passwordAtRegistration.clear();
        passwordAtRegistration.sendKeys(keyPassword);
        logger.atInfo().log("User password input");
        return this;
    }

    @Step("Fill password Field")
    public RegistrationPage fillInRetypePassword(String keyPassword) {
        reTypePasswordAtRegistration.clear();
        reTypePasswordAtRegistration.sendKeys(keyPassword);
        logger.atInfo().log("User password re-entry");

        return this;
    }


    @Step("Click Create New Account ")
    public void clickCreateNewAccountButton() {

        waitElementToBeClickable(createNewAccountButton).click();
        logger.atInfo().log("Pressing the create new account after filling in all fields");
    }

}
