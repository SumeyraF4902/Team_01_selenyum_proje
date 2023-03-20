Feature: US014 Teams Modulu Degisiklik Testi


  Background: Kullanici her senaryodan once Edit Team sayfasina gelir
    When Kullanici Teams butonuna tiklar
    And Kullanici ilk secilebilen takima tiklar
    And Kullanici sayfada sag ustte bulunan Edit Team butonuna tiklar

  @FirstHooks
  Scenario: TC001 Kullanici Teams modulundeki takimlarin bilgilerinde degisiklik yapabilmeli
    When Kullanici cikan takim bilgilerinde degisiklik yapar
    And Kullanici sayfanin sag altinda bulunan Save butonuna tiklar
    Then Kullanici takim bilgilerinde degisiklik oldugunu dogrular

  @FirstHooks
  Scenario: TC002 Kullanici Teams modulundeki takimlari silebilmeli
    When Kullanici sayfada sol altta bulunan Delete Department butonuna tiklar
    And Kullanici sayfada ustte cikan Alert Mesajinda Tamam butonuna tiklar
    Then Kullanici sildigi takimin sayfada artik bulunmadigini dogrular