package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintPage extends BasePage {

    @FindBy(xpath = "//a[@id='printlink']")
    private WebElement printButton;

    public String getTextDateOfReportGeneration() {
        waitVisibilityOf(printButton);

        return printButton.getText();
    }


}
