package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}


