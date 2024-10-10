package tests;

import io.qameta.allure.*;
import pages.JavaScriptAlertsPage;
import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertTest extends BaseTest {
    private final JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Test(testName = "Javascript_Alert_Test")
    @Epic("Allure Practice")
    @Features({
            @Feature("Essential features"),
            @Feature("Dynamic features")
    })
    @Story("Accepting the alert")
    @Description("This test attempts to accept javascript alert of a webpage and verify that the alert is accepted or not.\n Fails if the alert is not accepted.\n")
    @Owner("A1QA")
    @Severity(SeverityLevel.MINOR)
    public void alertTest() {
        mainPage.clickNavigationLink(MainPageNavigation.JAVASCRIPT_ALERT);
        javaScriptAlertsPage.clickForJsAlertBtn();
        javaScriptAlertsPage.acceptAlert();
        Assert.assertTrue(javaScriptAlertsPage.isSuccessLabelDisplayed(), "Success msg is not displayed");
    }
}
