Feature: Medicine Marketplace


  Background: Kullanici her senaryosunda Account Management sayfasinda roller bolumunde olacaktir
    Given Kullanici  roller bolumune tiklar

  @FirstHooks
  Scenario: Roller modulunde kayıtlı tum rolleri goruntuler
    Then  Kullanici roller bolumundeki rolleri gorur ve rolleri listeler

  @FirstHooks
 Scenario: Roller modulunde kayitli rollerin ayricaliklarini goruntuler
   When Kullanici herbir rolu tiklar ve tiklanir oldugunu kontrol eder


  @FirstHooks
    Scenario:  İzinler modulundeki tum izinleri goruntuler.
      Then    Kullanici roller bolumundeki rolleri tikladiğinda her birinin Permissions gorur