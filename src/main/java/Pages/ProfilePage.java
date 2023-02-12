package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.cssSelector("#email"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.cssSelector("#name"));
    }
    public WebElement getCityInput(){
        return driver.findElement(By.cssSelector("#city"));
    }
    public WebElement getCountryInput(){
        return driver.findElement(By.cssSelector("#country"));
    }
    public WebElement getTwitterUrlInput(){
        return driver.findElement(By.cssSelector("#urlTwitter"));
    }
    public WebElement getGitHubUrlInput(){
        return driver.findElement(By.cssSelector("#urlGitHub"));
    }
    public WebElement getPhoneInput(){
        return driver.findElement(By.cssSelector("#phone"));
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    public WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector(".success"));
    }

}
