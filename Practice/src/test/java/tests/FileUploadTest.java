package tests;

import constants.MainPageNavigation;
import io.qameta.allure.*;
import org.testng.Assert;
import pages.FileUploadPage;
import pages.FileUploadedPage;
import utils.SettingsTestData;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final String fileName = SettingsTestData.getFileData().getUploadFile();
    private final String filePath = SettingsTestData.TEST_DATA_PATH + fileName;
    private final FileUploadPage fileUploadPage = new FileUploadPage();
    private final FileUploadedPage fileUploadedPage = new FileUploadedPage();

    @Test(testName = "File upload test")
    @Description("This test attempts to upload a file from the webpage and then it verifies that the uploaded file name matches or not.\n Fails if incorrect id password is provided.\n")
    @Owner("A1QA")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Allure Practice")
//    @Feature("Essential features")
    @Story("Uploading file")
    public void fileUploadTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        fileUploadPage.chooseFile(new File(filePath).getAbsolutePath());
        fileUploadPage.clickUploadButton();
        Assert.assertEquals(fileUploadedPage.getUploadedFileName(), fileName, "File Name Does not match");
    }
}
