Feature: Registro de cuenta
  Como usuario quiero poder crearme una cuenta

  Scenario: Registrar cuenta
    Given El usuario debe estar en la parte de registro de Retro Games
    When Llenar formulario
    Then Debe derigir a mi perfil