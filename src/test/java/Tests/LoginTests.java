package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{


    @Test(priority = 1)
    @Description("Test #1: Visits the login page")
    public void visitLoginPage(){
        navPage.getLanguageButton().click();
        navPage.getEnFromDropDown().click();
        navPage.getLoginButton().click();

        CheckUrl("/login");
    }
    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void CheckInputTypes(){

        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email", "Attribute type is incorrect");

        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password", "Attribute type is incorrect");

    }
    @Test(priority = 3)
    @Description("Test #3: Displays errors when user does not exist")
    public void userDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));

        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage().getText(),
                "User does not exists",
                "Error message is incorrect");

        CheckUrl("/login");
    }
    @Test(priority = 4)
    @Description("Test #4: Displays errors when password is wrong")
    public void passwordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        wait.until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));

        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage().getText(),
                "Wrong password",
                "Error message is incorrect");

        CheckUrl("/login");
    }
    @Test(priority = 5)
    @Description("Login with correct credentials")
    public void Login(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        wait.until(ExpectedConditions.urlContains("/home"));

    }
    @Test(priority = 6)
    @Description("Logout user")
    public void Logout(){
        navPage.getLogoutButton().click();
    }

}
