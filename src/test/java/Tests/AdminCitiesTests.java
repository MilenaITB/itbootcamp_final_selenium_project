package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitAdminCitiesPage(){
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(adminEmail);
        loginPage.getPasswordInput().sendKeys(adminPassword);
        loginPage.getLoginButton().click();

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        waitForUrl("/admin/cities");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types for create/edit new city")
    public void createEditCityInput(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
       citiesPage.waitForEditAndCreateDialogueVisibility();

        Assert.assertEquals(citiesPage.getCityNameInput().getAttribute("type"),
                "text",
                "Input type is incorrect");


    }
    @Test(priority = 3)
    @Description("Test #3: Create new city")
    public void createNewCity(){
        String city = "Milena Manojlovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getNewItemButton().click();
       citiesPage.waitForEditAndCreateDialogueVisibility();
        citiesPage.getCityNameInput().sendKeys(city);
        citiesPage.getSaveButtonFromDialogue().click();

        messagePopUpPage.waitForSucessDialog();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp().getText()
                .contains("Saved successfully"),"Message is incorrect");


    }
    @Test(priority = 4)
    @Description("Test #4: Edit city")
    public void editCity(){
        String oldCityName = "Milena Manojlovic's city";
        String newCityName = "Milena Manojlovic's city Edited";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(oldCityName);
        citiesPage.waitForNoRows(1);
        citiesPage.getEditButtonForRow(1).click();


        citiesPage.getCityNameInput().clear();
        citiesPage.getCityNameInput().sendKeys(newCityName);
        citiesPage.getSaveButtonFromDialogue().click();

        messagePopUpPage.waitForSucessDialog();
        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp()
                .getText()
                .contains("Saved successfully"),"Message is incorrect");


    }
    @Test(priority = 5)
    @Description("Test #5: Search city")
    public void searchCity(){
        String cityName = "Milena Manojlovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForNoRows(1);


        Assert.assertTrue(citiesPage.getCell(1,2).getText().contains(cityName),
                "Name cell doesn't contain text form search input");


    }
    @Test(priority = 6)
    @Description("Test #6: Delete city")
    public void deleteCity(){
        String cityName = "Milena Manojlovic's city";

        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();

        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForNoRows(1);

        Assert.assertTrue(citiesPage.getCell(1,2).getText().contains(cityName),
                "Name cell doesn't contain text form search input");

        citiesPage.getDeleteButtonForRow(1).click();


        citiesPage.waitForDeleteDialogueVisibility();
        citiesPage.getDeleteButtonFromDialogue().click();
        messagePopUpPage.waitForSucessDialog();

        Assert.assertTrue(messagePopUpPage.getMessageFromSuccessPopUp()
                .getText()
                .contains("Deleted successfully"),"Message is incorrect");


    }
}