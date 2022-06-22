@LCWaikiki
Feature: Web Payment Page

  @Web @PaymentPage
  Scenario: Check Payment Page
    Given User Logged In
    When Hover to "KADIN" Button
    And Click to "Bluz" Button of "GİYİM" Category
    Then Check Blouse Results Label
    When Click to "Siyah" Button of "Renk" Category
    Then Check Black Filter Colour Label
    When Click to the First Product
    And Click to "M" Button of "Beden"
    And Click to "SEPETE EKLE" Button
    And Click to "Sepetim" Button
    Then Check "Title" Label of the Product
    And Check "Size" Label of the Product
    And Check Product Count
    And Check Order Summary Label
    And Check "Ürün Toplam" Label
    And Check Product Total Price
    And Check "Ara Toplam" Label
    And Check Subtotal Price
    And Check "Kargo Ücreti" Label
    And Check Shiptment Fee Price
    And Check "GENEL TOPLAM" Label
    And Check Grand Total Price
    When Click to "ÖDEME ADIMINA GEÇ" Button
#    Then Check Payment Page
