Feature: US013 Teams Modulu Goruntuleme Testi

  Background: Kullanici her senaryodan once Teams modulune gelir
    When Kullanici Teams butonuna tiklar
  @FirstHooks
  @Regression
  Scenario: TC001 Kullanici Teams modulunde bulunan takimlari liste halinde gorebilmeli
    Then Kullanici takimlari liste halinde sayfada gorundugunu dogrular
  @FirstHooks
  @Regression
  Scenario: TC002 Kullanici Teams modulundeki ilk takima tiklayarak takimi detayli olarak gorebilmeli
    When Kullanici ilk siradaki takima tiklar
    Then Kullanici tikladigi takimin bilgilerinin detayli olarak sayfada gorundugunu dogrular
  @FirstHooks
  @Regression
  Scenario: TC003 Kullanici Teams modulunde bulunan takimlara yeni takimlar ekleyebilmeli
    When Kullanici sayfada sag ustte bulunan Add New Team butonuna tiklar
    And Kullanici cıkan sayfadaki bosluklari doldurur.
    And Kullanici sayfada sag altta bulunan Save butonuna tiklar
    And Kullanici sayfada sol ortada bulunan Teams butonuna tekrar tiklar
    Then Kullanici ekledigi takimin Teams sayfasinda bulundugunu dogrular