package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class PrintPage extends BasePage {

    @FindBy(xpath = "//a[@id='printlink']")
    private WebElement printButton;

    public String getTextDateOfReportGeneration() {

        waitVisibilityOf(printButton);
        return printButton.getText();
    }


}
