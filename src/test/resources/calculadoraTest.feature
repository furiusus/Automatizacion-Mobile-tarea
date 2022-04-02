Feature: Calculadora
  Scenario: Suma

    Given que mi aplicacion calculadora esta abierto
    When presiono el boton 8
    And presiono el boton suma
    And presiono el boton 1
    And presiono el boton igual
    Then la suma deberia ser 9