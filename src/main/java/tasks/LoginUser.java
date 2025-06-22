package tasks;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import userinterfaces.android.HomePage;
import userinterfaces.android.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public class LoginUser {
    private final AppiumDriver driver;
    private final HomePage homePage;
    private final LoginPage loginPage;

    public LoginUser(AppiumDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPage);
    }

    public void withCredentials(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.menuTab));
        homePage.menuTab.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.loginOption));
        homePage.loginOption.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput));
        loginPage.usernameInput.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.passwordInput.sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
        loginPage.loginButton.click();
    }
}
