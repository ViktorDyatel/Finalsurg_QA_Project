/*package utils;
import driver.DriverSingleton;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private final static int WAIT_TIMEOUT_SECONDS = 5;
    private final static int TIMEOUT_SECONDS = 500;

    private Waits() {
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new FluentWait<>(DriverSingleton.getInstance().getDriver()).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofMillis(TIMEOUT_SECONDS)).ignoring(NoSuchElementException.class)
                .until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() && element
                        .isEnabled());
    }

    public static void  waitVisibilityOf(WebElement element) {
         new WebDriverWait(DriverSingleton.getInstance().getDriver(), Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(element));//вынести в waiters
    }
}*/