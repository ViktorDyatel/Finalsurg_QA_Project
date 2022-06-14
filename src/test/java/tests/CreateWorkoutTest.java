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

import static utils.StringConstants.ACTIVITY_TYPE_SELECT;
import static utils.StringConstants.DATE_WORKOUT;

public class CreateWorkoutTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeClass
    public void setUp() {
        mainFinalSurgePageService = new MainFinalSurgePageService();
        LoginPageService loginPageService = new LoginPageService();
        User user = EntitiesFactory.getUser();
        loginPageService.login(user.getEmail(), user.getPassword());
    }

    @AfterClass()
    public void deleteWorkout() {
        mainFinalSurgePageService.deleteWorkoutPlan();
    }

    @Test(description = "CreateWorkoutTest", priority = 1)
    @Description("Logging in and creating a workout with a Activity Type")
    public void createWorkoutTest() {
        mainFinalSurgePageService.addWorkout(DATE_WORKOUT, ACTIVITY_TYPE_SELECT);
        boolean isWorkoutCreated = mainFinalSurgePageService.thisWorkoutWasCreated();
        Assert.assertTrue(isWorkoutCreated, "This account has not been created");

    }

    @Test(description = "CreateWorkoutWithoutActivityTypeTest")
    @Description("Logging in and creating a workout without a Activity Type")
    public void createWorkoutWithoutActivityTypeTest() {
        mainFinalSurgePageService.addWorkoutWithoutActivityType(DATE_WORKOUT);
        String actualTextOfWidgetContent = mainFinalSurgePageService.getTextOfErrorWhileCreateWorkout();
        String expectedPageTexts = "Please fix the following errors:";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "This workout was created without an active type");
    }

}

