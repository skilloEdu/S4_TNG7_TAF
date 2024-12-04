package homework.seleniumDemos.alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsInteraction {
    //Test cases consts
    private final static String BASE_URL = "https://www.selenium.dev/";
    private final int WAIT = 3333;
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

    @BeforeTest
    public void tearUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("*** THE BROWSER HAS STARTED ****");
    }

    @Test
    public void verifySimpleAlertInteraction() throws InterruptedException {

        //1 Test case local vars
        //1 .1. Navigation vars
        String ALERT_URL = BASE_URL+"documentation/webdriver/interactions/alerts/";
        String EXPEXTED_ALERT_URL = "https://www.selenium.dev/documentation/webdriver/interactions/alerts/";
        //1.2. WebElements locatorStrategies

        //1.3. Texts and Messages or Alerts etc.

        //Test Case navigation
        driver.get(ALERT_URL);

        //Test Case navigation verification
        wait.until(ExpectedConditions.urlContains(EXPEXTED_ALERT_URL));

        //Test case selenium interactions
        // We need to create a webElement with the Selenium library
        WebElement alertButton = driver.findElement(By.linkText("See an example alert"));
        wait.until(ExpectedConditions.visibilityOf(alertButton));
        alertButton.click();

        //Test Case real functionality checks
        // User selenium library Select
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());

        //Interaction with a simple Alert
        //Get the text of the alert
        System.out.println("THE ALERT TEXT IS : "+ simpleAlert.getText());

        //Accept the alert
        simpleAlert.accept();
        Thread.sleep(WAIT);

    }

    @Test
    public void verifyConfirmationAlertInteraction() throws InterruptedException {

        //1 Test case local vars
        //1 .1. Navigation vars
        String ALERT_URL = BASE_URL+"documentation/webdriver/interactions/alerts/";
        String EXPEXTED_ALERT_URL = "https://www.selenium.dev/documentation/webdriver/interactions/alerts/";
        //1.2. WebElements locatorStrategies

        //1.3. Texts and Messages or Alerts etc.

        //Test Case navigation
        driver.get(ALERT_URL);

        //Test Case navigation verification
        wait.until(ExpectedConditions.urlContains(EXPEXTED_ALERT_URL));

        //Move a bit down to see the alert button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");

        //Test case selenium interactions
        // We need to create a webElement with the Selenium library

        WebElement confirmationAlertButton = driver.findElement(By.xpath("//h2[contains(@id,'confirm')]/../p[5]/a"));
        wait.until(ExpectedConditions.visibilityOf(confirmationAlertButton));
        confirmationAlertButton.click();

        //Test Case real functionality checks
        // User selenium library Select
        Alert confirmationAlert = wait.until(ExpectedConditions.alertIsPresent());

        //Interaction with a simple Alert
        //Get the text of the alert
        System.out.println("THE CONFIRMATION ALERT TEXT IS : "+ confirmationAlert.getText());

        //Accept the alert
        confirmationAlert.accept();
        Thread.sleep(WAIT);
    }

    @Test
    public void verifyPromptAlertInteraction() throws InterruptedException {

        //Test Case navigation
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //Test case selenium interactions
        // We need to create a webElement with the Selenium library
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        wait.until(ExpectedConditions.visibilityOf(promptAlertButton));
        wait.until(ExpectedConditions.elementToBeClickable(promptAlertButton));
        promptAlertButton.click();

        //Test Case real functionality checks
        // User selenium library Select
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        //Interaction with a simple Alert
        //Get the text of the alert
        System.out.println("THE PROMPT ALERT TEXT IS : "+ promptAlert.getText());

        //Type your message
        String promptMSG = "TestingPrompt";
        promptAlert.sendKeys(promptMSG);
        Thread.sleep(WAIT);

        //When using chrome the text provided in the ProptAlert it will not be visible even thou it is accepted

        //Accept the alert
        promptAlert.accept();
        Thread.sleep(WAIT);

        //Verify that the text it was sent with SendKeys
        //By checking a appearing paragraph with the result from the ProptBox text provided
        WebElement providedTextInPromptBox = driver.findElement(By.xpath("//p[contains(@id,'result')]"));

       String actualProvidedPromptText =  providedTextInPromptBox.getText();
       boolean isTextProvided = actualProvidedPromptText.contains(promptMSG);

       Assert.assertTrue(isTextProvided);
    }

    @AfterTest
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
