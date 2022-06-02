package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void startBrowser() {

        driver = DriverSingleton.getInstance().getDriver();
        System.out.println("Ghgdstesrtgw");
    }

    @AfterMethod
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }
}



