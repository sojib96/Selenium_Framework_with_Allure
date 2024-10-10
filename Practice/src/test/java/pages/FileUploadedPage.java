package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FileUploadedPage extends Form {
    private static final String NAME = "File Uploaded!";
    private final By uploadedFileLocator = By.id("uploaded-files");
    private ILabel uploadedFile = AqualityServices.getElementFactory().getLabel(uploadedFileLocator, "Choose File");

    public FileUploadedPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    @Step("Getting the name of the uploaded file")
    public String getUploadedFileName() {
        return uploadedFile.getText();
    }
}
