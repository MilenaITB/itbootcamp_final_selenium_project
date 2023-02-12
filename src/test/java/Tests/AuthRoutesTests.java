package Tests;


import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {
    @Test(priority = 10)
    @Description("Test #1: Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on home page!");
    }
    @Test(priority = 20)
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on profile page!");
    }
    @Test(priority = 30)
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on admin cities page!");
    }
    @Test(priority = 40)
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminCUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Wrong URL, not on admin users page!");
    }
}
