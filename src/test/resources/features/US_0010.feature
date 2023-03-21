Feature: US_0010 Remote Units Modulu Goruntuleme Testi

    Scenario: TC_0001 Kullanıcı Remote Units modulundeki kayitli birimleri goruntuleyebilmeli
      Given Kullanici Account Management sayfasindadir
      When Kullanici Remote Units butonuna tiklar
      Then Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular