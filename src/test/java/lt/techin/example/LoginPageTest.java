package lt.techin.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(driver);
    }


}