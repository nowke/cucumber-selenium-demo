Feature: Verification Field test
  Scenario Outline: Enter two digit number
    Given Navigate to PracticeForm
    And I fill two digit number "<number>" in verification field
    And I hit submit button
    Then I get form success message

    Examples:
      | number |
      | 12     |
      | 20     |

  Scenario Outline: Enter single digit number
    Given Navigate to PracticeForm
    And I fill single digit number "<single_digit>" in verification field
    And I hit submit button
    Then I get at least 2 character required error message

    Examples:
      | single_digit |
      | 1            |
      | 9            |

  Scenario: Leave blank field
    Given Navigate to PracticeForm
    And I hit submit button
    Then I get field required error message

  Scenario Outline: Enter more than two digits
    Given Navigate to PracticeForm
    And I fill multiple digit number "<multiple_digit>" in verification field
    And I hit submit button
    Then I get no more than two characters error message

    Examples:
      | multiple_digit |
      | 123            |
      | 34456          |

  Scenario Outline: Enter non-digit characters
    Given Navigate to PracticeForm
    And I fill non-digit "<character>" in verification field
    And I hit submit button
    Then I get digits only error message

    Examples:
      | character |
      | 1a45      |
      | invalid   |