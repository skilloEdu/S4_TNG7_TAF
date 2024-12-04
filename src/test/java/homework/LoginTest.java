package homework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    //Test cases consts
    private final static String BASE_URL = "http://training.skillo-bg.com:4200/posts/all";
    private final String PAGE_TITLE = "ISkillo";
    private final int WAIT = 3333;
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

    @BeforeMethod
    public void tearUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("*** THE BROWSER HAS STARTED ****");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }




    @Test
    public void verifyUserCanLoginWithValidCredentials() throws InterruptedException {

        // MAIN I WebElements or other  UI Map

        // MAIN I
        // 1 Home page locators
        String navBarHomeLink_locator = "nav-link-home";
        String navBarLoginLink_locator = "nav-link-login";
        String navBarProfileLink_locator = "nav-link-profile";
        String navBarLogOutButton = "//i[contains(@class,'fas fa-sign-out-alt fa-lg')]/..";

        // MAIN I
        // 2 Login page locators
        // 2.1. Login form properties
        String loginFormHeaderTitle_locator = "p.h4";
        String loginFormUserNameInputField_locator = "defaultLoginFormUsername";
        String loginFormPasswordField_locator = "defaultLoginFormPassword";
        String loginFormRememberMeCheckBox_locator = "//span[contains(text(),'Remember me')]";
        String loginFormRememberMeCheckBoxLabelText_locator ="//input[contains(@formcontrolname,'rememberMe')]";
        String loginFormLoginFormSubmitButton_locator = "sign-in-button";
        String loginFormLoginFormRegistrationLink_locator = "//a[contains(.,'Register')]";

        // 2.2. Message locators
        String loginPageMSG_locator = "//div[contains(@class,'toast-message ng-star-inserted')]";


        // Test logic lives here
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
        WebElement navigation_bar_home_Link = driver.findElement(By.id(navBarHomeLink_locator));
        String expectedHomeLinkTxt = "Home";
        String actualHomeLinkText = navigation_bar_home_Link.getText();
        Assert.assertEquals(actualHomeLinkText,expectedHomeLinkTxt);

        //1.2.2. navigation bar login
        WebElement navigation_nar_loginLink = driver.findElement(By.id(navBarLoginLink_locator));
        String expectedLoginTxt = "Login";
        String actualLoginTxt =  navigation_nar_loginLink.getText();
        Assert.assertEquals(actualLoginTxt,expectedLoginTxt);
        waitAndClick(navigation_nar_loginLink);

        System.out.println("Step: 2. ***  ");
        // PROVIDE LAYOUT CHECK
        WebElement login_form_userName_input_field = driver.findElement(By.id(loginFormUserNameInputField_locator));
        typeTextAt(login_form_userName_input_field,"gandalf");

        WebElement login_form_password_input_field  = driver.findElement(By.id(loginFormPasswordField_locator));
        typeTextAt(login_form_password_input_field,"thegray");

        WebElement login_form_submit_button = driver.findElement(By.id(loginFormLoginFormSubmitButton_locator));
        login_form_submit_button.click();

        //Verifications
        //1 Login msg info
        WebElement login_page_msg_info = driver.findElement(By.xpath(loginPageMSG_locator));
        wait.until(ExpectedConditions.visibilityOf(login_page_msg_info));
        String msgInfoText = login_page_msg_info.getText();
        Assert.assertEquals(msgInfoText,"Successful login!");

        Thread.sleep(WAIT);

        WebElement navigation_bar_profile_link = driver.findElement(By.id(navBarProfileLink_locator));
        waitAndClick(navigation_bar_profile_link);

        Thread.sleep(WAIT);
        driver.findElement(By.id("nav-link-new-post")).click();

        WebElement modalElement = driver.findElement(By.className("post-modal"));
       wait.until(ExpectedConditions.visibilityOf(modalElement));

        WebElement postImage = modalElement.findElement(By.cssSelector(".post-modal-img img"));
        WebElement postUser = modalElement.findElement(By.className("post-user"));

    }

    private void typeTextAt(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    private void  waitAndClick (WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }



}
