package lt.techin.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectDashboardPage extends BasePage {

    public ProjectDashboardPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    private By navigateToAddProject = By.xpath("//div[@id='root']/nav//a[@href='/projects']/img[@alt='Projects icon']");
    private By addProjectButton = By.cssSelector(".bMdWvH.sc-eBMFzZ");
    private By downloadCSVButton = By.cssSelector("img[alt='Download']");
    private By searchInputField = By.cssSelector(".cDlccX.sc-dtImxT");
    private By deleteProjectButton = By.cssSelector("");
    private By confirmDeleteButton = By.cssSelector("");

    // Methods
    public void clickNavigateToAddProjectsButton(){
        driver.findElement(navigateToAddProject).click();
    }
    public void clickAddProjectButton() {
        driver.findElement(addProjectButton).click();
    }

    public void clickDownloadCSVButton() {
        driver.findElement(downloadCSVButton).click();
    }

    public void enterSearchText(String text) {
        driver.findElement(searchInputField).sendKeys(text);
    }

    public void clickDeleteProjectButton() {
        driver.findElement(deleteProjectButton).click();
    }

    public void clickConfirmDeleteButton() {
        driver.findElement(confirmDeleteButton).click();
    }

    // Methods to check for elements
    public boolean isAddProjectButtonPresent() {
        return driver.findElements(addProjectButton).size() > 0;
    }

    public boolean isDownloadCSVButtonPresent() {
        return driver.findElements(downloadCSVButton).size() > 0;
    }

    public boolean isSearchInputFieldPresent() {
        return driver.findElements(searchInputField).size() > 0;
    }

    public boolean isDeleteProjectButtonPresent() {
        return driver.findElements(deleteProjectButton).size() > 0;
    }
}
