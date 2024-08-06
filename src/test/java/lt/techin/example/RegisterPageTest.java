package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RegisterPageTest extends BaseTest {

    private RegisterPage registerPage;

    @BeforeEach
    public void setUpTest() {
        registerPage = new RegisterPage(driver);
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
    public void registerWithRandomValidCredentials() {
        String username = getRandomString(8);
        String email = getRandomEmail();
        String password = getRandomPassword(8);

        registerPage.setClickSignUpButton();
        registerPage.setInputUserName(username);
        registerPage.setInputEmail(email);
        registerPage.setInputPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.setClickCreateAccountButton();

    }

    @Test
    public void registerWithRandomInvalidName() {
        String username = getRandomString(1);  // Invalid name
        String email = getRandomEmail();
        String password = getRandomPassword(8);

        registerPage.setClickSignUpButton();
        registerPage.setInputUserName(username);
        registerPage.setInputEmail(email);
        registerPage.setInputPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.setClickCreateAccountButton();

        // Verify the presence of username error message
        assertTrue(registerPage.isUsernameErrorMessagePresent(), "Username error message should be present for invalid username.");
    }

    @Test
    public void registerWithRandomInvalidEmail() {
        String username = getRandomString(8);
        String email = getRandomString(5);  // Invalid email
        String password = getRandomPassword(8);

        registerPage.setClickSignUpButton();
        registerPage.setInputUserName(username);
        registerPage.setInputEmail(email);
        registerPage.setInputPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.setClickCreateAccountButton();

        // Verify the presence of email error message
        assertTrue(registerPage.isEmailErrorMessagePresent(), "Email error message should be present for invalid email.");
    }

    @Test
    public void registerWithRandomInvalidPassword() {
        String username = getRandomString(8);
        String email = getRandomEmail();
        String password = getRandomPassword(3);  // Invalid password

        registerPage.setClickSignUpButton();
        registerPage.setInputUserName(username);
        registerPage.setInputEmail(email);
        registerPage.setInputPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.setClickCreateAccountButton();

        // Verify the presence of password error message
        assertTrue(registerPage.isPasswordErrorMessagePresent(), "Password error message should be present for invalid password.");
    }

    @Test
    public void registerWithRandomInvalidConfirmPassword() {
        String username = getRandomString(8);
        String email = getRandomEmail();
        String password = getRandomPassword(8);
        String invalidConfirmPassword = getRandomPassword(8); // Ensure confirm password is different

        registerPage.setClickSignUpButton();
        registerPage.setInputUserName(username);
        registerPage.setInputEmail(email);
        registerPage.setInputPassword(password);
        registerPage.setConfirmPassword(invalidConfirmPassword); // Different confirm password
        registerPage.setClickCreateAccountButton();

        // Verify the presence of confirm password error message
        assertTrue(registerPage.isConfirmPasswordErrorMessagePresent(), "Confirm password error message should be present for mismatched confirm password.");
    }}
