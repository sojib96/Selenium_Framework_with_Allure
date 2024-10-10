package tests;

import constants.MainPageNavigation;
import io.qameta.allure.*;
import org.testng.Assert;
import pages.DynamicControlsPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String randomText = UUID.randomUUID().toString();

    @Test(testName = "Dynamic control test")
    @Description("This test attempts to test dynamic controls of webpage behaviour.\n Fails if incorrect id password is provided.\n")
    @Owner("A1QA")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Allure Practice")
    @Feature("Dynamic features")
    @Story("Waiting for enable dynamic button")
    public void dynamicControlsTest() {
        mainPage.clickNavigationLink(MainPageNavigation.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickEnableButton();
        Assert.assertTrue(dynamicControlsPage.isTextBoxEnabled(), "TextBox is not enabled");
        dynamicControlsPage.sendRandomText(randomText);
        dynamicControlsPage.isInputTextDisplayed();
        Assert.assertEquals(dynamicControlsPage.getValueOfInputBox(), randomText, "String does not match");
    }
}
