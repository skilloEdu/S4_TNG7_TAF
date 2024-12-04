package homework.seleniumTests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(14));

    @BeforeMethod
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void verifyHomePageLayoutForNotLoggedInUser () throws InterruptedException {

        driver.get(BASE_URL);  // 15 second the page to loaded
        //=============================================================
        //>>>>>>>>>>>>>>>>>  1  N A V I G A T I O N     TO      L O G I N      P A G E
        //Step 1 Provide verification that the user is landing the home page of ISkilo

        System.out.println("Step: 1 *** The user has landing on ISkilo home page");

        //1.1. First check that the user is on home page - page Title
        String actualPageTitle =  driver.getTitle();
        Assert.assertEquals(PAGE_TITLE,actualPageTitle);

        //1.2. Second check that the use is on hope page =
        //1.2.1. navigation nar home
        WebElement navigationBarHomeLink = driver.findElement(By.id("nav-link-home"));
        String expectedHomeLinkTxt = "Home";
        String actualHomeLinkText = navigationBarHomeLink.getText();
        Assert.assertEquals(actualHomeLinkText,expectedHomeLinkTxt);

        //1.2.2. navigation bar login
        WebElement navigationBarLoginLink = driver.findElement(By.xpath("//li/a[contains(@id,'nav-link-login')]"));
        String expectedLoginTxt = "Login";
        String actualLoginTxt =  navigationBarLoginLink.getText();
        Assert.assertEquals(actualLoginTxt,expectedLoginTxt);

        System.out.println("Step: 2. ***  ");

        WebElement nav_bar_login_btn = driver.findElement(By.xpath("//a[contains(@id,'nav-link-login')]"));
        wait.until(ExpectedConditions.visibilityOf(nav_bar_login_btn));
        wait.until(ExpectedConditions.elementToBeClickable(nav_bar_login_btn));
        nav_bar_login_btn.click();
    }

   @Test
   public void verifyUserCanLoginWithValidCredentials() throws InterruptedException {

        //Step 1: Go to login page
        driver.get("http://training.skillo-bg.com:4300/users/login");

        //Step 1.1. Verify you are on the Login page
        //Step 1.1.1. Check login form title = //p[contains(text(),'Sign in')]
        WebElement signInFormTitle = driver.findElement(By.xpath("//p[contains(text(),'Sign in')]"));
        String  expectedSignInFormTitle = "Sign in";
        String actualSignInFormTitle = signInFormTitle.getText();
        Assert.assertEquals(actualSignInFormTitle,expectedSignInFormTitle);

        //Step 1.1.2. Check the user is on the login page
        WebElement usernameInputField = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));
        String expectedPlaceHolderForUserName = "Username or email";
        String actualPlaceHolderForUserName = usernameInputField.getAttribute("placeholder");
        Assert.assertEquals(expectedPlaceHolderForUserName,actualPlaceHolderForUserName);

       //Step 1.1.3. Verify placeholder for password

       //Step 1.1.4. Verify login form submit button text


       // Step 2 provide username
       String USER = "n3TestingDemo";
       usernameInputField.clear();
       usernameInputField.sendKeys(USER);

       //Step 3 provide password
       WebElement userPasswordInputField = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
       String PASSWORD = "testing!";

       userPasswordInputField.clear();
       userPasswordInputField.sendKeys(PASSWORD);

        //Step 4 click on login form submit button
       WebElement loginFormSubmitButton = driver.findElement(By.id("sign-in-button"));

       boolean isLgnBtnEnabled = loginFormSubmitButton.isDisplayed();

       if (isLgnBtnEnabled){
           System.out.println("I Believe that the login button is enabled . Really ?");
           loginFormSubmitButton.click();
       };

       WebElement generalAlertMSG = driver.findElement(By.xpath("//div[contains(@class,'toast-message ng-star-inserted')]"));
       String expectedErrorMSg = "Wrong username or password!";
       String actualErrorMsg = generalAlertMSG.getText();
       Assert.assertEquals(actualErrorMsg,expectedErrorMSg);


       Thread.sleep(3333);
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
