Feature: Buscar sitio web Retro Games
  Como usuario quiero poder buscar de forma sencilla el sitio web
  para poder jugar mis juegos antiguos favoritos

  Scenario: Buscar sitio en google
    Given El usuario se encuentra en el buscador google
    When Ingresa el nombre de retrogames.cc en el buscador
    And Le da click en boton Buscar en Google
    And Le da click en la primera pagina sugerida por google
    Then Debe redirigir a la pagina de inicio de Retro Games