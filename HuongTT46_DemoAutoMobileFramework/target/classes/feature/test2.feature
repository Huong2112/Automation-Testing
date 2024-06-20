Feature: Verify Rawal and Test Function

    @TC_01 @SmokeTest
    Scenario Outline: Verify Dashboard
      Given Open Wallet application
      When  Input "<email>" & "<password>"
      And click to login
      Then The Dashboard display: Deposits and WithDrawals tab
      And In Deposits tab display Deposit to Us Dollar with Amount = 55.00 USD
      Examples:
        | email | password|
        | demouser@demouser.com  | 123456 |
