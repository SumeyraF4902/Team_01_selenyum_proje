  #Kullanici URL'e gider
  #Kullanici login butonuna tıklar.
  #Kullanici '@' ve '.' işareti içeren geçerli bir e-mail ve geçerli password girer.
  #Kullanici e-mail adresinin '@' ve '.' işareti içerdiğini kontrol eder.
  #Kullanici sign in butonuna tıklar.
  #Kullanıcı siteye giriş yaptığını doğrular .

  #---------------------------------------------------------
  #Kullanici URL'e gider
  #Kullanici login butonuna tıklar.
  #Kullanici credential'a uymayan e-mail adresi girer.
  #Kullanıcı sign in butonuna tıklar
  #Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.

  #---------------------------------------------------------
    #Kullanici URL'e gider
    #Kullanici login butonuna tıklar.
    #Kullanici crendential içermeyen e-mail adresi girer.
    #Kullanıcı sign in butonuna tıklar
    #Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.
  #---------------------------------------------------------

  Feature: US_0001 Kullanıcı login credential check

    Background : Kullanici url'ye gider.ve login butonuna tıklar.

    @ThirdHooks
    @Smoke
    Scenario: TC_0001 valid credential
      When : Kullanici '@' ve '.' işareti içeren geçerli bir e-mail ve geçerli password girer.
      Then : Kullanici e-mail adresinin '@' ve '.' işareti içerdiğini kontrol eder.
      And :Kullanici sign in butonuna tıklar.
      Then :Kullanıcı siteye giriş yaptığını doğrular .

    @ThirdHooks
    @Smoke
    Scenario: TC_0002 invalid credential
      When : Kullanici credential'a uymayan e-mail adresi girer.
        | @ |
        | . |
      And : Kullanıcı sign in butonuna tıklar
      Then : Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.

    @ThirdHooks
    @Smoke
    Scenario: TC_0003 invalid credential
      When : Kullanici crendential içermeyen e-mail adresi girer.
      And : Kullanıcı sign in butonuna tıklar
      Then : Kullanici "Not Authorized. Please try with valid credentials" uyarısını aldığını doğrular.



























