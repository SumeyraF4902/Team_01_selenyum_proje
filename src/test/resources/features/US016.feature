Feature: US015 Kullanici modülü kullanici görüntüleme islemleri

  Background:
    Given : Kullanici login butanuna basar
    And : username ve password girişini gerçekleştirir
    And :Profil simgesine gider ve Account Manegement sekmesini acar
    And Kullanici Users modülündedir
    And Kullanici bilgilerini düzenlemek istedigi kullaniciyi secer

  Scenario: TC001 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Default Role silememelidir
    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    Then Kullanici bilgilerinde Default Role ün pasif durumda oldugunu dogrular

  Scenario: TC002 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Mail degistirememelidir
    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    Then Kullanici bilgilerinde Mail Adresinin pasif durumda oldugunu dogrular

  Scenario: TC003 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Username bos birakilamamalidir
    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    And Username kismini bos birakir
    Then Username in bos birakilamayacigina dair uyari görmelidir
    And Kullanici yaptigi islemi kayit altina alamamalidir

  Scenario: TC004 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Username rakam ile baslamamalidir
    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    And Username kismina rakam ile giris yapmaya baslar
    Then Username in kisminin rakam ile baslayamayacagina dair uyari görmelidir
    And Kullanici yaptigi islemi kayit altina alamamalidir

  Scenario: TC005 Kullanici Users Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Username özel karakter ile baslamamalidir

    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    And Username kismina ozel karakterler ile giris yapmaya baslar
    Then Username in kisminin ozel karakterler ile baslayamayacagina dair uyari görmelidir
    And Kullanici yaptigi islemi kayit altina alamamalidir

  Scenario: TC006 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Username i farkli bir isim girebilmelidir

    When Kullanici bilgilerini düzenlemek icin edit butonuna basar
    And Username kisminda gecerli bir username ekler
    And Kullanici yaptigi degisiklikleri kaydeder
    Then Kullanici yaptigi degisikligin gerceklestigine dair uyari mesaji görüntüler
    And Yeni kullaniciyi user modulde görüntüler

  Scenario: TC007 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde Reset Password ile sifreyi sifirlayabilmelidir.

    When Kullanici sifre resetleme icin reset Password butonuna tiklar
    Then Kullanici ekranda sifrenin basarili bir sekilde degisitirildigine dair mesaj görüntüler

  Scenario: TC008 Kullanici Users modülde kullanici bilgilerini düzenlemek istediginde yeni rol ekleyebilmelidir
    When Kullanici sectigi kullaniciya yeni bir rol atar
    Then Kullanici yeni rolun eklendigini dogrular

