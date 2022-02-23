package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//li[@class='dropdown messages-menu']//a[@class='dropdown-toggle']//span//span")
    private static WebElement flagIcon;

    @FindBy(xpath = "//a//span[@class='flag-icon flag-icon-un']")
    private static WebElement EN;

    @FindBy(xpath = "//i[@class='fa fa-globe']")
    private static WebElement travelManagement;

    @FindBy(xpath = "//ul[@id='module_Travel_Management']")
    private static WebElement travel;


    public DashboardPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void navigateToMyTravel() throws InterruptedException {
        waitForElementToBeInvisible(travelManagement);
        clickOnElement(travelManagement);
        clickOnElement(travel);
    }

    public void changeLanguage() {
        waitForElementToBeInvisible(flagIcon);
        clickOnElement(flagIcon);
        clickOnElement(EN);
    }
}
