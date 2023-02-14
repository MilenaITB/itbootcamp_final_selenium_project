package Tests;

import Pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;
    protected CitiesPage citiesPage;
    protected ProfilePage profilePage;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);


    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }
    @AfterMethod
    public void afterMethod() throws IOException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String strDate = dateFormat.format(date);
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("screenshots/screenshot"+strDate+".jpg").toPath());
    }
    @AfterClass
    public void afterClass(){

        driver.quit();
    }
    protected void CheckUrl(String route){
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + route,
                "Url is incorrect");
    }
    protected void waitForUrl(String route){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(route));
    }
}