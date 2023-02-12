package Tests;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage(){

        navPage.getChangeLanguageButton().click();
        navPage.getEnLanguageButton().click();
        navPage.getLoginButtonLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.getLoginButtonLink().click();
        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"), "email",
                "Wrong email type.");
        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"), "password",
                "Wrong password type.");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user does not exist")
    public void errorWhenUserDoesNotExist(){
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("User does not exists"),
                "Error notification doesn't contain 'User does not exists' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 40)
    @Description("Test #4: Displays errors when password is wrong")
    public void errorWhenPasswordIsWrong(){
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.popUpText().contains("Wrong password"),
                "Error notification doesn't contain 'Wrong password' text");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on login page!");
    }
    @Test(priority = 50)
    @Description("Test #5: Login")
    public void login() throws InterruptedException {
        navPage.getLoginButtonLink().click();
        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getLoginButton().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Wrong URL, not on home page!");
    }
    @Test(priority = 60)
    @Description("Test #6: Logout")
    public void logout(){
        Assert.assertTrue(navPage.getLogoutButton().isDisplayed(), "Logout button is not visible");
        navPage.getLogoutButton().click();
    }
}

