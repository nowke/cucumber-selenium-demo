Feature: Fieldset fill test
  Scenario Outline: Fill fieldsets with random values
    Given Navigate to PracticeForm for Fieldset
    And I fill "<textarea>" in textarea
    And I fill "<text>" in textbox
    And I check "<option>" in Checkbox
    And I check "<radio>" in RadioBox
    And I fill "<date>" in Date Field
    And I fill "<url>" in URL field
    And I select "<select>" in Select Option

    Examples:
      | textarea  | text  | option    | radio     | date        | url       | select   |
      | hello txt | txt   | Option 1  | Option 2  | 02/05/2016  | google.in | Option 2 |