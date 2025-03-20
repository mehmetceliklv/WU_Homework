@UI @PayBillsOnline @SmokeTest
Feature: Pay Bills Online

  Scenario: Change country and pay bills
    Given User navigates to "https://www.westernunion.com/"
    When  User expands the burger menu
    And   User selects the Settings page
    And   User changes WU.com Country to "United States"
    And   User verifies that page url is updated
    And   User selects PAY BILLS from burger menu
    And   User fills out the form with the following details
      | companyName     | amount | accountNumber | state    |
      | WESTERN UNION   | 100    | 111111111     | Colorado |
    And   User clicks Continue
    Then  User should see the confirmation page