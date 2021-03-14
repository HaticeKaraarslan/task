@SearchTest
Feature: Search Feature
  Scenario: Kullanici giris yapar ve arama islemi gerceklestirir
    Given kullanici sisteme giris yapmistir
    When arama kismina börek yazar
    And gelen börek combobox ina tiklar
    Then arama islemi börek kategorisine göre oldugu control edilir
    When arama kisminda ödeme yöntemi nakit yazar
    And arama kisminda nakit radyo butonuna tiklanir
    Then arama islemi nakit yonteme göre oldugu control edilir
    When arama kismina cig kofte yazar
    And gelen cig kofte combobox ina tiklar
    Then arama islemi cig kofte kategorisine göre oldugu control edilir
