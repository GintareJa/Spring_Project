package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    public By clickSignUpButton = By.cssSelector(".fRZdu.sc-eDPFhE");
    public By inputUserName = By.cssSelector("input[name='name']");
    public By inputEmail = By.cssSelector("input[name='email']");
    public By inputPassword = By.cssSelector("input[name='password']");
    public By confirmPassword = By.cssSelector("input[name='repeatPassword']");
    public By clickCreateAccountButton = By.cssSelector(".fCZwOC.sc-hZDzol");

    // Error message selectors (modify these based on your application's actual selectors)
    public By usernameErrorMessage = By.cssSelector(".dowWKa.sc-ktJcvw");  // Example
    public By emailErrorMessage = By.cssSelector("div:nth-of-type(3) > .lJCWn.sc-jGKwVr");        // Example
    public By passwordErrorMessage = By.cssSelector(".dowWKa.sc-ktJcvw");  // Example
    public By confirmPasswordErrorMessage = By.cssSelector(".sc-ktJcvw"); // Example

    // Methods
    public void setClickSignUpButton() {
        driver.findElement(clickSignUpButton).click();
    }

    public void setInputUserName(String name) {
        driver.findElement(inputUserName).sendKeys(name);
    }

    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        driver.findElement(confirmPassword).sendKeys(password);
    }

    public void setClickCreateAccountButton() {
        driver.findElement(clickCreateAccountButton).click();
    }

    // Methods to check for error messages
    public boolean isUsernameErrorMessagePresent() {
        return driver.findElements(usernameErrorMessage).size() > 0;
    }

    public boolean isEmailErrorMessagePresent() {
        return driver.findElements(emailErrorMessage).size() > 0;
    }

    public boolean isPasswordErrorMessagePresent() {
        return driver.findElements(passwordErrorMessage).size() > 0;
    }

    public boolean isConfirmPasswordErrorMessagePresent() {
        return driver.findElements(confirmPasswordErrorMessage).size() > 0;
    }
}

