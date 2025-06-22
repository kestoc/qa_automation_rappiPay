package tasks;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import userinterfaces.android.HomePage;
import userinterfaces.android.LogoutModal;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutUser {
    private final AppiumDriver driver;
    private final HomePage homePage;
    private final LogoutModal logoutModal;

    public LogoutUser(AppiumDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage();
        this.logoutModal = new LogoutModal();
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), logoutModal);
    }

    public void currentUser() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(homePage.menuTab));
        homePage.menuTab.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.logoutOption));
        homePage.logoutOption.click();

        wait.until(ExpectedConditions.visibilityOf(logoutModal.logoutText));

        logoutModal.confirmLogout.click();
    }
}
