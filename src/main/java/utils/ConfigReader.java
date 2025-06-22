package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties properties = new Properties();

    /**
     * Carga un archivo de propiedades basado en el nombre de la plataforma (ej: "android" o "ios").
     *
     * @param platform nombre de la plataforma
     */
    public static void loadProperties(String platform) {
        String filePath = "src/test/resources/properties/" + platform.toLowerCase() + ".properties";

        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.clear();  // limpia propiedades anteriores
            properties.load(input);
            logger.info("Configuración cargada correctamente desde: {}", filePath);
        } catch (IOException e) {
            logger.error("Error al cargar el archivo de propiedades: {}", filePath, e);
            throw new RuntimeException("Error al cargar el archivo de propiedades: " + filePath, e);
        }
    }

    /**
     * Retorna el valor de una propiedad dado su nombre.
     *
     * @param key clave de la propiedad
     * @return valor asociado a la clave
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.error("La propiedad '{}' no fue encontrada en el archivo cargado.", key);
            throw new RuntimeException("La propiedad '" + key + "' no fue encontrada.");
        }
        return value;
    }
}
