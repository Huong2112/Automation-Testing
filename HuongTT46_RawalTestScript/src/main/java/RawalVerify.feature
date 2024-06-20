Feature: Verify Screen
  Scenario: Verify category screen
    Given Open RAWAL application successfully
    When Click to the categories
    Then The category screen display 3 item: Men, Women and Kid

  Scenario: Verify My account screen
    Given Open RAWAL application successfully
    When Click to the My Account
    Then The My Account screen display: My order: Inprogress, Delivered and Reviews
    And Help & Info: Address, Profile, Rewards, Feedback, Share and Rate Us

  Scenario: Verify Cart screen
    Given Open RAWAL application successfully
    When Click to Cart icon on top
    Then The login screen display: 2 tab (Sign In and Sign Up)
    And Sign In: email textbox, password textbox, Sign In button
    And Sign Up: First Name, LastName, Email, Password, Confirm Password and Sign Up button

  Scenario:  Verify Search Screen
    Given Open RAWAL application successfully
    When Click to "What are you looking for?"
    And  Input "product 20"
      |Input|product 20|
    Then The search page will be display 2 products(Simple Product 20 and Variable 20)
      |Result|Simple Product 20|Variable 20|

  Scenario: Verify Sign Up successfully
    Given Open RAWAL application successfully
    When Click to the My Account
    And Click to the Welcome Pls Login
    And Click to the Sign Up
    And Input information and click to Sign Up
      |FirstName|Tran|
      |LastName|Huong|
      |Email|huongtt@gmail.com|
      |Password|123456|
      |Confirm|123456|
    And click to Sign Up
    Then The sceen go back to the My account and display "Welcome <FirstName>"

  Scenario: Verify address information screen
    Given Open RAWAL application successfully
    When Click to the My Account
    And Click to the Welcome Pls Login
    And Click to the Sign in with valid account
      |Email|huongtt@gmail.com|
      |Password|123456|
    And Click to Home Icon
    And Click to "What are you looking for?"
    And Input "Simple Product 20"
      |Input|Simple product 20|
    And Click to product
    And Click to Add to Cart button
    And Click Back icon
    And Click to Cart Icon
    Then The Cart screen should be display product name is "Simple Product 20" and Order Total is "822$"
      |ProductName|Simple Product 20|
      |OrderTotal |822$             |
    When Click to the Proceed to Checkout
    And Click to Add a new Address
    Then The address information screen should be display : FirstName, LastName, Counttry, Pick Location, Address, Phone , Post Code and Save & continue