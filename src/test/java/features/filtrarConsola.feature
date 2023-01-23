Feature: Filtrar por consola
  Como usuario solo quiero ver juegos de PLAYSTATION

  Scenario: Filtrar juegos
    Given El usuario debe estar ubicado en la pagina principal
    When Da click en PLAYSTATION
    Then Debe redirigir a juegos unicamente de PLAYSTATION