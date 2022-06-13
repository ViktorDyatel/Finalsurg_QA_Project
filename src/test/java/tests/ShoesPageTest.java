/*package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.MainFinalSurgePageService;
import services.ShoesPageService;

import static utils.StringConstants.ACTIVITY_TYPE_SELECT;
import static utils.StringConstants.DATE_WORKOUT;

public class ShoesPageTest extends BaseTest{


    private ShoesPageService shoesPageService;

    @BeforeMethod
    public void setUp() {

        shoesPageService = new ShoesPageService();
    }



    @Test(description = "ShorsPageTest")
    @Description("Logging in and add shoes")
    public void addShoesTest() throws InterruptedException {
        shoesPageService.addShoes("Петя","ASICS","123");
        /*boolean isWorkoutCreated = mainFinalSurgePageService.thisWorkoutWasCreated();
        System.out.println(isWorkoutCreated);
        Assert.assertTrue(isWorkoutCreated, "This account has not been created");
        mainFinalSurgePageService.deleteWorkoutPlan();
    }


}*/
