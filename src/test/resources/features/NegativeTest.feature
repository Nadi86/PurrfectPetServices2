Feature: book categories


  Scenario: Verify user cannot submit the registration
    Given User on welcome page on registration page
    And User clicks on Register your pet button on registration page
    When User clicks on Make new pet registration button on registration page
    And user enters pet name on the registration page
    And user enters pet owner the registration page
    And user selects color the registration page
    And user selects age the registration page
    And user leaves blank description
    Then verify user cannot submit the registration

