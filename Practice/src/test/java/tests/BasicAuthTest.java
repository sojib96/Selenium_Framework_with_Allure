package tests;

import constants.MainPageNavigation;
import io.qameta.allure.*;
import org.testng.Assert;
import pages.BasicAuthPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    @Step("Providing username and password along with http requestmcn")
    public void auth() {
        getBrowser().network().addBasicAuthentication(
                SettingsTestData.getEnvData().getDomain(),
                SettingsTestData.getUserData().getUsername(),
                SettingsTestData.getUserData().getPassword()
        );
    }

    @Test(description = "Basic authentication test")
    @Description("This test attempts to login via http request.\n Fails if incorrect id password is provided.\n")
    @Epic("Allure Practice")
    @Feature("Essential features")
    @Story("Authentication")
    @Owner("A1QA")
    @Severity(SeverityLevel.BLOCKER)
    public void basicAuthTest() {
        mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(), "Login failed!");
    }
}
