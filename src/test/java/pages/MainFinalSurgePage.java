package pages;


import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;

import static utils.StringConstants.*;

public class MainFinalSurgePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(MainFinalSurgePage.class);


    @FindBy(xpath = "//button[@class='btn btn-small btn-info ptip_s']")
    private WebElement buttonViewCalendarOfMainFinalSurgePage;

    @FindBy(xpath = "//a[@id='QuickAddToggle']")
    private WebElement buttonQuickAddToggle;

    @FindBy(xpath = "//input[@id='WorkoutDate']")
    private WebElement workoutDate;

    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"workout-add\"]/div[1]/strong")
     private WebElement errorWhileCreateWorkout;
    //@FindBy(xpath = "//div[@class=\"alert alert-error\"]")
   // private WebElement errorWhileCreateWorkout;

    @FindBy(xpath = "//i[@class='icsw16-printer']")
    private WebElement printButton;

    @FindBy(xpath = "//input[@id='PrintStartDate']")
    private WebElement printStartDate;

    @FindBy(xpath = "//input[@id='PrintEndDate']")
    private WebElement printEndDate;

    @FindBy(xpath = "//input[@id='saveButtonPrint']")
    private WebElement savePrintButton;

    @FindBy(xpath = "//div[@class='fc-event-inner fc-event-skin']")
    private WebElement eventActivity;

    @FindBy(xpath = "//a[@class='quick-delete']")
    private WebElement deleteActivityButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement okButton;

    @FindBy(xpath = "//a[@class='ptip_s']//i[@class='icsw16-day-calendar']")
    private WebElement calendarButton;

    @FindBy(xpath = "//i[@class='icsw16-graph']")
    private WebElement workoutReport;

    @FindBy(xpath = "//i[@class='icsw16-mail']")
    private WebElement mailbox;

    @FindBy(xpath = "//a[@class='close-reveal-modal']")
    private WebElement closePrintWorkout;


    @Step("Click close print workout ")
    public void clickClosePrintWorkoutButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closePrintWorkout);

           }


    @Step("Click mailbox ")
    public void clickMailbox() {

        waitElementToBeClickable(mailbox).click();
        logger.atInfo().log("Pressing the mailbox");
    }


    @Step("Click Workout Report ")
    public void clickWorkoutReport() {

        waitElementToBeClickable(workoutReport).click();
        logger.atInfo().log("Pressing the Workout Report");
    }

    @Step("Click calendar Button")
    public void clickCalendarButton() {
        waitElementToBeClickable(calendarButton).click();
        logger.atInfo().log("Clicking the calendar button");

    }


    @Step("Click event activity")
    public MainFinalSurgePage clickEventActivity() {
        waitElementToBeClickable(eventActivity).click();
        logger.atInfo().log("Clicking the Event Activity");
        return this;
    }

    @Step("Click delete activity Button")
    public MainFinalSurgePage clickDeleteActivityButton() {
        waitElementToBeClickable(deleteActivityButton).click();
        logger.atInfo().log("Clicking Delete Activity Button");
        return this;
    }

    @Step("Click OK Button")
    public MainFinalSurgePage clickOkButton() {
        waitElementToBeClickable(okButton).click();
        logger.atInfo().log("Clicking the OK button");
        return this;
    }

    @Step("Entrance to iFrame")
    public MainFinalSurgePage entranceIFrame() {
        driver.switchTo().frame("PrintWorkoutsiFrame");
        logger.atInfo().log("Entrance to iFrame");
        return this;
    }

    @Step("exit from iFrame")
    public MainFinalSurgePage exitFromIFrame() {
        driver.switchTo().defaultContent();
        logger.atInfo().log("exit from iFrame");
        return this;

    }

    @Step("Click printButton Save Print Button")
    public MainFinalSurgePage clickSavePrintButton() {
        waitElementToBeClickable(savePrintButton).click();
        logger.atInfo().log("Clicking the Save Print Button");
        return this;
    }

    @Step("Click printButton Save Print Button")
    public void transitionToANewTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        logger.atInfo().log("Switching to a new tab");
    }

    @Step("Click printButton Save Print Button")
    public MainFinalSurgePage transitionToAOldTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        logger.atInfo().log("Switching to a old tab");
        return this;
    }


    @Step("Fill in the Print Starting Date")
    public MainFinalSurgePage fillInPrintStartingDate(String keyPrintStartingDate) {
        waitVisibilityOf(printStartDate).clear();
        printStartDate.sendKeys(keyPrintStartingDate);
        logger.atInfo().log("Entering the Print Start Date");

        return this;
    }

    @Step("Fill in the Print Ending Date")
    public MainFinalSurgePage fillInPrintEndingDate(String keyPrintEndingDate) {

        waitVisibilityOf(printEndDate).clear();
        printEndDate.sendKeys(keyPrintEndingDate);
        logger.atInfo().log("Entering the Print End Date");

        return this;
    }


    @Step("Click printButton")
    public MainFinalSurgePage clickPrintButton() {
        waitElementToBeClickable(printButton).click();
        logger.atInfo().log("Clicking the Print Button");
        return this;
    }

    @Step("Click button View Calendar")
    public MainFinalSurgePage clickViewCalendarButton() {
        waitElementToBeClickable(buttonViewCalendarOfMainFinalSurgePage).click();
        logger.atInfo().log("Clicking the View calendar button");
        return this;
    }


    @Step("Click button Quick add Button")
    public MainFinalSurgePage clickButtonQuickAdd() {
        waitElementToBeClickable(buttonQuickAddToggle).click();
        logger.atInfo().log("Clicking the Quick add button");
        return this;
    }


    @Step("Fill in the training date")
    public MainFinalSurgePage fillInDate(String keyDate) {
        waitVisibilityOf(workoutDate).clear();
        workoutDate.sendKeys(keyDate);
        logger.atInfo().log("Entering the training date");
        return this;
    }


    @Step("Select Workout Options")
    public MainFinalSurgePage chooseTheTypeOfTraining(String option) {
        Select activityType = new Select(driver.findElement(By.id("ActivityType")));
        activityType.selectByVisibleText(option);
        logger.atInfo().log("Selecting an activity type");
        return this;
    }

    @Step("Click button Save Button")
    public void clickSaveButton() {

        saveButton.click();
        logger.atInfo().log("Clicking the Save Button");

    }


    public boolean isWorkoutWasCreated() {
        try {

            return driver.findElement(By.xpath(String.format(XPATH_DATA_DAY, WORKOUT_CREATION_DATE))).findElement(By.linkText(ACTIVITY_TYPE)).isDisplayed();
        } catch (NoSuchElementException e) {

            return false;

        }

    }

    public String getTextOfErrorWhileCreateWorkout() {

        return errorWhileCreateWorkout.getText();
    }


    public String getTextOfMainPageSection() {

        return buttonViewCalendarOfMainFinalSurgePage.getText();
    }


}

