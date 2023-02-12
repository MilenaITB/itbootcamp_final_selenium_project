package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
    @Test(priority = 10)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToEs(){
        navPage.getChangeLanguageButton().click();
        navPage.getEsLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Página de aterrizaje"),
                "Header doesn't contain 'Página de aterrizaje' text!");
    }
    @Test(priority = 20)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEn(){
        navPage.getChangeLanguageButton().click();
        navPage.getEnLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Landing"),
                "Header doesn't contain 'Landing' text!");
    }
    @Test(priority = 30)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCn(){
        navPage.getChangeLanguageButton().click();
        navPage.getCnLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("首页"),
                "Header doesn't contain '首页' text!");
    }
    @Test(priority = 40)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFr(){
        navPage.getChangeLanguageButton().click();
        navPage.getFrLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Page d'atterrissage"),
                "Header doesn't contain 'Page d'atterrissage' text!");
    }
    @Test(priority = 50)
    @Description("Test #5: Set locale to UA")
    public void setLocaleToUa(){
        navPage.getChangeLanguageButton().click();
        navPage.getUaLanguageButton().click();
        Assert.assertTrue(driver.getPageSource().contains("Лендінг"),
                "Header doesn't contain 'Лендінг' text!");
    }
}