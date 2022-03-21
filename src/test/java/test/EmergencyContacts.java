package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.LoginPage;
import setup.BaseTest;
import static utils.JSONUtil.getValue;

@Listeners(test.TestListeners.class)

public class EmergencyContacts extends BaseTest {

    @Test
    public void addEmergencyContact() {
        String userName = getValue().get(0).getUsername();
        String password = getValue().get(0).getPassword();
        Boolean result = page.getClass(LoginPage.class).loginIntoTheApplication(userName, password).navigateToEmergencyContactsPage().addContact();
        Assert.assertFalse(result);
    }
}
