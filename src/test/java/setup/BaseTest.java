package setup;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.BasePage;
import pageobjects.DriverUtils;

public class BaseTest {
    protected static DriverUtils driverutil;
    protected BasePage page;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        driverutil = DriverUtils.getInstance();
        driverutil.setDriver();
        page = new BasePage(driverutil.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driverutil.getDriver().quit();
    }
}
