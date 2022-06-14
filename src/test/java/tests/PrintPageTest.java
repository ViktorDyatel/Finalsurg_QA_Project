package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.MainFinalSurgePageService;

import static utils.StringConstants.*;

public class PrintPageTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeClass
    public void setUp() {
        mainFinalSurgePageService = new MainFinalSurgePageService();
        LoginPageService loginPageService = new LoginPageService();
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
    }

    @AfterClass
    public void deleteWorkout() {
        mainFinalSurgePageService.printWorkoutPlanDelete();
    }

    @Test(description = "PrintWorkoutPlanTest")
    @Description("Logging in, creating a workout, going to the print page")
    public void printWorkoutPlanTest() {
        mainFinalSurgePageService.printWorkoutPlan(DATE_WORKOUT, ACTIVITY_TYPE_SELECT, DATE_STARTING_PRINT_WORKOUT, DATE_ENDING_PRINT_WORKOUT);
        String actualTextOfUserProfilePage = mainFinalSurgePageService.getTextDateOfReportGeneration();
        String expectedPageTexts = "Print";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "Can't print workout plan!");
    }

}
