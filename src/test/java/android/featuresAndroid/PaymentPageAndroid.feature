@LCWaikiki
Feature: Android Payment Page

  @Android @PaymentPage
  Scenario: Check Payment Page
    Given User Logged In Android App
    When Tap on "Kategoriler" Button
    Then Check Categories Page
    When Tap on "Giyim" Button
    And Tap on "Bluz" Button
    Then Check Blouse Products Page
    When Tap on "Filtre" Button
    Then Check Filter Page
    When Tap on "Renk" Button
    Then Check Colour Filter Page
    When Tap on "Siyah" Button
    And Tap on "UYGULA" Button
    And Tap on "SONUÇLARI LİSTELE" Button
    And Tap on on the First Product
    And Tap on the Up Arrow Button
    And Tap on "M" Button of Beden Label
    Then Check Item Name
    And Check Item Price
    When Tap on "SEPETE EKLE" Button
    And Tap on "Sepete Git" Button
    Then Check Cart Page
    Then Check Product Name Android
    And Check Product Code Android
    And Check Product Size Label Android
    And Check Product Size Android
    And Check Product Colour Label Android
    And Check Product Colour Android
    And Check Item Count Label Android
    And Check Item Count Android
    And Check Product Item Price Android
    And Check "Sipariş Özeti" Label
    When Tap on the Options Button
    Then Check "Ürün Toplam" Label Android
    And Check Product Total Sum Android
    And Check "Ara Toplam" Label Android
    And Check Subtotal Sum Android
    And Check "Kargo Ücreti" Label Android
    And Check "GENEL TOPLAM" Label Android
    And Check Grand Total Sum Android
    When Tap on "ÖDEME ADIMINA GEÇ" Button
    Then Check Payment Page
    When Tap on the Up Arrow Button Payment Page
    Then Check "Ürün Toplam" Label Payment Page Android
    And Check Product Total Sum Payment Page Android
    And Check "Ara Toplam" Label Payment Page Android
    And Check Subtotal Sum Payment Page Android
    And Check "Kargo Ücreti" Label Payment Page Android
    And Check Shipment Fee Sum Payment Page Android
    And Check "GENEL TOPLAM" Label Payment Page Android
    And Check Grand Total Sum Payment Page Android




