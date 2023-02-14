package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage extends BasePage{

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }
    public WebElement getVerifyAccountDialog(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".v-dialog--active")));
    }
    public WebElement getVerifyAccountDialogButton(){

        return driver.findElement(By.cssSelector(".btnClose"));
    }
    public WebElement getElementWithTextFromVerifyBox(){
        return this.driver.findElement(By.xpath(
                "//div[contains(@class, 'dlgVerifyAccount')]"));
    }
    public WebElement getStatusPopUp(){

        return driver.findElement(By.cssSelector("*[role='status']"));
    }
    public WebElement getStatusErrorMessage(){

        return driver.findElement(By.cssSelector("*[role='status'] li"));
    }
    public void waitForSucessDialog(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'success')]")));
    }
    public WebElement getMessageFromSuccessPopUp() {
        return this.driver.findElement(By.xpath(
                "//div[contains(@class, 'success')]"));
    }
    public void waitForVerifyBoxToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'dlgVerifyAccount')]")));
    }
}