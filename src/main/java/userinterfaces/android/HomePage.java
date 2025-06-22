package userinterfaces.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage {
    @AndroidFindBy(accessibility = "View menu")
    public WebElement menuTab;

    @AndroidFindBy(accessibility = "Login Menu Item")
    public WebElement loginOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Products\")")
    public WebElement productText;

    @AndroidFindBy(accessibility = "App logo and name")
    public WebElement title;

    @AndroidFindBy(accessibility = "Logout Menu Item")
    public WebElement logoutOption;
}
