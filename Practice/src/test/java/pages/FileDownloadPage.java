package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FileDownloadPage extends Form {
    private static final String NAME = "File Download";

    public FileDownloadPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    @Step("Clicking on the download link")
    public void clickFileDownloadLink(String name) {
        getFileDownloadLink(name).click();
    }

    @Step("Verifying that the file download link is displayed or not")
    public boolean isFileDownloadLinkDisplayed(String name) {
        return getFileDownloadLink(name).state().isDisplayed();
    }

    private ILink getFileDownloadLink(String name) {
        return AqualityServices.getElementFactory().
        getLink(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, name)),name);
    }
}
