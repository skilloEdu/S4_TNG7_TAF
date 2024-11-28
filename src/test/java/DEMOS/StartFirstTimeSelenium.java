package DEMOS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StartFirstTimeSelenium {

    @Test
    public void verifyIcanStartSeleniumOnMachine() throws InterruptedException {

        WebDriver driver =new ChromeDriver();

        Thread.sleep(4444);

        driver.get("https://www.google.bg/");

        Thread.sleep(4444);

    }
}
