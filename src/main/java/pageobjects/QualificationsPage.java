package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class QualificationsPage extends BasePage {

    public QualificationsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='EmployeeSkill']//div//div//button[text()='Add New ']")
    private static WebElement addNewSkillsButton;

    @FindBy(xpath = "//*[@id=\"grid\"]/tbody/tr/td[3]/div/img[2]")
    private static WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"deleteModel\"]/div/div/div[3]/button[2]")
    private static WebElement deleteConfirmationButton;

    @FindBy(xpath = "//div[@id='EmployeeEducation']//div//div//button[text()='Add New ']")
    private static WebElement addNewEducationButton;

    @FindBy(xpath = "//div[@id='s2id_skill_id']")
    private static WebElement selectSkill;

    @FindBy(xpath = "//div[text()='Programming and Application Development']")
    private static WebElement programmingAndApplicationDevelopment;

    @FindBy(xpath = "//div//textarea[@id='details']")
    private static WebElement details;

    @FindBy(xpath = "//*[@id=\"EmployeeSkill_submit\"]/div/div[4]/div[1]/button[1]")
    private static WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"grid\"]/tbody/tr/td[1]")//*[@id="grid"]/tbody/tr/td[1]
    private static WebElement skillData;

    public boolean addSkill() {
        if (skillData.getText().equalsIgnoreCase("Programming and Application Development")) {
            clickOnElement(deleteButton);
            clickOnElement(deleteConfirmationButton);
        }
        waitForElementToBeInvisible(addNewSkillsButton);
        clickOnElement(addNewSkillsButton);
        waitForElementToBeInvisible(selectSkill);
        clickOnElement(selectSkill);
        clickOnElement(programmingAndApplicationDevelopment);
        enterText("Java,Javascrip,HTML,CSS", details);
        clickOnElement(submitButton);
        waitForElementToBeInvisible(selectSkill);
        if (skillData.getText().equalsIgnoreCase("Programming and Application Development"))
            return true;
        else return false;
    }
}
