Feature: Verify eCart Multivendor Customer
  @TC_01
  Scenario Outline: Verify Home screen
    Given Open eCart App
    Then welcome screen with some fields displayed:Skip button, Next button, "<text>"
    Examples:
    |text|
    |Look for things around you|

  @TC_02
  Scenario Outline: Verify Category screen
    Given Open eCart App
    When Click to next -> next -> Get Started
    Then The Default Delivery Location screen display some items: Search Pin textbox, Search Button, Location display: "<first>", "<second>", "<third>", "<fourth>", "<fifth>", "<sixth>"
    When Select "<location>" location
    And Click to Category menu item
    Then The Category screen display 6 categories: "<Coffee Product>", "<Fast Food>", "<Home Supplies>", "<Beverages>", "<Baby Need’s>", "<Vegetables>"
    Examples:
    |first|second|third|fourth|fifth|sixth|Coffee Product|Fast Food|Home Supplies|Beverages|Baby Need’s|Vegetables|location|
    |All  |370405|841301|800001|370465|370001|Coffee Product|Fast Food|Home Supplies, Utilities & Stationery|Beverages|Baby Need's|Vegetables|All|

  @TC_03
  Scenario Outline: Verify number of product of Fresh Vegetables
    Given Open eCart App
    When Click to next -> next -> Get Started
    And Select "<location>" location
    And Scroll to Fresh Vegetables
    Then The Fresh Vegetables category should be displayed 3 products
    When Click to View All in Vegetable
    Then Fresh Vegetables screen should be displayed 10 products
    Examples:
    |location|
    |All     |

  @TC_04
    Scenario Outline: Verify Product Detail screen
      Given Open eCart App
      When Click to next -> next -> Get Started
      And Select "<location>" location
      And Scroll to Coffee
      And Click to View All in Coffee
      And Click to "<productName>"
      Then The product detail screen should be displayed: "<productName>", "<productPrice>", Add to Cart button, Go to Cart button, Similar Products text
      Examples:
      |productName|productPrice|location|
      |High Octane Instant Coffee Paste with Hazelnut and Coconut Flavors, 150G - Pack of 2 (Hazelnut and Coconut Beaten Coffee Paste)|$718,31|All|

  @TC_05
    Scenario Outline: Verify Cart screen
      Given Open eCart App
      When Click to next -> next -> Get Started
      And Select "<locationAll>" location
      And Click to Category menu item
      And Click to Fast Food
      And Click Add to Cart with Quantity = 2 of "<productName>" product 1
      And Click to Cart icon on top screen
      And Select "<location>" location
      Then The Cart should be display: "<productName>", "<productPrice>", "<productMeasurement>", "<productTotalPrice>", "<quantity>", Delete Button,Save for later button,Use Promo Code button, CONTINUE button
      Examples:
      |productName|quantity|productPrice|productMeasurement|productTotalPrice|location|locationAll|
      |Veganic Sabudana Coin Papad Plain|2|$189,00|400 gm|$378,00 |370405             |All     |

  @TC_06
    Scenario Outline: Verify Payment screen
      Given Open eCart App
      When Click to next -> next -> Get Started
      And Select "<locationAll>" location
      And Click to Category menu item
      And Click to Beverages
      And Click Add to Cart with Quantity = <quantity> of "<productName>" product
      And Click to Cart icon on top screen
      And Select "<location>" location
      And Click to CONTINUE button
      And Click to login button
      And Click to CONTINUE button
      And Select default address and click CONTINUE
      Then The Payment screen should be display: Shipping detail with Pin Code: "<code>", Preferred Delivery: Date, time, "<grandTotal>"
      And Order Summary should be display correct information: "<productName1>", "<totalPrice>", "<subtotal>", "<deliveryCharge>", "<youSaved>" and Grand Total.
      Examples:
      |productName|quantity|code|grandTotal|totalPrice|subtotal|deliveryCharge|youSaved|location|locationAll|productName1|
      |Sunfeast Dark Fantasy Choco Fills, 600g|2|370001|$414,20|$414,20|$414,20|$0,00|$109.0|370001|All     |Sunfeast Dark Fantasy Choco Fills, 600g (1 Pack)|

  @TC_07
    Scenario Outline: Verify Profile screen
    Given Open eCart App
    When Click to next -> next -> Get Started
    And Select "<location>" location
    And Click to Profile on footer menu
    And Click to Welcome Guest
    Then The login screen should be displayed:Mobile textbox, Password textbox,Login button, Forgot password?,Sign up button
    When Click to login button
    And Select "<location>" location
    And Click again to Profile on footer menu
    Then The profile screen should be displayed:Home, Cart, Notifications, Your Orders, Wallet History, Transaction History, Change Password
    Examples:
    |location|
    |All|







