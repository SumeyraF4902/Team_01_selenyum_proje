Feature: US017  User modülünde ekleme/davet işlemleri yapabilme

  Background:
    Given Kullanici Account Management sayfasindadir

  @FirstHooks
  Scenario: TC001 Kullanıcı yeni bir user ekleyebilir
    When Soldaki menuden User modulune gectiginde
    And New Registration butonuna tikladiginda
    And Rol ve valid mail girisi yaptiginda
    And Register butonuna tikladiginda
    Then New user registration successful yazisini goruntuler

  @FirstHooks
  Scenario: TC002 Invalid mail ile register yapılamaz
    When Soldaki menuden User modulune gectiginde
    And New Registration butonuna tikladiginda
    And Rol ve invalid mail girisi yaptiginda
    And Register butonuna tikladiginda
    Then Please enter a valid email yazisini goruntuler


   @FirstHooks
   Scenario: TC003 Kullici yeni kullanici davet edebilir
     When Soldaki menuden User modulune gectiginde
     And New User Invitation butonuna tikladiginda
     And Rol ve valid mail girisi yaptiginda
     And Send Invitation butonunu tikladiginda
     Then A invitation e-mail has been sent to the e-mail address you entered yazisini goruntuler

















