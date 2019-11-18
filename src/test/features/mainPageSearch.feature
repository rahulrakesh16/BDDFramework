Feature: As a flight booker I want to find available flight based on
  my criteria so that will allow me to plan my trip

  @req1 @positive
  Scenario Outline: search for a round trip ticket with all data filled and no hotels required
    Given main aviasales page opened
    When I select <origin> origin airport
    And I select <destination> destination airport
    And I select depart date as a current date
    And I select return date as a first day of the next month
    And I select <adults> adult passenger
    And I select <children> children passenger
    And I select <infants> infant passenger
    And I select <search for hotels> hotels search
    And I click on the Search button
    Then I should see aviasales search results
    Examples:
    | origin | destination |  adults | children | infants | search for hotels |
    | LAX    | MOS         |  2      | 3        | 2       | no                |
    | Los Ang| Moscow      |  1      | 0        | 0       | no                |

  @req1 @negative
  Scenario: user could not do a search with empty arrival date
    Given main aviasales page opened
    When I delete depart date
    And I click on the Search button
    Then I should see an error message

  @req1 @negative
  Scenario: user could not do a search with empty departure date
    Given main aviasales page opened
    When I delete return date
    And I click on the Search button
    Then I should see an error message
