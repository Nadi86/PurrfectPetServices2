Feature: Get all registrations


  Scenario: to get all registrations
    Given Status Code should be 200
    When I send a GET request to url
    Then status code must be 200

  Scenario: to get a Specific Registration
    Given endpoint retrieves a specific registration
    When I send a GET request
    Then status code must be 200 with endpoint