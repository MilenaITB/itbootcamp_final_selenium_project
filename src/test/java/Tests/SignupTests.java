package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the signup page")
    public void visitTheSignupPage(){
        navPage.getSignUpButtonLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.getSignUpButtonLink().click();
        Assert.assertEquals(signupPage.getEmailInput().getAttribute("type"), "email",
                "Wrong email type.");
        Assert.assertEquals(signupPage.getPasswordInput().getAttribute("type"), "password",
                "Wrong password type.");
        Assert.assertEquals(signupPage.getConfirmPasswordInput().getAttribute("type"), "password",
                "Wrong confirm password type");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user already exists")
    public void errorWhenUserAlreadyExists(){
        navPage.getSignUpButtonLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
        signupPage.getNameInput().sendKeys("Another User");
        signupPage.getEmailInput().sendKeys("admin@admin.com");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("E-mail already exists"),
                "Error notification doesn't contain 'E-mail already exists' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Wrong URL, not on signup page!");
    }
    @Test(priority = 40)
    @Description("Test #4: Signup")
    public void signUp() throws InterruptedException {
        navPage.getSignUpButtonLink().click();
        signupPage.getNameInput().sendKeys("Goran Mitic");
        signupPage.getEmailInput().sendKeys("goran91@itbootcamp.rs");
        signupPage.getPasswordInput().sendKeys("12345");
        signupPage.getConfirmPasswordInput().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForVerifyYourAccountPopUp();
        Assert.assertTrue(messagePopUpPage.verifyPopUpText().contains("IMPORTANT: Verify your account"),
                "Notification doesn't contain 'IMPORTANT: Verify your account' text");
        messagePopUpPage.closeButtonVerifyPopUp().click();
        navPage.getLogoutButton().click();
    }
}


