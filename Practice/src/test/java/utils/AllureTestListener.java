package utils;
import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureTestListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return AqualityServices.getBrowser().getScreenshot();
    }

    public void onTestFailure(ITestResult result) {
        attachScreenshot();
    }
}

