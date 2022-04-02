Feature: Facebook Seguridad

  Scenario Outline: Login on Facebook

    Given que tengo acceso a <application> app
    When yo ingreso mi usuario: "<usuario>"
    And ingreso mi password: <password>
    And click en el boton ingresar
    Then deberia de ingresar a la app 1 vez

    Examples:
      | application | usuario  | password  |
      | facebook    | admin    | admin     |
      | whatsapp    | 12312312 | 123123123 |
      | messenger   | admin    | 123       |
      | gmail       | admin    | P@ssw0rd  |

