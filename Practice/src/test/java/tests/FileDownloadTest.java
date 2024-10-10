package tests;

import constants.MainPageNavigation;
import io.qameta.allure.*;
import org.testng.Assert;
import pages.FileDownloadPage;
import utils.FileUtils;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.qameta.allure.Allure.step;

public class FileDownloadTest extends BaseTest {
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();
    private final String fileName = SettingsTestData.getFileData().getDownloadFile();
    private final String filePath = SettingsTestData.RESOURCES_PATH + fileName;
    private final File downloadedFile = new File(filePath);

    @Test(testName = "File download test")
    @Description("This test attempts to download a file from the webpage and then it verifies in the local folder that the file exist or not.\n Fails if incorrect id password is provided.\n")
    @Owner("A1QA")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Allure Practice")
    @Feature("Essential features")
    @Story("File Downloading")
    public void fileDownloadTest() {
        mainPage.clickNavigationLink(MainPageNavigation.FILE_DOWNLOAD);
        step("Verifying that the file download link is displayed or not");
        Assert.assertTrue(fileDownloadPage.isFileDownloadLinkDisplayed(fileName), "File link is not displayed yet!");
        fileDownloadPage.clickFileDownloadLink(fileName);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), "File is not downloaded yet!");
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}
