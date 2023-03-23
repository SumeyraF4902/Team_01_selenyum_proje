Feature: US014 Teams Modulu Degisiklik Testi

  Background: Kullanici her senaryodan once Teams modulune gelir
    When Kullanici Teams butonuna tiklar
    And Kullanici ilk sıradaki takima tiklar
    And Kullanici sayfada sag ustte bulunan Edit Team butonuna tiklar
  @FirstHooks
  @Regression
  Scenario: TC001 Kullanici Teams modulundeki takimlarin bilgilerinde degisiklik yapabilmeli
    When Kullanici cıkan sayfadaki bosluklari doldurur ve Save butonuna tiklar
    Then Kullanici takim bilgilerinde degisiklik oldugunu dogrular
  @FirstHooks
  @Regression
  Scenario: TC002 Kullanici Teams modulundeki takimlari silebilmeli
    When Kullanici sayfada sol altta bulunan Delete Department butonuna tiklar
    And Kullanici sayfada ustte cikan Alert Mesajinda Tamam butonuna tiklar
    Then Kullanici sildigi takimin sayfada artik bulunmadigini dogrular