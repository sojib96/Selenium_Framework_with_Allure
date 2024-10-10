package pages;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FileUploadPage extends Form {
    private final static String NAME = "File Upload";
    private final By chooseFileLocator = By.id("file-upload");
    private final By uploadFileLocator = By.id("file-submit");
    private ITextBox chooseFileTextBox = AqualityServices.getElementFactory().getTextBox(chooseFileLocator, "Choose File");
    private IButton uploadFileButton = AqualityServices.getElementFactory().getButton(uploadFileLocator, "submit button");

    public FileUploadPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    @Step("Choosing the appropriate file to upload")
    public void chooseFile(String filename) {
        chooseFileTextBox.clearAndType(filename);
    }

    @Step("Clicking on the upload button")
    public void clickUploadButton() {
        uploadFileButton.click();
    }
}
