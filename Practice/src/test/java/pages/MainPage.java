package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import constants.MainPageNavigation;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "Welcome to the-internet")), "Main Page");
    }

    @Step("Getting the {0} link for navigating")
    private ILink getNavigationLink(MainPageNavigation navigation) {
        return AqualityServices.getElementFactory().getLink(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,
                navigation.getLabel())), navigation.getLabel());
    }

    @Step("Navigating to the page {0}")
    public void clickNavigationLink(MainPageNavigation navigation) {
        getNavigationLink(navigation).click();
    }
}
