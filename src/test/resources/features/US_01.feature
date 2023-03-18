  #1- Kullanici URL'e gider
  #2-Kullanici login butonuna tıklar.
  #3-Kullanici '@' ve '.' işareti içeren bir e-mail girer.
  #4-Kullanici e-mail adresinin '@' ve '.' işareti içerdiğini kontrol eder.
  #5-Kullanıcı sign in butonuna tıklar
  #6.Kullanıcı sadece Please fill out this field yazısının geldiğini doğrular
   #7 Kullanıcı geçerli password bilgisini girer ve sign in olur
    #8- Kullanıcı siteye giriş yaptığını doğrular

  #---------------------------------------------------------
  #1-Kullanici URL'e gider
  #2-Kullanici login butonuna tıklar.
  #3-Kullanici '@' ve '.' işaretlerinden en az birini kullanmadan e-mail adresi girer.
  #5-Kullanıcı sign in butonuna tıklar
  #4-Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.

  #---------------------------------------------------------
   #1-Kullanici URL'e gider
  #2-Kullanici login butonuna tıklar.
  #3-Kullanici '@' ve '.' işaretlerini kullanmadan e- mail adresi girer.
      #4-Kullanıcı sign in butonuna tıklar
    #5-Kullanici "Not Authorized. Please try with valid credentials" uyarısını alır.
  #---------------------------------------------------------

  Feature: US_0001 Kullanıcı login credential check

    Background : Url to login page step
    Given :Kullanici url'ye gider.
    And :login butonuna tıklar.

      Scenario: TC_0001 valid credential
        When : Kullanici '@' ve '.' işareti içeren bir e-mail girer.
        Then : Kullanici e-mail adresinin '@' ve '.' işareti içerdiğini kontrol eder.
        And :Kullanici sign in butonuna tıklar.
        Then :Kullanıcı sadece Please fill out this field yazısının geldiğini doğrular.
        And :Kullanıcı geçerli password bilgisini girer ve sign in olur.
        Then :Kullanıcı siteye giriş yaptığını doğrular .

     Scenario: TC_0002 invalid credential
       When : Kullanici '@' ve '.' işaretlerinden en az birini kullanmadan e-mail adresi girer.
       And : Kullanıcı sign in butonuna tıklar
       Then : Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.

    Scenario: TC_0003 invalid credential
      When : Kullanici '@' ve '.' işaretlerini kullanmadan e-mail adresi girer.
      And : Kullanıcı sign in butonuna tıklar
      Then : Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.



























