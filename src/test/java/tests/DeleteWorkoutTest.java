package tests;

import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.LoginPageService;
import services.MainFinalSurgePageService;

import static utils.StringConstants.ACTIVITY_TYPE_SELECT;
import static utils.StringConstants.DATE_WORKOUT;

public class DeleteWorkoutTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeClass
    public void setUp() {
        mainFinalSurgePageService = new MainFinalSurgePageService();
        LoginPageService loginPageService = new LoginPageService();
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
    }

    @Test(description = "DeleteWorkoutTest")
    @Description("Create an account and then delete it")
    public void deleteWorkoutPlanTest() {
        mainFinalSurgePageService.addWorkout(DATE_WORKOUT, ACTIVITY_TYPE_SELECT);
        mainFinalSurgePageService.deleteWorkoutPlan();
        boolean isWorkoutCreated = mainFinalSurgePageService.thisWorkoutWasCreated();
        Assert.assertFalse(isWorkoutCreated, "This account has not been deleted.");
    }
}
