Feature: Contact Form Test
  Scenario Outline: Submit form with all fields
    Given Navigate to PracticeForm for Contact
    And I fill "<name>" "<email>" "<phone>" "<country>" "<company>" "<message>" in Contact Form
    And I hit contact submit button
    Then I get acknowledgement message

    Examples:
      | name      | email          | phone      | country | company | message   |
      | John Snow | jsnow@got.com  | +1 878787  | USA     | GOT     | I'm alive |
      | Nowke     | me@nowke.in    | +91 818181 | IN      | Student | adieu :D  |

  Scenario: Submit empty form
    Given Navigate to PracticeForm for Contact
    And I hit contact submit button
    Then I get errors for required fields

  Scenario Outline: Submit form with only mandatory fields
    Given Navigate to PracticeForm for Contact
    And I fill "<name>" "<email>" "<phone>" "<country>" "<company>" "<message>" in Contact Form
    And I hit contact submit button
    Then I get acknowledgement message

    Examples:
      | name      | email          | phone      | country | company | message |
      | John Snow | jsnow@got.com  | +1 878787  |         |         |         |
      | Nowke     | me@nowke.in    | +91 818181 |         |         |         |