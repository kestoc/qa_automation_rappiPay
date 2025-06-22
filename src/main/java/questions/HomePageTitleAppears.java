package questions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import userinterfaces.android.HomePage;

public class HomePageTitleAppears {
    private static final Logger logger = LoggerFactory.getLogger(HomePageTitleAppears.class);
    private final HomePage homePage;

    public HomePageTitleAppears(AppiumDriver driver) {
        this.homePage = new HomePage();
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePage);
    }

    public boolean isTitleVisible() {
        try {
            boolean visible = homePage.title.isDisplayed();
            logger.info("El título de la HomePage es visible.");
            return visible;
        } catch (Exception e) {
            logger.error("No se pudo validar la visibilidad del título de la HomePage", e);
            return false;
        }
    }

    public boolean isProductsVisible() {
        try {
            boolean visible = homePage.productText.isDisplayed();
            logger.info("El texto 'Products' es visible en la HomePage.");
            return visible;
        } catch (Exception e) {
            logger.error("No se pudo validar la visibilidad del texto 'Products' en la HomePage", e);
            return false;
        }
    }
}