Feature: Create a Registration

  @wip
  Scenario: Create pet and verify status code is 201
    Given I logged Purrfect api using
    When I send POST request endpoint
    Then I verify the status code is 201