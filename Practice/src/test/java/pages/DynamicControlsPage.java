package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DynamicControlsPage extends Form {
    private final static String NAME = "Dynamic Controls";
    private final By enableDisableButtonLocator = By.xpath("//*[@id='input-example']/button");
    private final By inputTextBoxLocator = By.xpath("//*[@id='input-example']/input");
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private IButton enableDisableBtn = elementFactory.getButton(enableDisableButtonLocator, "Enable Disable Button");
    private ITextBox inputTxtBox = elementFactory.getTextBox(inputTextBoxLocator, "Input Text Box");


    public DynamicControlsPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, NAME)), NAME);
    }

    @Step("Clicking on the eneable button")
    public void clickEnableButton() {
        enableDisableBtn.click();
    }

    @Step("Verifying that input box is enabled or not")
    public boolean isTextBoxEnabled() {
        return inputTxtBox.state().waitForEnabled();
    }

    @Step("Sending random text to the input filed")
    public void sendRandomText(String text) {
        inputTxtBox.clearAndType(text);
    }

    @Step("verifying that the random text is displayed or not and")
    public void isInputTextDisplayed() {
        inputTxtBox.state().waitForDisplayed();
    }
     @Step("getting the text of random text")
    public String getValueOfInputBox() {
        return inputTxtBox.getValue();
    }

}
