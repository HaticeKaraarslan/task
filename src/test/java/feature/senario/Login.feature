@LoginTest
Feature: Login Feature
  Scenario: Correct login test
    Given I am going to the login page
    When kadi ve sifre girilir
    And giris butonuna tiklanir
    Then anasayfanin geldigi görülür