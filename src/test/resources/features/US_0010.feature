Feature: US_0010 Remote Units Modulu Goruntuleme Testi

  Background: Kullanici her senaryodan once Remote Units e gelir
    When Kullanici Remote Units butonuna tiklar

    Scenario: TC_0001 Kullanıcı Remote Units modulundeki kayitli birimleri goruntuleyebilmeli
      Then Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular