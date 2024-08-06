package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    // Selectors
    public By inputEmail = By.cssSelector("input[name='login']");
    public By inputPassword = By.cssSelector("input[name='password']");
    public By clickSignInButton = By.cssSelector(".hmTQif.sc-dAlxHm > .kLeRpb.sc-cPiJYC");
    public By clickAccountButton = By.xpath("//*//div[@id='root']/nav/div/div[2]/div/a[@href='/']");
    public By clickLogoutButton = By.xpath("//*[@id=\"root\"]/nav/div/div[2]/div/div/div/p");
    public By loginForm = By.cssSelector(".hmTQif.sc-dAlxHm > .kLeRpb.sc-cPiJYC");
    public By accountForm =By.cssSelector(".fcMlLd.sc-bBeLha");

    // Error message selectors
    public By errorMessage = By.cssSelector(".hmTQif.sc-dAlxHm > .gAJjJL.sc-dLNtp");
    public By emptyEmailErrorMessage = By.cssSelector(".goBvrH.sc-iGgVNO > img[alt='Account icon']");
    public By emptyPasswordErrorMessage = By.cssSelector("div:nth-of-type(2) > .gAJjJL.sc-dLNtp");

    // Methods
    public void setInputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void setInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void setClickSignInButton(){
        driver.findElement(clickSignInButton).click();
    }
    public void setClickAccountButton(){
        driver.findElement(clickAccountButton).click();
    }
    public void setClickLogoutButton(){
        driver.findElement(clickLogoutButton).click();
    }
    public void waitForAccountButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".goBvrH.sc-iGgVNO > img[alt='Account icon']")));
    }
    public void waitForAccountPagePresent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".fcMlLd.sc-bBeLha")));
    }
    public void waitForErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".hmTQif.sc-dAlxHm > .gAJjJL.sc-dLNtp")));
    }

    // Methods to check for error messages
    public boolean isErrorMessagePresent() {
        return driver.findElements(errorMessage).size() > 0;
    }

    public boolean isEmptyEmailErrorMessagePresent() {
        return driver.findElements(emptyEmailErrorMessage).size() > 0;
    }

    public boolean isEmptyPasswordErrorMessagePresent() {
        return driver.findElements(emptyPasswordErrorMessage).size() > 0;
    }

    public boolean isLoginFormPresent() {
        return driver.findElements(loginForm).size() > 0;
    }
    public boolean isAccountFormPresent(){
        return driver.findElements(accountForm).size() > 0;
    }
    }

