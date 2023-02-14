package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//Pages
//Login Page
//Polje za unos email-a
//Polje za unos lozinke
//Dugme za login.

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }
    public WebElement getEmailInput(){

        return driver.findElement(By.cssSelector("input#email"));
    }
    public WebElement getPasswordInput(){

        return driver.findElement(By.cssSelector("#password"));
    }
    public WebElement getLoginButton(){

        return driver.findElement(By.cssSelector("*[type='submit']"));
    }
}