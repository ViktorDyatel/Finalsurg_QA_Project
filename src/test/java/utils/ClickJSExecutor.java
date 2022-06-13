package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class ClickJSExecutor extends BasePage {

    public void clickClosePrintWorkoutButton(WebElement xpathButton) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",xpathButton);
    }
}
