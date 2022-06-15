package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.JSExecutor;

import static utils.StringConstants.ACTIVITY_TYPE;
import static utils.StringConstants.WORKOUT_CREATION_DATE;

public class MainFinalSurgePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(MainFinalSurgePage.class);

    public static final String XPATH_DATA_DAY = "//td[@data-day='%s']";

    public static final String SELECT = "ActivityType";

    private final JSExecutor JSExecutor = new JSExecutor();

    @FindBy(xpath = "//button[@class='btn btn-small btn-info ptip_s']")
    private WebElement buttonViewCalendarOfMainFinalSurgePage;

    @FindBy(xpath = "//a[@id='QuickAddToggle']")
    private WebElement buttonQuickAddToggle;

    @FindBy(xpath = "//input[@id='WorkoutDate']")
    private WebElement workoutDate;

    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-error']/strong")
    private WebElement errorWhileCreateWorkout;

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

    @FindBy(xpath = "//a[contains(text(),'Gear & Routes')]")
    private WebElement GearRoutesButton;

    @FindBy(xpath = "//strong/a[contains(text(),'Shoes')]")
    private WebElement shoesButton;

    @Step("Click mailbox ")
    public void clickMailbox() {
        logger.atInfo().log("Pressing the mailbox");
        waitElementToBeClickable(mailbox).click();
    }

    @Step("Click Workout Report ")
    public void clickWorkoutReport() {
        logger.atInfo().log("Pressing the Workout Report");
        waitElementToBeClickable(workoutReport).click();
    }

    @Step("Click calendar Button")
    public MainFinalSurgePage clickCalendarButton() {
        logger.atInfo().log("Clicking the calendar button");
        waitElementToBeClickable(calendarButton).click();
        return this;
    }


    @Step("Click event activity")
    public MainFinalSurgePage clickEventActivity() {
        logger.atInfo().log("Clicking the Event Activity");
        waitElementToBeClickable(eventActivity).click();
        return this;
    }

    @Step("Click delete activity Button")
    public MainFinalSurgePage clickDeleteActivityButton() {
        logger.atInfo().log("Clicking Delete Activity Button");
        waitElementToBeClickable(deleteActivityButton).click();
        return this;
    }

    @Step("Click OK Button")
    public MainFinalSurgePage clickOkButton() {
        logger.atInfo().log("Clicking the OK button");
        waitElementToBeClickable(okButton).click();
        return this;
    }

    @Step("Entrance to iFrame")
    public MainFinalSurgePage entranceIFrame() {
        logger.atInfo().log("Entrance to iFrame");
        driver.switchTo().frame("PrintWorkoutsiFrame");
        return this;
    }

    @Step("Click printButton Save Print Button")
    public MainFinalSurgePage clickSavePrintButton() {
        logger.atInfo().log("Clicking the Save Print Button");
        waitElementToBeClickable(savePrintButton).click();
        return this;
    }

    @Step("Fill in the Print Starting Date")
    public MainFinalSurgePage fillInPrintStartingDate(String keyPrintStartingDate) {
        logger.atInfo().log("Entering the Print Start Date");
        waitVisibilityOf(printStartDate).clear();
        printStartDate.sendKeys(keyPrintStartingDate);
        return this;
    }

    @Step("Fill in the Print Ending Date")
    public MainFinalSurgePage fillInPrintEndingDate(String keyPrintEndingDate) {
        logger.atInfo().log("Entering the Print End Date");
        waitVisibilityOf(printEndDate).clear();
        printEndDate.sendKeys(keyPrintEndingDate);
        return this;
    }

    @Step("Click printButton")
    public MainFinalSurgePage clickPrintButton() {
        logger.atInfo().log("Clicking the Print Button");
        waitElementToBeClickable(printButton).click();
        return this;
    }

    @Step("Click button View Calendar")
    public MainFinalSurgePage clickViewCalendarButton() {
        logger.atInfo().log("Clicking the View calendar button");
        waitElementToBeClickable(buttonViewCalendarOfMainFinalSurgePage).click();
        return this;
    }

    @Step("Click button Quick add Button")
    public MainFinalSurgePage clickButtonQuickAdd() {
        logger.atInfo().log("Clicking the Quick add button");
        waitElementToBeClickable(buttonQuickAddToggle).click();
        return this;
    }

    @Step("Fill in the training date")
    public MainFinalSurgePage fillInDate(String keyDate) {
        logger.atInfo().log("Entering the training date");
        waitVisibilityOf(workoutDate).clear();
        workoutDate.sendKeys(keyDate);
        return this;
    }

    @Step("Select Workout Options")
    public MainFinalSurgePage chooseTheTypeOfTraining(String option) {
        logger.atInfo().log("Selecting an activity type");
        Select activityType = new Select(driver.findElement(By.id(SELECT)));
        activityType.selectByVisibleText(option);
        return this;
    }

    @Step("Click button Save Button")
    public void clickSaveButton() {
        logger.atInfo().log("Clicking the Save Button");
        saveButton.click();
    }

    @Step("Click close print workout ")
    public void clickClosePrintWorkoutButton() {
        JSExecutor.clickButton(closePrintWorkout);
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

