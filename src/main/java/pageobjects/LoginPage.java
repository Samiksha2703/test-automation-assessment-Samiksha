package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private static WebElement username;

    @FindBy(id = "password")
    private static WebElement password;

    @FindBy(xpath = "//button[@type='button']")
    private static WebElement loginButton;

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean loginIntoTheApplication(String userName, String userPassword){
        waitForElementToBeInvisible(username);
        enterText(userName,username);
        enterText(userPassword,password);
        clickOnElement(loginButton);
        return true;
    }

}
