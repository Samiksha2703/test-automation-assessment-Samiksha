package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.User;
import setup.BaseTest;

public class Travel extends BaseTest {

    @DataProvider(name = "dataProvider")

    public Object[][] dataProviderMethod() {
        return new Object[][]{{"user1", "demouserpwd"},
                                {"user2", "demouserpwd"},
                                {"manager", "demouserpwd"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void createTravelRequest(String username, String password) {
        page.getClass(LoginPage.class).loginIntoTheApplication(username, password);
    }
}
