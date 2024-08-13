package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectRegistrationPage extends BasePage {

    public ProjectRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    private By nameField = By.cssSelector("input#name");
    private By descriptionField = By.cssSelector("textarea#description");
    private By submitButton = By.cssSelector(".iZuACH.sc-bDoQz"); // Update the CSS selector as needed
    private By nameErrorMessage = By.xpath("//div[@id='root']//form//span[.='Name must be at least 2 characters long.']");
    private By descriptionErrorMessage = By.xpath("//div[@id='root']//form//span[.='Description must be at least 2 characters long.']");
    private By statusDropdown = By.cssSelector("");
    private By editTask = By.xpath("//div[@id='root']/footer[.='Copywrite © 2024 PlanPro']");

    // Methods
    public void enterProjectName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterProjectDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void selectProjectStatus(String status) {
        driver.findElement(statusDropdown).sendKeys(status);
    }
    public void setEditTask(){driver.findElement(editTask).click();}

    // Methods to check for error messages
    public boolean isNameErrorMessagePresent() {
        return driver.findElements(nameErrorMessage).size() > 0;
    }

    public boolean isDescriptionErrorMessagePresent() {
        return driver.findElements(descriptionErrorMessage).size() > 0;
    }
    public boolean isNameFieldPresent(){
        return driver.findElements(nameField).size() > 0;
    }
}
