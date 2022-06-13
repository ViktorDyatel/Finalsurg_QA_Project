/*package services;

import entities.EntitiesFactory;
import io.qameta.allure.Step;
import models.User;
import pages.MainFinalSurgePage;
import pages.ShoesPage;

import static utils.StringConstants.URL_LOGIN_PAGE;

public class ShoesPageService extends LoginPageService{


    private ShoesPage shoesPage = new ShoesPage();
    private MainFinalSurgePage mainFinalSurgePage = new MainFinalSurgePage();



    @Step("Open the page and click add workout, fill in the date field, select the type of workout, and then click add workout.")
    public void addShoes(String shoeName, String brand,String model) throws InterruptedException {
        User user = EntitiesFactory.getUser();
        login(user.getEmail(), user.getPassword(), URL_LOGIN_PAGE);
        mainFinalSurgePage.clickGearRoutes();
        mainFinalSurgePage.clickShoesButton();
        shoesPage.
                fillInShoeName(shoeName)
                .chooseTheBrand(brand)
                .fillInShoeModel(model)
                .clickSaveButton();

    }
}*/
