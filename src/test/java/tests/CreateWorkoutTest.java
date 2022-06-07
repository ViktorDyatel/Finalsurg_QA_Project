package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.MainFinalSurgePageService;

import static utils.StringConstants.*;


public class CreateWorkoutTest extends BaseTest {


    private MainFinalSurgePageService mainFinalSurgePageService;

    @BeforeMethod
    public void setUp() {

        mainFinalSurgePageService = new MainFinalSurgePageService();
    }


    @Test(description = "CreateWorkoutTest")
    @Description("Logging in and creating a workout with a Activity Type")
    public void createWorkoutTest() {
        mainFinalSurgePageService.addWorkout(DATE_WORKOUT, ACTIVITY_TYPE_SELECT);
        boolean isWorkoutCreated = mainFinalSurgePageService.thisWorkoutWasCreated();
        System.out.println(isWorkoutCreated);
        Assert.assertTrue(isWorkoutCreated, "This account has not been created");
        mainFinalSurgePageService.deleteWorkoutPlan();
    }


    @Test(description = "CreateWorkoutWithoutActivityTypeTest")
    @Description("Logging in and creating a workout without a Activity Type")
    public void createWorkoutWithoutActivityTypeTest() {
        mainFinalSurgePageService.addWorkoutWithoutActivityType(DATE_WORKOUT);
        String actualTextOfWidgetContent = mainFinalSurgePageService.getTextOfErrorWhileCreateWorkout();
        System.out.println(actualTextOfWidgetContent);
        String expectedPageTexts = "×\n" +
                "Please fix the following errors:\n" +
                "*Please select a valid Activity Type.";
        Assert.assertEquals(actualTextOfWidgetContent, expectedPageTexts, "This workout was not created because no active type was selected ");
    }
}


