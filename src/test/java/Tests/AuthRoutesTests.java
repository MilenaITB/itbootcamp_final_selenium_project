package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{

    @Test(priority = 1)
    @Description("Forbids visits to home url if not authenticated")
    public void homePage(){
        driver.navigate().to(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Url does not contain login");
    }
    @Test(priority = 2)
    @Description("Forbids visits to profile url if not authenticated")
    public void profilePage(){
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Url does not contain login");
    }
    @Test(priority = 3)
    @Description("Forbids visits to admin cities url if not authenticated")
    public void adminCitiesPage(){
        driver.navigate().to(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Url does not contain login");
    }
    @Test(priority = 4)
    @Description("Forbids visits to admin users url if not authenticated")
    public void adminUsersPage(){
        driver.navigate().to(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Url does not contain login");
    }
}