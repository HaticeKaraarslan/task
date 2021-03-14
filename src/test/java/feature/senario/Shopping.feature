@ShoppingTest
Feature: Shopping Feature
  Scenario: Kullanici sepetine ürün ekleyip , cikarma senaryosu
    Given kullanici sisteme basariyla giris yapmistir
    When arama kismina döner yazar
    And gelen döner combobox ina tiklar
    And arama islemi döner kategorisine göre oldugu control edilir
    And kullanici gelen arama sayfasinda döner tiklar
    And kullanici yemek sepetine ekler
    And kullanici sepetini bosaltir
    Then sepetin bosaltildigi kontrol edilir

