package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProjectRegistrationPageTest extends BaseTest {

    private ProjectRegistrationPage projectRegistrationPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        projectRegistrationPage = new ProjectRegistrationPage(driver);
        ProjectDashboardPage projectDashboardPage = new ProjectDashboardPage(driver);

        loginPage.setInputEmail("validUser@mail.com");
        loginPage.setInputPassword("ValidPassword123*");
        loginPage.setClickSignInButton();
        Thread.sleep(3000);
        projectDashboardPage.clickNavigateToAddProjectsButton();
        projectDashboardPage.clickAddProjectButton();
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Navigate to the project registration ")
    public void navigateToProjectRegistration() {

        assertTrue(projectRegistrationPage.isNameFieldPresent(), "Project registration page should be displayed.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Enter Project Name")
    public void enterProjectName() {
        projectRegistrationPage.enterProjectName("Test Project");

    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Enter Project Description")
    public void enterProjectDescription() {
        projectRegistrationPage.enterProjectDescription("This is a test project.");

    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Project name max Length notification")
    public void projectNameMaxLength() {
        projectRegistrationPage.enterProjectName("A".repeat(51));
        projectRegistrationPage.clickSubmitButton();
        assertTrue(projectRegistrationPage.isNameErrorMessagePresent(), "Name must be maximum 50 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Project description max Length notification")
    public void projectDescriptionMaxLength() {
        projectRegistrationPage.enterProjectDescription("A".repeat(10001));
        projectRegistrationPage.clickSubmitButton();
        assertTrue(projectRegistrationPage.isDescriptionErrorMessagePresent(), "Description must be maximum 10,000 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Empty fields notification")
    public void emptyFields() {
        projectRegistrationPage.clickSubmitButton();
//        assertTrue(projectRegistrationPage.isNameErrorMessagePresent(), "Name field cannot be empty.");
//        assertTrue(projectRegistrationPage.isDescriptionErrorMessagePresent(), "Description field cannot be empty.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Short Project name notification")
    public void shortProjectName() {
        projectRegistrationPage.enterProjectName("A");
        projectRegistrationPage.clickSubmitButton();
        assertTrue(projectRegistrationPage.isNameErrorMessagePresent(), "Name must be at least 2 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Short Project description notification")
    public void shortProjectDescription() {
        projectRegistrationPage.enterProjectDescription("A");
        projectRegistrationPage.clickSubmitButton();
        assertTrue(projectRegistrationPage.isDescriptionErrorMessagePresent(), "Description must be at least 2 characters long.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Valid Project submission")
    public void validProjectSubmission() {
        projectRegistrationPage.enterProjectName("Valid Project");
        projectRegistrationPage.enterProjectDescription("This is a valid project description.");
        projectRegistrationPage.clickSubmitButton();
        ProjectDashboardPage projectDashboardPage = new ProjectDashboardPage(driver);
        assertTrue(projectDashboardPage.isAddProjectButtonPresent(), "User should be navigated back to the project dashboard page.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("modify Project name")
    public void modifyProjectName() {
        projectRegistrationPage.enterProjectName("Updated Project Name");
        projectRegistrationPage.clickSubmitButton();

    }

    @Test
    @Tag("valid_Test")
    @DisplayName("modify Project description")
    public void modifyProjectDescription() {
        projectRegistrationPage.enterProjectDescription("Updated project description.");
        projectRegistrationPage.clickSubmitButton();

    }

    @Test
    @Tag("valid_Test")
    @DisplayName("modify Project status")
    public void modifyProjectStatus() {
        projectRegistrationPage.selectProjectStatus("Completed");
        projectRegistrationPage.clickSubmitButton();

    }
}
