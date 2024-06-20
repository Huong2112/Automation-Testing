Feature: Verify Rawal application
    @TC_04 @SmokeTest
    Scenario Outline: Verify Search Screen
      Given Open RAWAL application
      When I click to What are you looking for?
      And Input "<productName>"
      Then The search page will display <numberOfProducts> product
      Examples:
      | productName | numberOfProducts|
      | product 20  | 2               |


