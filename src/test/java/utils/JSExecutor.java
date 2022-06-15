package utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class JSExecutor extends BasePage {

    public void clickButton(WebElement xpathButton) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",xpathButton);
    }
}
