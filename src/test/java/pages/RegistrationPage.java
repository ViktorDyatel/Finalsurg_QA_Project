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
        logger.atInfo().log("Passing url and opening registration page");
        driver.get(urlForRegistration);

        return this;
    }

    @Step("Fill in the first name")
    public RegistrationPage fillInFirstName(String keyFirstName) {
        logger.atInfo().log("User firstname input");
        waitVisibilityOf(firstName).clear();
        firstName.sendKeys(keyFirstName);

        return this;
    }

    @Step("Fill in the last name")
    public RegistrationPage fillInLastName(String keyLastName) {
        logger.atInfo().log("User lastname input");
        lastName.clear();
        lastName.sendKeys(keyLastName);

        return this;
    }

    @Step("Fill email")
    public RegistrationPage fillInEmailRegistration(String keyEmail) {
        logger.atInfo().log("User email input");
        emailAddress.clear();
        emailAddress.sendKeys(keyEmail);

        return this;
    }

    @Step("Fill password Field")
    public RegistrationPage fillInPassword(String keyPassword) {
        logger.atInfo().log("User password input");
        passwordAtRegistration.clear();
        passwordAtRegistration.sendKeys(keyPassword);

        return this;
    }

    @Step("Fill password Field")
    public RegistrationPage fillInRetypePassword(String keyPassword) {
        logger.atInfo().log("User password re-entry");
        reTypePasswordAtRegistration.clear();
        reTypePasswordAtRegistration.sendKeys(keyPassword);

        return this;
    }


    @Step("Click Create New Account ")
    public void clickCreateNewAccountButton() {
        logger.atInfo().log("Pressing the create new account after filling in all fields");
        waitElementToBeClickable(createNewAccountButton).click();
    }

}
