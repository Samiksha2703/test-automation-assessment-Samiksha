package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import static utils.JSONUtil.getValue;

public class EmergencyContactsPage extends BasePage {

    public EmergencyContactsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='EmergencyContact']//div//div//button[text()='Add New ']")
    private static WebElement addNewContactButton;

    @FindBy(xpath = "//*[@id=\"grid\"]/tbody/tr/td[6]/div/img[2]")
    private static WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"deleteModel\"]/div/div/div[3]/button[2]")
    private static WebElement deleteConfirmationButton;

    @FindBy(xpath = "//*[@id=\"grid\"]/tbody/tr/td[1]")
    private static WebElement contactData;

    @FindBy(xpath = "//input[@id='name']")
    private static WebElement name;
    @FindBy(xpath = "//input[@id='relationship']")
    private static WebElement relationship;
    @FindBy(xpath = "//input[@id='home_phone']")
    private static WebElement home_phone;
    @FindBy(xpath = "//input[@id='work_phone']")
    private static WebElement work_phone;
    @FindBy(xpath = "//input[@id='mobile_phone']")
    private static WebElement mobile_phone;
    @FindBy(xpath = "//button[text()=' Save']")
    private static WebElement saveButton;

    public boolean addContact() {
        if (contactData.getText().equalsIgnoreCase("ABC")) {
            clickOnElement(deleteButton);
            clickOnElement(deleteConfirmationButton);
        }
        waitForElementToBeInvisible(addNewContactButton);
        clickOnElement(addNewContactButton);
        waitForElementToBeInvisible(name);
        enterText("ABC", name);
        enterText("Father", relationship);
        enterText("5478547584", home_phone);
        enterText("9844545490", work_phone);
        enterText("7893473489", mobile_phone);
        clickOnElement(saveButton);
        if (contactData.getText().equalsIgnoreCase("ABC"))
            return true;
        else return false;
    }
}
