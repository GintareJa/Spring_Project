package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    public By inputEmail = By.cssSelector("input[name='login']");
    public By inputPassword = By.cssSelector("input[name='password']");
    public By clickSignInButton = By.cssSelector(".hmTQif.sc-dAlxHm > .kLeRpb.sc-cPiJYC");

    // Methods
    public void setInputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }
    public void setInputPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }
    public void  setClickSignInButton(){
        driver.findElement(clickSignInButton).click();
    }
}
