package services;

import entities.EntitiesFactory;
import io.qameta.allure.Step;
import models.User;
import pages.MainFinalSurgePage;
import pages.PrintPage;

import static utils.StringConstants.*;

public class MainFinalSurgePageService extends LoginPageService {


    private MainFinalSurgePage mainFinalSurgePage = new MainFinalSurgePage();
    private PrintPage printPage = new PrintPage();

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
        User user = EntitiesFactory.getUser();
        login(user.getEmail(), user.getPassword(), URL_LOGIN_PAGE);
        mainFinalSurgePage.
                clickViewCalendarButton()
                .clickButtonQuickAdd()
                .fillInDate(dateWorkout)
                .chooseTheTypeOfTraining(activityType).
                clickSaveButton();

    }

    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout.")
    public void addWorkoutWithoutActivityType(String dateWorkout) {
        User user = EntitiesFactory.getUser();
        login(user.getEmail(), user.getPassword(), URL_LOGIN_PAGE);
        mainFinalSurgePage.
                clickViewCalendarButton()
                .clickButtonQuickAdd()
                .fillInDate(dateWorkout)
                .clickSaveButton();


    }

    @Step("Open the page, click the print button, enter the print dates and click the print button")
    public void printWorkoutPlan(String dateWorkout, String activityType, String dateStartingPrint, String dateEndingPrint) {
        addWorkout(dateWorkout, activityType);
        mainFinalSurgePage.
                clickPrintButton().
                entranceIFrame().
                fillInPrintStartingDate(dateStartingPrint).
                fillInPrintEndingDate(dateEndingPrint).
                clickSavePrintButton()
                .transitionToANewTab();


    }

    @Step("Deleting a Workout After Print Check")
    public void printWorkoutPlanDelete() {
        mainFinalSurgePage.transitionToAOldTab().clickClosePrintWorkoutButton();
        deleteWorkoutPlan();


    }

    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout and delete workout plan")
    public void deleteWorkoutPlan() {
        User user = EntitiesFactory.getUser();
        mainFinalSurgePage.
                clickEventActivity()
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
