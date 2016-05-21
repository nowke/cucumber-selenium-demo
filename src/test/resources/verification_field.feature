Feature: Verification Field test
  Scenario Outline: Test for Verification Field - Enter two digit number
    Given Navigate to PracticeForm
    And I fill two digit number "<number>" in verification field
    And I hit submit button
    Then I get form success message

    Examples:
      | number |
      | 12     |
      | 20     |