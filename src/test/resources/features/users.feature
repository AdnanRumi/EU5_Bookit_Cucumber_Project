Feature: User Verification
  @wip
  Scenario: Verify information about logged user
    Given the user logged Bookit api using "sbirdbj@fc2.com" and "asenorval"
    When the user gets the current user information from api
    Then status code should be 200