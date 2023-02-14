package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getNewItemButton(){
        return driver.findElement(By.xpath("//div[@class='text-right']/button"));
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement waitForEditAndCreateDialogueVisibility(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }
    public WebElement waitForDeleteDialogueVisibility(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-dialog')]//header[contains(@class, 'warning')]")));
    }
    public WebElement getSaveButtonFromDialogue(){

        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getDeleteButtonFromDialogue(){
        return driver.findElement
                (By.xpath("//div[2]/button[2]"));
    }
    public void waitForNoRows(int rows){
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//div[@class='v-data-table__wrapper']//tbody/tr"), rows));
    }
    public WebElement getCell(int row, int column){
        return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+column+"]"));
    }
    public WebElement getEditButtonForRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]/td[1]/div/button[@id='edit']"));
    }
    public WebElement getDeleteButtonForRow(int row){
        return driver.findElement(By.xpath("//tr["+row+"]/td[1]/div/button[@id='delete']"));
    }
    public WebElement getCityNameInput(){

        return driver.findElement(By.id("name"));
    }
}