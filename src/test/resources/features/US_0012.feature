Feature: US_0010 Remote Units Modulu Duzenleme ve Silme Testi

  Background:
    Given Kullanici Account Management sayfasindadir
    When Kullanici Remote Units butonuna tiklar
    Then Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular

    @FirstHooks
    Scenario: TC_0001 Kullanici Remote Units modulunde bulunan birimlerin bilgilerini duzenleyebilmeli
      When Kullanici ilgili duzenlemeleri yapar
      And Kullanici save butonuna tiklar
      Then Kullanici duzenleme yaptigini sayfada dogrular

      @FirstHooks
      Scenario: TC_0002 Kullanıcı Remote Units modulunde bulunan birimleri silebilmeli
        When Kullanıcı Delete  Department butonuna tiklar
        And Kullanıcı cikan uyarida Tamam butonuna tiklar
        Then Kullanici sildigi birimin sayfada olmadigini dogrular