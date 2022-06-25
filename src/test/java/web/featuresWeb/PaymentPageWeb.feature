@LCWaikiki
Feature: Web Payment Page

  @Web @PaymentPage
  Scenario: Check Payment Page
#    Given User Logged In
    When Hover to "KADIN" Button
    And Click to "Bluz" Button of "GİYİM" Category
    Then Check Blouse Results Label
    When Click to "Siyah" Button of "Renk" Category
    Then Check Black Filter Colour Label
    When Click to the First Product
    And Click to "M" Button of "Beden" Label
    And Click to "SEPETE EKLE" Button
    And Click to "Sepetim" Button
    Then Check "Title" Label of the Product
    And Check "Size" Label of the Product
    And Check Product Count
    And Check Order Summary Label
    And Check "Ürün Toplam" Label
    And Check Product Total Sum
    And Check "Ara Toplam" Label
    And Check Subtotal Sum
    And Check "Kargo Ücreti" Label
    And Check Shipment Fee Sum
    And Check "GENEL TOPLAM" Label
    And Check Grand Total Sum
    When Click to "ÖDEME ADIMINA GEÇ" Button
    Then Check "Ürün Toplam" Label Payment Page
    And Check Product Total Sum Payment Page
    And Check DiscountsLabel Payment Page
    And Check Discounts Payment Page
    And Check "Ara Toplam" Label Payment Page
    And Check Subtotal Sum Payment Page
    And Check "Kargo Ücreti" Label Payment Page
    And Check Shipment Fee Sum Payment Page
    And Check "GENEL TOPLAM" Label Payment Page
    And Check Grand Total Sum Payment Page
