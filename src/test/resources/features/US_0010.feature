Feature: US_0010 Remote Units Modulu Goruntuleme Testi

  @FirstHooks
  @Regression
    Scenario: TC_0001 Kullanıcı Remote Units modulundeki kayitli birimleri goruntuleyebilmeli
      When Kullanici Remote Units butonuna tiklar
      Then Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular