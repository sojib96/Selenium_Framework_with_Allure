package utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.io.File;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class FileUtils {

    @Step("Verifying download file exist in the local folder")
    public boolean isFileExist(File file) {
        try {
            Awaitility.await().atMost(SettingsTestData.getEnvData().getWait(), TimeUnit.SECONDS).until(file::exists);
        } catch (ConditionTimeoutException exception) {
            return false;
        }
        return true;
    }

    @Step("Deleting the downloaded file")
    public void deleteFileIfExist(File file) {
        if (file.exists()) {
            file.delete();
        }
    }
}
