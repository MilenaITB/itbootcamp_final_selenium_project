package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

    @Test(priority = 1)
    @Description("Test #1: Visits the profile page")
    public void visitProfilePage() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();

        navPage.getMyProfileLink().click();
        waitForUrl("/profile");

        Thread.sleep(1000);
        navPage.getLogoutButton().click();
    }

    @Test(priority = 2)
    @Description("Test #2: Checks input types")
    public void checkInputTypes() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        Thread.sleep(1000);
        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        Thread.sleep(1000);

        navPage.getMyProfileLink().click();
        waitForUrl("/profile");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"),
                "email",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("disabled"),
                "true",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"),
                "text",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"),
                "text",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"),
                "text",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getTwitterUrlInput().getAttribute("type"),
                "url",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getGitHubUrlInput().getAttribute("type"),
                "url",
                "Value is incorrect");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"),
                "tel",
                "Value is incorrect");

        navPage.getLogoutButton().click();
    }


}