Feature: Verify Rawal and Test Function

  @TC_01 @SmokeTest
  Scenario Outline: Verify Dashboard
    Given Open Wallet application
    When  Input "<email>" & "<password>"
    And click to login
    Then The Dashboard display: Deposits and WithDrawals tab
    And In Deposits tab display Deposit to Us Dollar with Amount = <amount> USD
    Examples:
      | email  | password|amount|
      | demouser@demouser.com  | 123456 |100.00|

  @TC_02 @SmokeTest
  Scenario Outline: Verify Add Virtual Cards screen
    Given Open Wallet application
    When  Input "<email>" & "<password>"
    And click to login
    And Click to icon Virtual Cards at footer menu
    And Click to Buy Card
    Then The Buy a New Virtual Card display Name textbox and Fund button
    Examples:
      | email  | password|
      | demouser@demouser.com  | 123456 |

  @TC_03 @SmokeTest
  Scenario Outline: Verify Request money screen
    Given Open Wallet application
    When  Input "<email>" & "<password>"
    And click to login
    And Click to menu left icon
    And Click to request
    Then The Request money display with Amount textbox, Email textbox, Request description and Send button
    Examples:
      | email  | password|
      | demouser@demouser.com  | 123456 |


  @TC_04 @SmokeTest
    Scenario Outline: Verify setting screen
    Given Open Wallet application
    When  Input "<email>" & "<password>"
    And click to login
    And Click to menu left icon
    And Click to Setting
    And  Scroll to Change Password
    Then Verify screen display textbox: Current password, New password, Repeat New Password
    Examples:
      | email  | password|
      | demouser@demouser.com  | 123456 |

   @TC_05 @SmokeTest
     Scenario Outline: Verify error message in Add Virtual Cards screen
     Given Open Wallet application
     When  Input "<email>" & "<password>"
     And click to login
     And Click to icon Virtual Cards at footer menu
     And Click to Buy Card
     And Input "<nameOnCard>" and click to the Fund button
     And Add USD amount: <amount> and click next icon
     Then The screen display error message: "<message>"
     Examples:
       | email  | password| nameOnCard | amount| message|
       | demouser@demouser.com  | 123456 | Chip | 10 |Error\nInsufficient  Balance !!|