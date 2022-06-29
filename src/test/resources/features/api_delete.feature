Feature: Delete a Specific Registration

  @wip
  Scenario: Delete pet and verify status code is 201
    Given I logged Purrfect api using a Specific Registration
    When I send Delete request
    Then I verify the status code is 204 a Specific Registration