package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static AppiumDriver driver;

    public static AppiumDriver getDriver(String platform) {
        if (driver == null) {
            driver = initializeDriver(platform);
        }
        return driver;
    }

    private static AppiumDriver initializeDriver(String platform) {
        ConfigReader.loadProperties(platform);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        logger.info("Inicializando driver para plataforma: {}", platform);

        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            capabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            capabilities.setCapability("automationName", ConfigReader.getProperty("automationName"));
            capabilities.setCapability("app", ConfigReader.getProperty("app"));
            capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
            capabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));

            try {
                return new AndroidDriver(new URL(ConfigReader.getProperty("appiumServerURL")), capabilities);
            } catch (MalformedURLException e) {
                logger.error("URL de Appium malformada: {}", e.getMessage());
                throw new RuntimeException(e);
            }

        } else {
            logger.error("Plataforma no soportada: {}", platform);
            throw new UnsupportedOperationException("Solo se soporta Android en esta versión.");
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("Cerrando sesión del driver");
            driver.quit();
            driver = null;
        }
    }
}
