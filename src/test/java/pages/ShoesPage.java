package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoesPage extends BasePage{

    @FindBy(xpath = "//input[@id='ShoeName']")
    private WebElement shoeName;

    @FindBy(xpath = "//input[@id='ShoeModel']")
    private WebElement shoeModel;

}
