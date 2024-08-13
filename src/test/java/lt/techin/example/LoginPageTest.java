package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(driver);
    }

    private String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    private String getRandomEmail() {
        return getRandomString(10) + "@mail.com";
    }

    private String getRandomPassword(int length) {
        return RandomStringUtils.randomAlphanumeric(length) + "123*";
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Login with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
        String email = "validUser@mail.com";
        String password = "ValidPassword123*";

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
        loginPage.waitForAccountPagePresent();
//        Thread.sleep(3000);
        assertTrue(loginPage.isAccountFormPresent(), "Account form should be present after login.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with invalid email")
    public void loginWithInvalidEmail() throws InterruptedException {
        String email = getRandomString(5);  // Invalid email
        String password = "ValidPassword123*";

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
//        Thread.sleep(3000);
        loginPage.waitForErrorMessage();
        assertTrue(loginPage.isErrorMessagePresent(), "Email error message should be present for invalid email.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with invalid password")
    public void loginWithInvalidPassword() throws InterruptedException {
        String email = "validUser@mail.com";
        String password = getRandomPassword(3);  // Invalid password

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
//        Thread.sleep(3000);
        loginPage.waitForErrorMessage();
        assertTrue(loginPage.isErrorMessagePresent(), "Password error message should be present for invalid password.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with unregister Email")
    public void loginWithUnregisteredEmail() throws InterruptedException {
        String email = getRandomEmail();  // Unregistered email
        String password = "ValidPassword123*";

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
//        Thread.sleep(3000);
        loginPage.waitForErrorMessage();
        assertTrue(loginPage.isErrorMessagePresent(), "Login error message should be present for unregistered email.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Login with empty credentials")
    public void loginWithEmptyCredentials() throws InterruptedException {
        loginPage.setClickSignInButton();
        Thread.sleep(3000);
        assertTrue(loginPage.isEmptyEmailErrorMessagePresent(), "Email error message should be present for empty email.");
        assertTrue(loginPage.isEmptyPasswordErrorMessagePresent(), "Password error message should be present for empty password.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Log out")
    public void logout() throws InterruptedException {
        String email = "validUser@mail.com";
        String password = "ValidPassword123*";

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.setClickSignInButton();
        loginPage.waitForAccountButton();
        loginPage.setClickAccountButton();
        loginPage.setClickLogoutButton();

        // Verify logout
        assertTrue(loginPage.isLoginFormPresent(), "Login form should be present after logout.");
    }
}
