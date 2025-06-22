package userinterfaces.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
public class LogoutModal {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"you want to logout\")")
    public WebElement logoutText;

    @AndroidFindBy(id = "android:id/button1")
    public  WebElement confirmLogout;
}
