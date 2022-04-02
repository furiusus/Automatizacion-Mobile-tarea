Feature: Facebook Seguridad
  #tag
  @Regression @SmokeTest
  Scenario: Login on Facebook
    #este es un comentario
    Given que tengo acceso a facebook app
    When yo ingreso mi usuario: "eynar"
    And ingreso mi password: 1233456
    And click en el boton ingresar
    Then deberia de ingresar a la app 1 vez
