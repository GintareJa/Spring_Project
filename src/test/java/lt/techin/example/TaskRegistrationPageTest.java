package lt.techin.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskRegistrationPageTest extends BaseTest {

    private ProjectDashboardPage projectDashboardPage;
    private TaskRegistrationPage taskRegistrationPage;
    private LoginPage loginPage;
    private ProjectRegistrationPage projectRegistrationPage;

    @BeforeEach
    public void setUpTest() throws InterruptedException {
        loginPage = new LoginPage(driver);
        projectDashboardPage = new ProjectDashboardPage(driver);
        projectRegistrationPage = new ProjectRegistrationPage(driver);
        taskRegistrationPage = new TaskRegistrationPage(driver);

        // Log in and create a test project before each test
        loginPage.setInputEmail("validUser@mail.com");
        loginPage.setInputPassword("ValidPassword123*");
        loginPage.setClickSignInButton();
        Thread.sleep(3000);
        projectDashboardPage.clickNavigateToAddProjectsButton();
        projectDashboardPage.clickAddProjectButton();
        projectRegistrationPage.enterProjectName("Test Project");
        projectRegistrationPage.enterProjectDescription("This is a test project.");
        projectRegistrationPage.clickSubmitButton();
        projectDashboardPage.clickNavigateToAddProjectsButton();
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Navigate to Task Registration Page")
    public void addNewTaskNavigation() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        assertTrue(taskRegistrationPage.isNameFieldPresent(), "Task registration page should be displayed with an empty form.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Enter Task Name")
    public void enterTaskName() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskName("Test Task");
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isTaskNamePresent(), "Task name should be entered and displayed correctly.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Enter Task Description")
    public void enterTaskDescription() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskDescription("This is a test task description.");
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isTaskDescriptionPresent(), "Task description should be entered and displayed correctly.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Empty Fields Notification")
    public void emptyFieldsNotification() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isNameErrorMessagePresent(), "Name field cannot be empty.");
//        assertTrue(taskRegistrationPage.isDescriptionErrorMessagePresent(), "Description field cannot be empty.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Short Task Name Notification")
    public void shortTaskNameNotification() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskName("A");
        taskRegistrationPage.clickSubmitButton();
        assertTrue(taskRegistrationPage.isNameErrorMessagePresent(), "Name must be at least 2 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Short Task Description Notification")
    public void shortTaskDescriptionNotification() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskDescription("A");
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isDescriptionErrorMessagePresent(), "Description must be at least 2 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Task Name Max Length Notification")
    public void taskNameMaxLengthNotification() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskName("A".repeat(51)); // Ensure this handles max length properly
        taskRegistrationPage.clickSubmitButton();
        assertTrue(taskRegistrationPage.isTooLongNameErrorMessagePresent(), "Name must be maximum 50 characters long.");
    }

    @Test
    @Tag("invalid_Test")
    @DisplayName("Task Description Max Length Notification")
    public void taskDescriptionMaxLengthNotification() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskDescription("A".repeat(10001)); // Ensure this handles max length properly
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isDescriptionErrorMessagePresent(), "Description must be maximum 10,000 characters long.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Select Task Priority")
    public void selectTaskPriority() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.selectTaskPriority();
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isTaskPriorityPresent(), "Task priority should be set to Low.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Change Task Name")
    public void modifyTaskName() throws InterruptedException {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setEditTask();
        taskRegistrationPage.enterTaskName("Updated Task Name");
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isTaskNamePresent(), "Task name should be updated.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Change Task Description")
    public void modifyTaskDescription() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setEditTask();
        taskRegistrationPage.enterTaskDescription("Updated task description.");
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isDescriptionFieldPresent(), "Task description should be updated.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Change Task Priority")
    public void modifyTaskPriority() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setEditTask();
        taskRegistrationPage.setMediumPriority();
        taskRegistrationPage.clickSubmitButton();
//        assertTrue(taskRegistrationPage.isDescriptionFieldPresent(), "Task priority should be updated to Medium.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Valid Task Submission")
    public void validTaskSubmission() {
        taskRegistrationPage.setNavigateToTaskPage();
        taskRegistrationPage.setAddTaskButton();
        taskRegistrationPage.enterTaskName("Valid Task");
        taskRegistrationPage.enterTaskDescription("This is a valid task description.");
        taskRegistrationPage.setLowPriority();
        taskRegistrationPage.clickSubmitButton();
        assertTrue(taskRegistrationPage.isAddTaskButtonPresent(), "User should be navigated back to the project page.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Verify Task Details")
    public void verifyTaskDetails() {
        taskRegistrationPage.setNavigateToTaskPage();
        assertTrue(taskRegistrationPage.isTaskNamePresent(), "Task name should be displayed.");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Search Functionality")
    public void searchFunctionality() {
        assertTrue(projectDashboardPage.isSearchInputFieldPresent(), "Search input field should be present on the project page.");
        projectDashboardPage.enterSearchText("Test Task");
    }

    @Test
    @Tag("valid_Test")
    @DisplayName("Download CSV")
    public void downloadCSV() {
        assertTrue(projectDashboardPage.isDownloadCSVButtonPresent(), "Download CSV button should be present on the project page.");
        projectDashboardPage.clickDownloadCSVButton();
    }
}
