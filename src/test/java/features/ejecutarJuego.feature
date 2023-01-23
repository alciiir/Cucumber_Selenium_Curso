Feature:  Ejecutar juego en Retro Games
  Como usuario quiero poder buscar y jugar mi juego favorito de toda la vida

  Scenario: Ejecutar juego
    Given El usuario debe estar ubicado en la pagina principal de Retro Games
    When El usuario debe Buscar el juego
    And El usuario debe poder abrir el juego
    Then El juego debe ejecutarse

