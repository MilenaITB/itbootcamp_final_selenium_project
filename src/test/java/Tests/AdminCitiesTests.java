package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitTheSignupPage() throws InterruptedException {
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Wrong URL, not on cities page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checkInputTypes() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogueVisibility();
        Assert.assertEquals(citiesPage.getCityNameInput().getAttribute("type"), "text",
                "Wrong city name input type!");
    }
    @Test(priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForEditAndCreateDialogueVisibility();
        citiesPage.getCityNameInput().sendKeys("Goran Mitic's city");
        citiesPage.getSaveButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSaved();
        Assert.assertTrue(messagePopUpPage.popUpSavedText().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text!");
    }
    @Test(priority = 40)
    @Description("Test #4: Edit city")
    public void editCity() throws InterruptedException {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Goran Mitic's city");
        citiesPage.waitForNoRows(1);
        citiesPage.getEditButtonForRow(1).click();
        citiesPage.getCityNameInput().click();
        citiesPage.getCityNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getCityNameInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getCityNameInput().sendKeys("Goran Mitic's city edited");
        citiesPage.getSaveButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpSaved();
        Assert.assertTrue(messagePopUpPage.popUpSavedText().contains("Saved successfully"),
                "Error notification doesn't contain 'Saved successfully' text!");
    }
    @Test(priority = 50)
    @Description("Test #5: Search city")
    public void searchCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Goran Mitic's city edited");
        citiesPage.waitForNoRows(1);
        Assert.assertEquals(citiesPage.getCell(1, 2).getText(), "Goran Mitic's city edited",
                "Wrong city name!");
    }
    @Test(priority = 60)
    @Description("Test #6: Delete city")
    public void deleteCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys("Goran Mitic's city edited");
        citiesPage.waitForNoRows(1);
        Assert.assertEquals(citiesPage.getCell(1, 2).getText(), "Goran Mitic's city edited",
                "Wrong city name");
        citiesPage.getDeleteButtonForRow(1).click();
        citiesPage.waitForDeleteDialogueVisibility();
        citiesPage.getDeleteButtonFromDialogue().click();
        messagePopUpPage.waitForPopUpDeleted();
        Assert.assertTrue(messagePopUpPage.popUpDeletedText().contains("Deleted successfully"),
                "Notification doesn't contain 'Deleted successfully' text!");
    }
}