package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.MainFinalSurgePageService;

import static utils.StringConstants.*;

public class CreateWorkoutTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeTest
    public void setUp() {

        mainFinalSurgePageService = new MainFinalSurgePageService();
    }

    @Test(description = "CreateWorkoutTest", priority = 1)
    @Description("Logging in and creating a workout with a Activity Type")
    public void createWorkoutTest() {
        mainFinalSurgePageService.addWorkout(DATE_WORKOUT, ACTIVITY_TYPE_SELECT);
        boolean isWorkoutCreated = mainFinalSurgePageService.thisWorkoutWasCreated();
        Assert.assertTrue(isWorkoutCreated, "This account has not been created");
        mainFinalSurgePageService.deleteWorkoutPlan();
    }

    @Test(description = "CreateWorkoutWithoutActivityTypeTest",priority = 2)
    @Description("Logging in and creating a workout without a Activity Type")
    public void createWorkoutWithoutActivityTypeTest() {
        mainFinalSurgePageService.addWorkoutWithoutActivityType(DATE_WORKOUT);
        String actualTextOfWidgetContent = mainFinalSurgePageService.getTextOfErrorWhileCreateWorkout();
        String expectedPageTexts = "Please fix the following errors:";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "This workout was created without an active type");
    }
}

