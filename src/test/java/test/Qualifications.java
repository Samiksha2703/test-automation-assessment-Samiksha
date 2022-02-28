package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import setup.BaseTest;

public class Qualifications extends BaseTest {

    @DataProvider(name = "dataProvider")

    public Object[][] dataProviderMethod() {
        return new Object[][]{{"user1", "demouserpwd"},
                                {"user2", "demouserpwd"},
                                {"manager", "demouserpwd"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void addQualifications(String username, String password) {
        Boolean result = page.getClass(LoginPage.class).loginIntoTheApplication(username, password).navigateToQualificationsPage().addSkill();
        Assert.assertTrue(result);
    }
}
