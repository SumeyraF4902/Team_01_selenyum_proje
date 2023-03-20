  #1- Kullanici URL'e gider
  #2-Kullanici login butonuna tıklar.
  #3-Kullanici '@' ve '.' işaretlerini içeren bir e-mail girer.
  #4-Kullanici e-mail adresinin '@' ve '.' işaretlerini içerdiğini kontrol eder.
  #5-Kullanici password butonuna tıklar.
  #8-Kullanici password girer
  #6-Kullanici sing in butonuna tıklar.
  #7-Kullanici siteye giriş yaptığını profil butonundan doğrular.
  #8-Kullanici sol kenar çubuğunu ve işlevselliğini doğrular.
  #9-Kullanici sol üst köşede bulunan logoya tıklar.
  #10-Kullanici ana sayfada olduğunu doğrular.

    Feature: Verified Logo and Hamburger menu

      Background:  Kullanici URL'e gider ve Kullanici login butonuna tıklar.Gerekli bilgileri girip login olur.
        @SecondHooks
        Scenario: logo ve hamburger doğrulama
        Then : Siteye giriş yaptığını doğrular
        When : Logoya tıkladığında
        Then :Logonun işlevini kontrol eder
        When :Hamburger menüye tıkladığında
        And : Hamburger'in işlevini doğrular
        When :Hamburger menüye tıkladığında
        And : Hamburger'in kapandığını doğrular