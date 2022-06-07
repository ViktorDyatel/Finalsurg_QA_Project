package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.MainFinalSurgePageService;

import static utils.StringConstants.URL_LOGIN_PAGE;

public class WorkoutReportPageTest extends BaseTest{


    private MainFinalSurgePageService mainFinalSurgePageService;
    private LoginPageService loginPageService;

    @BeforeTest
    public void setUp() {

        mainFinalSurgePageService = new MainFinalSurgePageService();
        loginPageService = new LoginPageService();
    }


    @Test(description = "WorkoutReportTest")
    @Description("Logging in and going to the workoutReport page")
    public void workoutReportPageTest(){
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword(), URL_LOGIN_PAGE);
        mainFinalSurgePageService.openWorkoutReport();
        String actualTextOfWidgetContent = driver.getCurrentUrl();
        String expectedPageTexts = "https://log.finalsurge.com/WorkoutReport.cshtml";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "Transition to workout report failed");
    }

}
