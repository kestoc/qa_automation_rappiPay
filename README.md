# Prueba técnica QA Automation RappiPay - Kevin Ocampo

## 📦 Dependencias y versiones usadas

Este proyecto utiliza las siguientes dependencias principales:

| **Dependencia**                      | **Versión** | **Propósito principal**                                      |
|-------------------------------------|-------------|---------------------------------------------------------------|
| Appium Java Client                  | 8.6.0       | Automatización de apps móviles                                |
| JUnit 4                             | 4.13.2      | Framework de testing                                          |
| JUnit Jupiter (JUnit 5)            | 5.9.3       | Framework de testing (opcional, para JUnit 5)                 |
| Selenium Remote Driver              | 4.13.0      | Soporte para WebDriver remoto                                 |
| Cucumber Java                       | 7.14.0      | Soporte para pruebas BDD con Cucumber                         |
| Cucumber JUnit                      | 7.14.0      | Integración de Cucumber con JUnit                             |
| Cucumber JUnit Platform Engine      | 7.14.0      | Soporte para JUnit Platform con Cucumber                      |
| Maven Surefire Plugin               | 3.1.2       | Ejecución de pruebas unitarias con Maven                      |
| Maven Cucumber Reporting Plugin     | 5.8.5       | Generación de reportes HTML de Cucumber                       |
| Cucumber Reporting (librería)       | 5.7.0       | Generación de reportes HTML de Cucumber                       |
| SLF4J API                           | 2.0.12      | API de logging                                                |
| Logback Classic                     | 1.4.14      | Implementación de logging                                     |
| Hamcrest                            | 2.2         | Matchers para aserciones en tests                             |

# 🚀 Instrucciones para ejecutar las pruebas

---

## 1. Pre-requisitos

Asegúrate de tener instalado lo siguiente en tu entorno antes de comenzar:

* **Java 11**
* **Maven**
* **Node.js**
* **Appium** (instalado globalmente). Si no los tienes, puedes instalarlos con:
    ```bash
    npm install -g appium
    ```
* **Android SDK** y al menos un emulador configurado.
* **Appium Doctor** (opcional, pero recomendado para verificar el entorno). Si no lo tienes, instálalo con:
    ```bash
    npm install -g appium-doctor
    ```
---

## 2. Verifica tu entorno

Es crucial que tu entorno esté correctamente configurado. Para ello, ejecuta el siguiente comando:
  ```bash
  appium-doctor --android
  ```
y sigue las recomendaciones hasta que todo esté en verde.

---

## 3. Inicia el emulador Android

Es **fundamental** que tu emulador Android esté encendido y en funcionamiento antes de ejecutar la prueba. Tienes dos opciones para iniciarlo:

* **Desde Android Studio:** Abre Android Studio y lanza tu emulador desde el AVD Manager.
* **Desde la terminal:** Si prefieres la línea de comandos, puedes iniciarlo con el siguiente comando, reemplazando `<nombre_de_tu_avd>` con el nombre de tu Android Virtual Device:

    ```bash
    emulator -avd <nombre_de_tu_avd>
    ```
---

## 4. Inicia el servidor Appium

Una vez que tu emulador esté listo, se debe iniciar el servidor Appium en una terminal separada. El comando varía ligeramente dependiendo de la versión de Appium que estés utilizando:

* Si usas **Appium 1.x**:
    ```bash
    appium
    ```
* Si usas **Appium 2.x**:
    ```bash
    appium server
    ```
Asegúrate de que el servidor Appium esté corriendo antes de proceder con la ejecución de la prueba.

---

## 5. Ejecuta la prueba

Una vez que hayas configurado tu entorno y tengas el emulador Android y el servidor Appium en marcha, puedes ejecutar la prueba.

* **Desde IntelliJ IDEA:** Debes encontrar y establecer el test `LoginLogoutRunner` y ejecutarlo directamente haciendo clic en el botón de "play" que aparece junto a su nombre.

---

## 6. Logs de ejecución

Los logs detallados de la ejecución de la prueba se guardan en:
  ```bash
    logs/test-execution.log
  ```
Además, estos logs también se mostrarán directamente en la consola durante la ejecución.

## 🧩 Decisiones de Diseño Arquitectónico

El framework propuesto se basa en una **arquitectura en capas** combinada con el patrón **Screenplay**, permitiendo una **separación clara de responsabilidades**, **modularidad** y **reutilización de código**. 

Se organiza en carpetas como `tasks`, `questions` y `userinterfaces` (con soporte multiplataforma), facilitando la **escalabilidad**.

Además, se aplica el **patrón Factory** mediante una clase `DriverFactory` que, junto con `ConfigReader`, permite **configurar dinámicamente el entorno** (Android o iOS) sin modificar el código.

Esta estructura promueve **claridad**, **mantenimiento sencillo** y **extensibilidad** para futuras pruebas.

🎥 [Ver video de demostración](https://drive.google.com/file/d/1E5B7l405t6ptStLadJcs2XCsn6NblEec/view?usp=sharing)

