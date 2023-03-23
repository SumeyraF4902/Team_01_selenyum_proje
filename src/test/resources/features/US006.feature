Feature: Kullanıcı şirket bilgilerini güncelleyebilir

  Background:
    Given : Kullanici login butanuna basar
    And : username ve password girişini gerçekleştirir
    And :Profil simgesine gider ve Account Manegement sekmesini acar


  Scenario: TC01 Kullanıcı şirket bilgilerini görüntüleyebilmeli
    Given kullanici acilan sidebardan company sekmesini tiklar
    Then kullanici company information verilerini goruntuler

  Scenario: TC02 Kullanıcı şirket bilgilerini bos birakip save edememeli
    Given kullanici acilan sidebardan company sekmesini tiklar
    And kullanici edit butonuna tiklar
    And kullanici name ve email textbox'larini siler
    And kullanici save butonuna tiklar
    Then kullanici bos name ve email textbox'in save olmadigini gorur

  Scenario: TC03 Kullanıcı şirket bilgilerini görüntüleyebilmeli
    Given kullanici acilan sidebardan company sekmesini tiklar
    And kullanici edit butonuna tiklar
    And kullanici name ve email textbox'larini degistirir
    And kullanici save butonuna tiklar
    Then kullanici bos name ve email textbox'in degistigini gorur