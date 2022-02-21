package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;


public class DriverUtils {
    private static DriverUtils instance = null;
    ThreadLocal<RemoteWebDriver> webdriver = new ThreadLocal<RemoteWebDriver>();

    private DriverUtils() {
    }

    public static DriverUtils getInstance() {
        try {
            if (instance == null)
                instance = new DriverUtils();
        } catch (Exception e) {
            Reporter.log("[Error] Driver instance not created");
        }
        return instance;
    }

    // Test method to set Driver
    public void setDriver() {
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-popup-blocking");
            ChromeDriver chromedriver = new ChromeDriver(options);
            chromedriver.manage().window().maximize();
            chromedriver.manage().deleteAllCookies();
            chromedriver.get("https://icehrm-open.gamonoid.com/");
            webdriver.set(chromedriver);
        } catch (Exception e) {
            System.out.println("[Error] Driver is not intialized " + e.getMessage());
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver() {
        return webdriver.get();
    }
}
