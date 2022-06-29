Feature:Update a Specific Registration

  @wip
  Scenario: Create pet and verify status code is 201
    Given I logged Purrfect api using for updating
    When I send PUT request endpoint
    Then I verify the status code is 200 after updating