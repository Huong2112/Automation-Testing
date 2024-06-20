Feature: Tiki application
  @TC_01
  Scenario: Exercise 1 Verify product detail
    Given Open TIKI App
    When Click Danh Muc San Pham
    And Scroll and Click Laptop – May Vi Tinh at Right category
    And Click to Hàng mới
    And Click to first product
    Then Verify the product name, product price should be displayed

   @TC_02
   Scenario: Exercise 2 Verify product detail
     Given Open TIKI App
     When Click Danh Muc San Pham
     And Click Điện thoại – Máy tính bảng at Right category
     And Click to the “Lọc” button
     And Scroll to Thương hiệu
     And Select Samsung
     And Click to Áp Dụng button
     And Click to first product
     Then Verify the product name, product price should be displayed
