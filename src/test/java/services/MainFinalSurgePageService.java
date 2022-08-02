package services;

import io.qameta.allure.Step;
import pages.MainFinalSurgePage;
import pages.PrintPage;
import utils.Tabs;

public class MainFinalSurgePageService extends LoginPageService {

    private final MainFinalSurgePage mainFinalSurgePage = new MainFinalSurgePage();

    private final PrintPage printPage = new PrintPage();

    private final Tabs tabs = new Tabs();

    private static final int TAB_NEW = 1;

    private static final int PREVIOUS_TAB = 0;

    @Step("Opening the login page, entering the login and password, pressing the mailbox button")
    public void openMailboxPage() {
        mainFinalSurgePage.clickMailbox();
    }

    @Step("Opening the login page, entering the login and password, pressing the formation of a report on training")
    public void openWorkoutReport() {

        mainFinalSurgePage.clickWorkoutReport();
    }

    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout.")
    public void addWorkout(String dateWorkout, String activityType) {
        mainFinalSurgePage
                .clickCalendarButton()
                .clickButtonQuickAdd()
                .fillInDate(dateWorkout)
                .chooseTheTypeOfTraining(activityType)
                .clickSaveButton();

    }

    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout.")
    public void addWorkoutWithoutActivityType(String dateWorkout) {
        mainFinalSurgePage
                .clickViewCalendarButton()
                .clickButtonQuickAdd()
                .fillInDate(dateWorkout)
                .clickSaveButton();
    }

    @Step("Open the page, click the print button, enter the print dates and click the print button")
    public void printWorkoutPlan(String dateWorkout, String activityType, String dateStartingPrint, String dateEndingPrint) {
        addWorkout(dateWorkout, activityType);
        mainFinalSurgePage
                .clickPrintButton()
                .entranceIFrame()
                .fillInPrintStartingDate(dateStartingPrint)
                .fillInPrintEndingDate(dateEndingPrint)
                .clickSavePrintButton();
        tabs.transitionToANewTab(TAB_NEW);
    }

    @Step("Deleting a Workout After Print Check")
    public void printWorkoutPlanDelete() {
        tabs.transitionToANewTab(PREVIOUS_TAB);
        mainFinalSurgePage.clickClosePrintWorkoutButton();
        deleteWorkoutPlan();
    }

    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout and delete workout plan")
    public void deleteWorkoutPlan() {
        mainFinalSurgePage
                .clickEventActivity()
                .clickDeleteActivityButton()
                .clickOkButton()
                .clickCalendarButton();
    }

    public boolean thisWorkoutWasCreated() {
        return mainFinalSurgePage.isWorkoutWasCreated();
    }

    public String getTextOfErrorWhileCreateWorkout() {
        return mainFinalSurgePage.getTextOfErrorWhileCreateWorkout();
    }

    public String getTextDateOfReportGeneration() {
        return printPage.getTextDateOfReportGeneration();
    }

}
