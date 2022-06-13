package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-validate']/div[@class='submit_sect']//button[@class='btn btn-beoro-1']")
    private WebElement loginButton;

    @FindBy(xpath = "//strong[@style='font-weight: bold;']")
    private WebElement errorInvalidLoginCredentials;

    public String getErrorTextOfLoginPage() {

        return errorInvalidLoginCredentials.getText();

    }

    @Step("Opening Login Page URl")
    public LoginPage openPage(String url) {
        logger.atInfo().log("Passing url and opening login page");
        driver.get(url);

        return this;
    }

    @Step("Fill username Field")
    public LoginPage fillInEmail(String keyEmail) {
        logger.atInfo().log("User email input");
        waitVisibilityOf(email).clear();
        email.sendKeys(keyEmail);

        return this;
    }

    @Step("Fill password Field")
    public LoginPage fillInPassword(String keyPassword) {
        logger.atInfo().log("User password input");
        password.clear();
        password.sendKeys(keyPassword);

        return this;
    }

    @Step("Click button Login")
    public void clickLoginButton() {
        logger.atInfo().log("Pressing the login button after entering the email and password");
        waitElementToBeClickable(loginButton).click();
    }
}
