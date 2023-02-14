package Tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{

    @Test(priority = 1)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getEsFromDropDown().click();

        Assert.assertEquals(navPage.getPageHeader().getText(),
                "Página de aterrizaje",
                "Header message is incorrect");
    }
    @Test(priority = 2)
    @Description("Test #1: Set locale to EN")
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getEnFromDropDown().click();

        Assert.assertEquals(navPage.getPageHeader().getText(),
                "Landing",
                "Header message is incorrect");
    }
    @Test(priority = 3)
    @Description("Test #1: Set locale to FR")
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getFrFromDropDown().click();

        Assert.assertEquals(navPage.getPageHeader().getText(),
                "Page d'atterrissage",
                "Header message is incorrect");
    }
    @Test(priority = 4)
    @Description("Test #1: Set locale to CN")
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getCnFromDropDown().click();

        Assert.assertEquals(navPage.getPageHeader().getText(),
                "首页",
                "Header message is incorrect");
    }
    @Test(priority = 5)
    @Description("Test #1: Set locale to UA")
    public void setLocaleToUA(){
        navPage.getLanguageButton().click();
        navPage.getUaFromDropDown().click();

        Assert.assertEquals(navPage.getPageHeader().getText(),
                "Лендінг",
                "Header message is incorrect");
    }

}
