Feature: Facebook Seguridads

  Background:
    Given que tengo acceso a facebook app

  Scenario: Login on Facebooks completo

    When yo ingreso mi usuario: "eynar"
    And ingreso mi password: 1233456
    And click en el boton ingresar
    Then deberia de ingresar a la app 1 vez

  Scenario: Login on Facebooks sin pwd

    When yo ingreso mi usuario: "eynar"
    And click en el boton ingresar
    Then no deberia de ingresar a la app

  Scenario: Login on Facebooks sin usuario

    And ingreso mi password: 1233456
    And click en el boton ingresar
    Then no deberia de ingresar a la app