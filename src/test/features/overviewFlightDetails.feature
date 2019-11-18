Feature: As a flight booker I want to see trip details

  @req1 @positive
  Scenario: open search results and review details
    Given aviasales search results page opened via REST API call
    And I should see aviasales search results
    When I click on the trip
    Then I should see trip details
    And I should see a price of the trip
    And I should see a way to book my trip
