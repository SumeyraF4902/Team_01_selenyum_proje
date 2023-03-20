Feature: US_0010 Remote Units Modulu Yeni Birim Ekleme Testi

  Background:
    Given Kullanici Account Management sayfasindadir
    When Kullanici Remote Units butonuna tiklar
    Then Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular

    Scenario: TC_0001 Kullanıcı Remote Units modulunde bulunan birimlere yeni birimler ekleyebilmeli
      When Kullanici Add a New Remote Unit' e tiklar.
      And Kullanici çikan sayfada isim ve tur secer
      And Kullanici save butonuna tiklar
      Then Kullanici  ekledigi birimin Remote Units sayfasinda bulundugunu dogrular

      Scenario: TC_0002 Kullanıcı Remote Units modülünde eklediği birimlerin bilgilerinde değişiklik yapabilmeli
        When  Kullanici istedigi birimin isim ve type bilgilerinde degisiklik yapar
        And Kullanıcı Edit Remote Unit'e tiklar
        Then Kullanici istedigi birimin bilgilerinde degisiklik oldugunu goruntuler