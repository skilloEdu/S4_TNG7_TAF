package PageObjectsTestCase;

import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM_LoginTestCase {

    public static final int WAIT = 3333;

   @Test
    public void EndToEndTestCaseV1() throws InterruptedException {
       WebDriver driver = new ChromeDriver();
       HomePage homePage = new HomePage(driver);

       homePage.navigateToHomePage();

       homePage.clickOnNavigationBarLoginButton();
       Thread.sleep(WAIT);

       LoginPage loginPage = new LoginPage(driver);
       loginPage.provideUserName();



       Thread.sleep(WAIT);


   }
}
