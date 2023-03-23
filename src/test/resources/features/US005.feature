Feature: subscriptions bilgilerini görüntülemeli

  Background:
    Given : Kullanici login butanuna basar
    And : username ve password girişini gerçekleştirir
    And :Profil simgesine gider ve Account Manegement sekmesini acar


  Scenario: Kullanici subscriptions bilgilerini görüntüler
    When kullanici subscriptiona tiklar
    Then kullanici subscriptiona datalari görüntüler