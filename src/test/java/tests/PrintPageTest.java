package tests;


import entities.EntitiesFactory;
import io.qameta.allure.Description;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import services.MainFinalSurgePageService;

import static utils.StringConstants.*;


public class PrintPageTest extends BaseTest {


    private MainFinalSurgePageService mainFinalSurgePageService;


    @BeforeMethod
    public void setUp() {

        mainFinalSurgePageService = new MainFinalSurgePageService();

    }



    @Test(description = "PrintWorkoutPlanTest")
    @Description("Logging in, creating a workout, going to the print page")
    public void printWorkoutPlanTest() {
        User user = EntitiesFactory.getUser();
        mainFinalSurgePageService.printWorkoutPlan(DATE_WORKOUT, ACTIVITY_TYPE_SELECT, DATE_STARTING_PRINT_WORKOUT, DATE_ENDING_PRINT_WORKOUT);
        String actualTextOfUserProfilePage = mainFinalSurgePageService.getTextDateOfReportGeneration();
        String expectedPageTexts = "Print";
        Assert.assertEquals(actualTextOfUserProfilePage, expectedPageTexts, "Can't print workout plan!");
        mainFinalSurgePageService.printWorkoutPlanDelete();
    }



}
