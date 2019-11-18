Feature: As a flight booker I want to change my search filters to see changes in the search results

  #Background: search results page opened
  #  Given main aviasales page opened
  #  When I select "Lax" origin airport
  #  And I select "MOS" destination airport
  #  And I select depart date as a current date
  #  And I select return date as a first day of the next month
  #  And I select 1 adult passenger
  #  And I select 0 children passenger
  #  And I select 0 infant passenger
  #  And I no hotels search
  #  And I click on the Search button
  #  Then I should see aviasales search results
  #  changed to REST

  @req1 @positive
  Scenario Outline: results page - search for a round trip ticket with all data filled and no hotels required
    Given aviasales search results page opened via REST API call
    And I should see aviasales search results
    When I select <origin> origin airport
    And I select <destination> destination airport
    And I select depart date as a current date
    And I select return date as a first day of the next month
    And I select <adults> adult passenger
    And I select <children> children passenger
    And I select <infants> infant passenger
    And I click on the Search button
    Then I should see aviasales search results
    Examples:
      | origin | destination |  adults | children | infants |
      | LAX    | MOS         |  2      | 3        | 2       |
      | Los Ang| Moscow      |  1      | 0        | 0       |
