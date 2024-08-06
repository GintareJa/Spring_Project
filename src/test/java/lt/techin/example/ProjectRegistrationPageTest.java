package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;

public class ProjectRegistrationPageTest extends BaseTest {

    private ProjectRegistrationPage projectRegistrationPage;

    @BeforeEach
    public void setUpTest() {
        projectRegistrationPage = new ProjectRegistrationPage(driver);
    }
}
