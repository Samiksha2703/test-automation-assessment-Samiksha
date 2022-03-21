package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import utils.PropertiesFile;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    private static DriverUtils instance = null;
    ThreadLocal<RemoteWebDriver> webdriver = new ThreadLocal<RemoteWebDriver>();
    PropertiesFile propertiesFile;

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
    public void setDriver(String browser) {
        try {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-popup-blocking");
            ChromeDriver chromedriver = new ChromeDriver(options);
            chromedriver = new ChromeDriver(options);
            chromedriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            chromedriver.manage().window().maximize();
            chromedriver.manage().deleteAllCookies();
            chromedriver.get(propertiesFile.getProperties("application_URL"));
            webdriver.set(chromedriver);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("disable-popup-blocking");
            EdgeDriver edgeDriver = new EdgeDriver(options);
            edgeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            edgeDriver.manage().window().maximize();
            edgeDriver.manage().deleteAllCookies();
            edgeDriver.get(propertiesFile.getProperties("application_URL"));
            webdriver.set(edgeDriver);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("disable-popup-blocking");
            FirefoxDriver firefoxDriver = new FirefoxDriver(options);
            firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            firefoxDriver.manage().window().maximize();
            firefoxDriver.manage().deleteAllCookies();
            firefoxDriver.get(propertiesFile.getProperties("application_URL"));
            webdriver.set(firefoxDriver);
        }
    } catch (Exception e) {
            System.out.println("[Error] Driver is not intialized " + e.getMessage());
            e.printStackTrace();
        }
    }

    public RemoteWebDriver getDriver() {
        return webdriver.get();
    }
}
