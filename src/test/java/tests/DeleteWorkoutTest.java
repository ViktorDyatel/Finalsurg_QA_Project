package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.MainFinalSurgePageService;

import static utils.StringConstants.*;

public class DeleteWorkoutTest extends BaseTest {

    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeClass
    public void setUp() {

        mainFinalSurgePageService = new MainFinalSurgePageService();
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
