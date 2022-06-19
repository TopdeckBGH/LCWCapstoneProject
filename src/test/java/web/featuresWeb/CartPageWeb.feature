@LCWaikiki
Feature: Payment Page

  @Web @PaymentPage
  Scenario: Check Payment Page
    Given User Logged In
    When Hover to "KADIN" Button
    And Click to "Bluz" Button of "GİYİM" Category
    And Click to "Siyah" Button of "Renk" Category
    And Click to the First Product
    And Click to "M" Button of "Beden"
    And Click to "SEPETE EKLE" Button
    And Click to "Sepetim" Button
    Then Check "Title" Label of the Product
    And Check "Code" Label of the Product
    And Check "Size" Label of the Product
    And Check "Colour" Label of the Product
    When Click to "ÖDEME ADIMINA GEÇ" Button
    Then Check Payment Page
