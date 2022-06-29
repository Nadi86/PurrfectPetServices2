Feature: book categories


  Scenario: Verify new pet registration
    Given User on welcome page
    And User clicks on Register your pet button
    When User clicks on Make new pet registration button
    And user enters pet name
    And user enters pet owner
    And user selects color
    And user selects age
    And user enters description
    And user clicks species
    And user selects vaccination status
    And user selects purrfect Membership
    And user clicks service needed
    Then verify user registered the pet

