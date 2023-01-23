Feature: Ingresar con cuenta registrada
  Como usuario quiero ingresar con mi cuenta creada

  Scenario: Ingreso login
    Given El usuario debe estar en la pagina de login
    When Ingreso de credenciales
    Then Debe aparecer el nombre de usuario en la parte superior de la pantalla