package setup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageobjects.BasePage;
import pageobjects.DriverUtils;

public class BaseTest {
    protected static DriverUtils driverutil;
    protected BasePage page;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void initialize(String browser) {
        driverutil = DriverUtils.getInstance();
        driverutil.setDriver(browser);
        page = new BasePage(driverutil.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driverutil.getDriver().quit();
    }
}
