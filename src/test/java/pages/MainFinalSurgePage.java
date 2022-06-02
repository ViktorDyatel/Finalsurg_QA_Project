package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFinalSurgePage extends BasePage {

    @FindBy(xpath = "//button[@class='btn btn-small btn-info ptip_s']")
    private WebElement buttonViewCalendarOfMainFinalSurgePage;

    public String getTextOfMainPageSection(){

        return buttonViewCalendarOfMainFinalSurgePage.getText();
    }



}

