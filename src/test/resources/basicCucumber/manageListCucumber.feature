Feature: App Banco

  Scenario: Opciones Habilitadas

    Given que tengo acceso a BancoTest app
    When realizo el login
      | admin   |
      | p@ssw0d |
    Then ingreso a la aplicacion
    And las opciones habilitadas deberian ser
      | profile           |
      | cuentas           |
      | pago de servicios |
      | pago por QR       |
      | extractos         |
      | transferencias    |