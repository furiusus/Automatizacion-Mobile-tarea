Feature: Contact
  Scenario: create contact

    Given mi contact manager esta abierto
    When yo registro un nuevo contacto
      |name | aaaaremove|
      |phone| 7987897   |
    Then el contacto "aaaaremove" deberia ser creado