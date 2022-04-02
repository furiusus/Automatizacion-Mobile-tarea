Feature: Facebook
  @Regression
  Scenario: Register

    Given que tengo acceso a facebook app
    When yo me registro
      | name  | lastname | phone   | address    | language | email           |
      | eynar | eynar    | 1234567 | av america | ingles   | eynar@eynar.com |
    Then la nueva cuenta deberia habilitarse