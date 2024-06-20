Feature: Banggood application
  @TC_01
  Scenario Outline: Verify filter product
    Given Open Banggood Easy Online Shopping App
    When Click to the Category on footer menu
    And Scroll and click to Home and Garden in Left menu
    And After the right category displayed, click to the Home Decor
    And Click to the Filter and input price from "<min>" to "<max>"
    And Click Done
    And Click first product
    Then Verify product name should be displayed and product price in range "<min>" to "<max>"
    Examples:
    |min|max|
    |20 |30 |

  @TC_02
  Scenario: Verify cart and product detail screen
    Given Open Banggood Easy Online Shopping App Without change currency
    When At the Home screen, scroll to Hot Categories
    And Click to the first category
    And Click to the first product
    Then The product detail page should be displayed : Product name, product price, Buy now button and Add to Cart button.
    When Click Add to Cart
    And Click to Add to Cart button
    And Click to Cart icon on footer
    Then Verify product name, product size, product price and quantity should be displayed

  @TC_03
  Scenario: Verify Login Screen
    Given Open Banggood Easy Online Shopping App Without change currency
    When Click Account on footer menu
    And Click View All Order
    Then Verify the login screen should be displayed with: Email, password and SignIn button.