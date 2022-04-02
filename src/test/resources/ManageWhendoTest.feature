Feature: Test Whendo
  Scenario: Create task
    Given abro el aplicativo Whendo
    And presiono la opcion para agregar tarea
    And presiono mas opciones para tarea
    And Agrego los siguientes datos a la tarea
       | Duedate       | time  | title          | notes                     |
       | 18 april 2022 | 9     |Realizar tarea  | Organizar y realizar tarea|
    When guardo la tarea
    Then valido los siguientes datos
      | title          | notes                      |
      | Realizar tarea | Organizar y realizar tarea |