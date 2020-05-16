Feature: SFC-69 related test cases. Link to story: https://crowncommercialservice.atlassian.net/browse/SFC-69

  @Test @SFC-65 @SFC-118
  Scenario Outline: As a buyer I want to be given a CTA button to return to the search result page
    Given user logs in to the CCS application for "<ScenarioID>"
    And User is navigated to CCS home page
    And User enters "<framework>" details
    And User clicks on the "Help me find the right framework" button
    And User is displayed with GM landing page
    And User clicks "Search Frameworks" CTA from the page
    Then User should be redirected to Search Framework page

    Examples:
      | ScenarioID | framework |
      | Scenario 1 | Linen     |