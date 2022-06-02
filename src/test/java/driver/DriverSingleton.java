package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverSingleton {

    private static  ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();

    private WebDriver driver;

    private DriverSingleton() {
        driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized DriverSingleton getInstance() {
        if (instance.get() == null) {
            instance.set(new DriverSingleton());
            System.out.println("я проинециалтзтровался");
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } finally {
            instance.remove();
        }
    }
}

