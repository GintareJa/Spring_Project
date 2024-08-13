package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskRegistrationPage extends BasePage {

    public TaskRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    private By navigateToTaskPage = By.cssSelector("div:nth-of-type(1) > .djfyYi.sc-jIGoMM > .jAHSAQ.sc-fBdQPP");
    private By addTaskButton = By.cssSelector(".bMdWvH.sc-eBMFzZ");
    private By nameField = By.cssSelector("input#name");
    private By descriptionField = By.cssSelector("textarea#description");
    private By priorityDropdown = By.cssSelector("select#priority");
    private By mediumPriority = By.cssSelector("select#priority > option[value='medium']");
    private By lowPriority = By.xpath("//option[@value='low']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By nameErrorMessage = By.xpath("//div[@id='root']//form//span[.='Name must be at least 2 characters long.']");
    private By tooLongNameErrorMessage = By.xpath("//div[@id='root']//form//span[.='Name must be maximum 50 characters long.']");
    private By descriptionErrorMessage = By.xpath("//div[@id='root']//form//span[.='Description must be at least 2 characters long.']");
    private By taskNamePresent = By.cssSelector(".bChUhB.sc-jsJARu");
    private By addTaskButtonPresent = By.cssSelector(".bMdWvH.sc-eBMFzZ");
    private By editTask = By.cssSelector(".kMKvpB.sc-bmzXxz");

    // Methods
    public void setNavigateToTaskPage() {
        driver.findElement(navigateToTaskPage).click();
    }

    public void setAddTaskButton() {
        driver.findElement(addTaskButton).click();
    }

    public void enterTaskName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterTaskDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void selectTaskPriority() {
        driver.findElement(priorityDropdown).click();
    }

    public void setMediumPriority() {
        driver.findElement(mediumPriority).click();
    }

    public void setLowPriority() {
        driver.findElement(lowPriority).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
public void  setEditTask(){
        driver.findElement(editTask).click();
}
    // Methods to check for elements
    public boolean isNameFieldPresent() {
        return driver.findElements(nameField).size() > 0;
    }

    public boolean isDescriptionFieldPresent() {
        return driver.findElements(descriptionField).size() > 0;
    }

    public boolean isNameErrorMessagePresent() {
        return driver.findElements(nameErrorMessage).size() > 0;
    }

    public boolean isTooLongNameErrorMessagePresent() {
        return driver.findElements(tooLongNameErrorMessage).size() > 0;
    }

    public boolean isDescriptionErrorMessagePresent() {
        return driver.findElements(descriptionErrorMessage).size() > 0;
    }

    public boolean isTaskNamePresent() {
        return driver.findElements(taskNamePresent).size() > 0;
    }

    public boolean isAddTaskButtonPresent() {
        return driver.findElements(addTaskButtonPresent).size() > 0;
    }
}
