package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.cssSelector(".btnLocaleActivation"));
    }
    public WebElement getEnFromDropDown(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".v-menu__content .v-list-item:nth-child(1)")));
    }
    public WebElement getEsFromDropDown(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".v-menu__content .v-list-item:nth-child(2)")));
    }
    public WebElement getFrFromDropDown(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".v-menu__content .v-list-item:nth-child(3)")));
    }
    public WebElement getCnFromDropDown(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".v-menu__content .v-list-item:nth-child(4)")));
    }
    public WebElement getUaFromDropDown(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector(".v-menu__content .v-list-item:nth-child(5)")));
    }
    public WebElement getPageHeader(){
        return driver.findElement(By.cssSelector("h1"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("a[href='/login']"));
    }
    public WebElement getMyProfileLink(){
        return driver.findElement(By.cssSelector("a[href='/profile']"));
    }
    public WebElement getLogoutButton(){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btnLogout"))));
    }
    public WebElement getSignupLink(){
        return driver.findElement(By.cssSelector("a[href='/signup']"));
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.cssSelector(".btnAdmin"));
    }
    public WebElement getCitiesLink(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnAdminCities")));
    }
}