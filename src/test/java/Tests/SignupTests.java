package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{

    @Test(priority = 10)
    @Description("Test #1: Visits the signup page")
    public void visitSignupPage(){
        navPage.getSignupLink().click();
        wait.until(ExpectedConditions.urlContains("/signup"));
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.getSignupLink().click();

        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"),
                "password",
                "Password type is incorrect");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "Confirm password type is incorrect");
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"),
                "email",
                "email type is incorrect");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user already exists")
    public void userExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignupLink().click();
        waitForUrl("/signup");

        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();

        wait.until(ExpectedConditions.visibilityOf(messagePopUpPage.getStatusPopUp()));

        Assert.assertEquals(messagePopUpPage.getStatusErrorMessage().getText(),
                "E-mail already exists",
                "Error message is incorrect");

        waitForUrl("/signup");

    }
    @Test(priority = 40)
    @Description("Test #4: Signup new user")
    public void signup() throws InterruptedException {
        String name = "Milena Manojlovic";
        String email = "milena.manojlovic@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignupLink().click();
        waitForUrl("/signup");

        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();

        Thread.sleep(2000);
        driver.get(baseUrl + "/home");

        //wait
        Thread.sleep(2000);
        messagePopUpPage.waitForVerifyBoxToBeVisible();
        Assert.assertEquals(messagePopUpPage.getElementWithTextFromVerifyBox().getText(),
                "IMPORTANT: Verify your account",
                "Error message is incorrect");
        messagePopUpPage.getVerifyAccountDialogButton().click();
        navPage.getLogoutButton().click();

    }


}