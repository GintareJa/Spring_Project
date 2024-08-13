package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectDashboardPageTest extends BaseTest {

    private ProjectDashboardPage projectDashboardPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        projectDashboardPage = new ProjectDashboardPage(driver);


        loginPage.setInputEmail("validUser@mail.com");
        loginPage.setInputPassword("ValidPassword123*");
        loginPage.setClickSignInButton();
        Thread.sleep(3000);
        projectDashboardPage.clickNavigateToAddProjectsButton();
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Navigate to Project dashboard")
    public void navigateToProjectDashboard() throws InterruptedException {

        assertTrue(projectDashboardPage.isAddProjectButtonPresent(), "Add Project button should be present on the dashboard page.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("download csv")
    public void downloadCSV() {
        assertTrue(projectDashboardPage.isDownloadCSVButtonPresent(), "Download CSV button should be present on the dashboard page.");
        projectDashboardPage.clickDownloadCSVButton();

    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Search functionality")
    public void searchFunctionality() {
        assertTrue(projectDashboardPage.isSearchInputFieldPresent(), "Search input field should be present on the dashboard page.");
        projectDashboardPage.enterSearchText("Test Project");

    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Delete project")
    public void deleteProject() {
        assertTrue(projectDashboardPage.isDeleteProjectButtonPresent(), "Delete Project button should be present on the dashboard page.");
        projectDashboardPage.clickDeleteProjectButton();
        projectDashboardPage.clickConfirmDeleteButton();

    }
}
