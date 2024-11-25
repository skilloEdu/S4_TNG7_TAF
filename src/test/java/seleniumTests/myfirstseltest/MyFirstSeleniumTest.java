package seleniumTests.myfirstseltest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyFirstSeleniumTest {

    @Test
    public void myFirstSeleniumTestHere() throws InterruptedException {
        int WAIT = 4444;
        String baseURL = "https://www.google.bg/";
        String searchQuery = "My First Selenium Test Lives Here";

        WebDriver driver = new ChromeDriver();

        driver.get(baseURL);

        // Step 1: Close AgreeAll window
        WebElement agreeWithAllTermsBtn = driver.findElement(By.cssSelector("#L2AGLb"));
        agreeWithAllTermsBtn.click();

        //Step 2: Provide search query
        WebElement searchInputField = driver.findElement(By.cssSelector("#APjFqb"));
        searchInputField.sendKeys(searchQuery);

        //Step 3: Submit the search query
//      WebElement searchSubmitBtn = driver.findElement(By.xpath("(//input[contains(@type,'submit')])[3]"));
//       searchSubmitBtn.click();
        searchInputField.sendKeys(Keys.ENTER);
        Thread.sleep(WAIT);

        //Step 4 : Navigate Back
        driver.navigate().back();
        Thread.sleep(WAIT);

        //Step 4 : Navigate forward
        driver.navigate().forward();
        Thread.sleep(WAIT);

        //How to close browser
        driver.close();


    }
}
