package utils;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;

import java.util.ArrayList;

public class Tabs extends BasePage {

    private static final Logger logger = LogManager.getLogger(Tabs.class);
    @Step("Click printButton Save Print Button")
    public void transitionToANewTab(int numberTab) {
        logger.atInfo().log("Switching to a new tab");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numberTab));
    }

}
