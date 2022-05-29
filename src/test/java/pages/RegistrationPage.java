package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@id='create_first']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='create_last']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='//input[@id='create_email']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@id='password_meter']")
    private WebElement passwordAtRegistration;

    @FindBy(xpath = "//input[@id='create_passwordmatch']")
    private WebElement ReTypePasswordAtRegistration;

    @FindBy(xpath = "//button[@class='btn btn-beoro-1']")
    private WebElement CreateNewAccountButton;


}
