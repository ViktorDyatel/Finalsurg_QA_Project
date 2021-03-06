package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.MainFinalSurgePageService;


public class WorkoutReportPageTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        mainFinalSurgePageService = new MainFinalSurgePageService();
        loginPageService = new LoginPageService();
    }

    @Test(description = "WorkoutReportTest")
    @Description("Logging in and going to the workoutReport page")
    public void workoutReportPageTest() {
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
        mainFinalSurgePageService.openWorkoutReport();
        String actualTextOfWidgetContent = driver.getCurrentUrl();
        String expectedPageTexts = "https://log.finalsurge.com/WorkoutReport.cshtml";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "Transition to workout report failed");
    }

}
