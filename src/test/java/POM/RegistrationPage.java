package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

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

    public RegistrationPage(WebDriver driver){
        super(driver);
    };


    public void provideUserName () {
        WebElement userNameInputField  = driver.findElement(By.id(loginFormUserNameInputField_locator));

        wait.until(ExpectedConditions.visibilityOf(userNameInputField));
        userNameInputField.clear();
        userNameInputField.sendKeys("THIS IS MY USER");
    }

}
