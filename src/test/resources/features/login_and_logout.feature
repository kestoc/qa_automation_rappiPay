Feature: Login y Logout en la aplicación móvil

  Scenario: El usuario inicia sesión y cierra sesión exitosamente
    Given que la aplicación está abierta
    When el usuario inicia sesión con usuario root y contraseña root
    Then la pantalla principal debe mostrarse correctamente
    And el usuario cierra sesión