package pageobjects;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
    static RemoteWebDriver driver;
    protected int timeToWaitInSecs = 50;
    WebDriverWait wait;

    public BasePage(RemoteWebDriver webdriver) {
        driver = webdriver;
        wait = new WebDriverWait(driver, timeToWaitInSecs);
        PageFactory.initElements(webdriver, this);
    }

    // Test method to enter the text
    protected static void enterText(String textToEnter, WebElement element) {
//            element.clear();
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(textToEnter);
    }

    public static void setAttribute(WebElement element, String attName, String attValue) {
        driver.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    // Test method to click on Element
    protected static void clickOnElement(WebElement element)
            throws NoSuchElementException, StaleElementReferenceException {
        element.click();
    }

    protected boolean waitForElementToBeInvisible(WebElement mobileElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.invisibilityOf(mobileElement));

        } catch (TimeoutException | NoSuchElementException e1) {
            return false;
        }
        return true;
    }

    // Test method to get the text of element
    protected static String getTextOfElement(WebElement element) {
        return element.getText();
    }

    // Upload File
    protected static void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    public <TPage extends BasePage> TPage getClass(Class<TPage> anyPage) {
        try {
            return anyPage.getDeclaredConstructor(RemoteWebDriver.class).newInstance(driver);
        } catch (Exception e) {
            Reporter.log("[ERROR] Exception Cause " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
