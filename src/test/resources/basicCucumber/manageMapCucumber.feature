Feature: App Banco

  Scenario: Opciones Habilitadas

    Given que tengo acceso a BancoTest app
    When realizo el login con
      | usuario  | admin   |
      | password | p@ssw0d |
    Then ingreso a la aplicacion
    And las opciones habilitadas son
      | primera opcion | profile           |
      | segunda opcion | cuentas           |
      | tercera opcion | pago de servicios |
      | cuarta opcion  | pago por QR       |
      | quinta opcion  | extractos         |
      | sexta opcion   | transferencias    |