Feature: US015 Kullanici modülü kullanici görüntüleme islemleri

  Background:
    Given : Kullanici login butanuna basar
    And : username ve password girişini gerçekleştirir
    And :Profil simgesine gider ve Account Manegement sekmesini acar
    And Kullanici Users modülündedir

  @Smoke
  Scenario: TC001 Kullanici Users modülünde en son ekledigi kullaniciyi görüntüler
    When Kullanici Yeni Kullanici ekler
    Then Kullanici yeni eklenenen Kullaniciyi Users Modülde görüntüler

  @Regression
  Scenario: TC002 Kullanici Users modülde maili onaylanmayan kullanicida Yesil Tick isareti görmemelidir
    When Kullanici Yeni Kullanici ekler
    Then Kullanici yeni eklennen Kullanicida Yesil Tick isareti görmez

  @Regression
  Scenario: TC003 Kullanici Users Modülde maili onaylanan kullanicida yesil tick  görebilmelidir
    When Kullanici Yeni Kullanici ekler
    And Kullanicinin girmis oldugu mail adresine onay icin mesaj gönderir
    And Kullanici mail adresini onaylar
    Then Kullanici yenin eklenen Kullanicida Yesil Tick isaretini görür
