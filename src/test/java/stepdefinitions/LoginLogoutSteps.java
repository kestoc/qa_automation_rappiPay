package stepdefinitions;

import base.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import questions.HomePageTitleAppears;
import tasks.LoginUser;
import tasks.LogoutUser;

public class LoginLogoutSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginLogoutSteps.class);
    private AppiumDriver driver;

    @Before
    public void setUp() {
        logger.info("Inicializando driver y abriendo la aplicación.");
        driver = DriverFactory.getDriver("android");
    }

    @After
    public void tearDown() {
        logger.info("Cerrando driver y la aplicación.");
        DriverFactory.quitDriver();
    }

    @Given("que la aplicación está abierta")
    public void aplicacion_abierta() {
        logger.info("La aplicación está abierta.");
        // El driver ya abre la app al inicializarse
    }

    @When("el usuario inicia sesión con usuario root y contraseña root")
    public void el_usuario_inicia_sesión_con_usuario_root_y_contraseña_root() {
        logger.info("Iniciando sesión con usuario: root");
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        new LoginUser(driver).withCredentials("root", "root");
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("la pantalla principal debe mostrarse correctamente")
    public void la_pantalla_principal_debe_mostrarse_correctamente() {
        logger.info("Validando que la pantalla principal se muestre correctamente.");
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        HomePageTitleAppears homePage = new HomePageTitleAppears(driver);
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Assert.assertTrue("El título de la HomePage no es visible", homePage.isTitleVisible());
        Assert.assertTrue("El texto 'Products' no es visible", homePage.isProductsVisible());
    }

    @And("el usuario cierra sesión")
    public void usuario_cierra_sesion() {
        logger.info("Cerrando sesión del usuario.");
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        new LogoutUser(driver).currentUser();
        try {
            Thread.sleep(2000); // Espera 2 segundos para observar el login
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}