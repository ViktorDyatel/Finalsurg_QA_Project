package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.MainFinalSurgePageService;


public class MailboxPageTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        mainFinalSurgePageService = new MainFinalSurgePageService();
        loginPageService = new LoginPageService();
    }

    @Test(description = "MailboxPageTest")
    @Description("Logging in and going to the mailbox page")
    public void mailboxPageTest() {
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
        mainFinalSurgePageService.openMailboxPage();
        String actualTextOfWidgetContent = driver.getCurrentUrl();
        String expectedPageTexts = "https://log.finalsurge.com/Mailbox.cshtml";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "Transition to mailbox failed");
    }

}
