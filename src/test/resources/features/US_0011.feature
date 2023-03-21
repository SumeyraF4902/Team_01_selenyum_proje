Feature: US_0011 Remote Units Modulu Yeni Birim Ekleme Testi

  Background:
    Given Kullanici Account Management sayfasindadir
    When Kullanici Remote Units butonuna tiklar
    And Kullanici Add New Remote Unit' e tiklar.


  @FirstHooks
    Scenario: TC_0001 Kullanıcı Remote Units modulunde bulunan birimlere yeni birimler ekleyebilmeli
      And Kullanici çikan sayfada isim ve tur secer
      And Kullanici save butonuna tiklar
      Then Kullanici  ekledigi birimin Remote Units sayfasinda bulundugunu dogrular

  @FirstHooks
      Scenario: TC_0002 Kullanıcı Remote Units modülünde eklediği birimlerin bilgilerinde değişiklik yapabilmeli
        And  Kullanici ekledigi birimin isim ve type bilgilerinde degisiklik yapar
        And Kullanıcı Edit'e tiklar
        Then Kullanici ekledigi birimin bilgilerinde degisiklik oldugunu goruntuler