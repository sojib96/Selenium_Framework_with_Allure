package tests;

import io.qameta.allure.*;
import pages.DataTablesPage;
import constants.MainPageNavigation;
import utils.SettingsTestData;
import utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTableTests extends BaseTest {
    private final DataTablesPage dataTablesPage = new DataTablesPage();

    @Test(testName = "Dynamic data table test")
    @Description("This test attempts to test dynamic data table.\n It tries to get value from data table row and verify the sum of the value is matched with accepted value or not.\n Fails if incorrect id password is provided.\n")
    @Owner("A1QA")
    @Severity(SeverityLevel.TRIVIAL)
    @Epic("Allure Practice")
    @Feature("Uploading file")
    @Story("Getting expected sum")
    public void dataTableTest() {
        mainPage.clickNavigationLink(MainPageNavigation.SORTABLE_DATA_TABLES);
        Double actualSum = 0.0;
        for (String due : dataTablesPage.getFirstDueList()) {
            actualSum += StringUtils.getDoubleFromString(due);
        }
        Assert.assertEquals(actualSum, SettingsTestData.getDataTableData().getExpectedDueSum(), "Sum is not correct");
    }
}
