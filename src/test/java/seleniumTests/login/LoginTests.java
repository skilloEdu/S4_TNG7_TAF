package seleniumTests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    public static final String BASE_URL = "http://training.skillo-bg.com:4300/";
    public static final String PAGE_TITLE = "ISkillo";


    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    @BeforeMethod
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyUserCanNavigateToLoginPage () throws InterruptedException {

        driver.get(BASE_URL);
        //=============================================================
        //>>>>>>>>>>>>>>>>>  1  N A V I G A T I O N TO      L O G I N      P A G E
        //Step 1 Provide verification that the user is landing the home page of ISkilo
        System.out.println("Step: 1 *** The user has landing on ISkilo home page");
        String actualPageTitle =   driver.getTitle();
        Assert.assertEquals(PAGE_TITLE,actualPageTitle);


        System.out.println("Step: 1.1. *** Verify home page title when user is not logged in");
        WebElement nav_bar_login_btn = driver.findElement(By.xpath("//a[contains(@id,'nav-link-login')]"));

        nav_bar_login_btn.click();

        //Step type UserName in Login form userName input field
        WebElement user_name_input_field = driver.findElement(By.xpath("//input[contains(@id,'defaultLoginFormUsername')]"));

        user_name_input_field.clear();
        user_name_input_field.sendKeys("DqdoMraz");

        //We want to grap the text from the signIn btn
        WebElement signINBtn = driver.findElement(By.id("sign-in-button"));

        String signBtnLabel = signINBtn.getText();
        System.out.println(signBtnLabel);

        Thread.sleep(4444);
    }

    @AfterMethod
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }

    public void consoleLoggerForAMatch (String actual, String expected)  {
        System.out.println(" # # #  The is a match between "+actual + " :: " +expected);

    }

}
