Feature: Catergoria Comics
  Como usuario quiero leer comics de testers para reirme y pasar un buen rato

  Scenario: Ingresar a la categoria comics desde el homepage
    Given El usuario se encuentra en el homepage de la pagina imlittletester
    When Hace click sobre el boton The Little Tester comics
    Then  Debe redirigir a la pantalla Comicsa