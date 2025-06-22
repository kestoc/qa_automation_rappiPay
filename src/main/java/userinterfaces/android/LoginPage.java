package userinterfaces.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage {
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    public WebElement usernameInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    public WebElement passwordInput;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    public WebElement loginButton;
}
