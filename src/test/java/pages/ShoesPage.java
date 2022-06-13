/*package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoesPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(MainFinalSurgePage.class);

    @FindBy(xpath = "//input[@id='ShoeName']")
    private WebElement shoeName;

    @FindBy(xpath = "//input[@id='ShoeModel']")
    private WebElement shoeModel;

    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement saveButton;


    @Step("Select brand")
    public ShoesPage chooseTheBrand(String brand) throws InterruptedException {
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(span12).setAttribute('style', 'display: 0;');");
        driver.findElement(By.xpath("//select[@id='ShoeBrand']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//select[@id='ShoeBrand']/option[4]")));
      driver.findElement(By.xpath("//select[@id='ShoeBrand']")).click();
        Select brandShoe = new Select(driver.findElement(By.id("ShoeBrand")));
        brandShoe.selectByVisibleText(brand);
        logger.atInfo().log("Selecting brand");
        return this;
    }

    @Step("Fill in the Shoe Name")
    public ShoesPage fillInShoeName(String keyShoeName) {
        waitVisibilityOf(shoeName).clear();
        shoeName.sendKeys(keyShoeName);
        logger.atInfo().log("Entering the shoe name");
        return this;
    }

    @Step("Fill in the Shoe model")
    public ShoesPage fillInShoeModel(String keyShoeModel) {
        waitVisibilityOf(shoeModel).clear();
        shoeName.sendKeys(keyShoeModel);
        logger.atInfo().log("Entering the shoe model");
        return this;
    }

    @Step("Click button save button")
    public void clickSaveButton() {
        waitElementToBeClickable(saveButton).click();
        logger.atInfo().log("Clicking the save button");
    }

}*/
