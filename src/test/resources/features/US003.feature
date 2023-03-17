Feature: US003 Ana sayfadaki (marketplace) açılır menü (drop-down) işlevlerini doğrulama

  @SecondHooks
Scenario: TC001 Kullanıcı açılan menüde username ve rolünü görüntüleyebilir
  Given Kullanici marketplace sayfasindadir
  When acilan sayfanin sag ust kosesinde yer alan drop-down menusune tikladiginda
  Then Username i goruntuler
  And Rolu goruntuler

@SecondHooks
Scenario: TC002 Kullanıcı Account Management butonuna tıklayıp Account Management sayfasını görüntüleyebilir
  Given Kullanici marketplace sayfasindadir
  When acilan sayfanin sag ust kosesinde yer alan drop-down menusune tikladiginda
  And Account Management butonuna tiladiginda
  Then Account Management sayfasini goruntuler









