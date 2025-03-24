@UI @OpenAgentLocations @SmokeTest
Feature: Open Agent Locations Tool

  Scenario: Open Agent Locations Tool
    Given User navigates to "https://www.westernunion.com/"
    When  User expands the burger menu
    Then  User selects Find Location option
    And   User validates that page is redirected to Find Locations page
    And   User clicks on Agent and fills Agent Name,Postal Code and City "TestAgent" "08247" "Vilnius"
    And   User clicks on Open and get list of open agents below
    And   User prints the first open agent details on the list
