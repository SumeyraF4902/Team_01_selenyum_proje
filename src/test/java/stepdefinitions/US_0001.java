package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginStep;
import utilities.Driver;

public class US_0001 {
    LoginStep ls = new LoginStep(Driver.getDriver());
    @Given(":Kullanici url'ye gider.")
    public void kullaniciUrlYeGider() {
        ls.driverGet("url");
    }

    @And(":login butonuna tıklar.")
    public void loginButonunaTıklar() {
        ls.clickLogin();
    }

    @When(": Kullanici {string} ve {string} işareti içeren bir e-mail girer.")
    public void kullaniciVeIşaretiIçerenBirEMailGirer(String anatasyon ,String nokta) {
        String mail = "group1"+ anatasyon+"test"+nokta +"com";
        System.out.println(mail);
    }

    @Then(": Kullanici e-mail adresinin {string} ve {string} işareti içerdiğini kontrol eder.")
    public void kullaniciEMailAdresininVeIşaretiIçerdiğiniKontrolEder() {
    }

    @And(":Kullanici sign in butonuna tıklar.")
    public void kullaniciSignInButonunaTıklar() {
    }

    @Then(":Kullanıcı sadece Please fill out this field yazısının geldiğini doğrular.")
    public void kullanıcıSadecePleaseFillOutThisFieldYazısınınGeldiğiniDoğrular() {
    }

    @And(":Kullanıcı geçerli password bilgisini girer ve sign in olur.")
    public void kullanıcıGeçerliPasswordBilgisiniGirerVeSignInOlur() {
    }

    @Then(":Kullanıcı siteye giriş yaptığını doğrular .")
    public void kullanıcıSiteyeGirişYaptığınıDoğrular() {
    }

    @When(": Kullanici {string} ve {string} işaretlerinden en az birini kullanmadan e-mail adresi girer.")
    public void kullaniciVeIşaretlerindenEnAzBiriniKullanmadanEMailAdresiGirer() {
    }

    @And(": Kullanıcı sign in butonuna tıklar")
    public void kullanıcıSignInButonunaTıklar() {
    }

    @Then(": Kullanici {string} uyarısını aldığını doğrular.")
    public void kullaniciUyarısınıAldığınıDoğrular(String arg0) {
    }

    @When(": Kullanici {string} ve {string} işaretlerini kullanmadan e-mail adresi girer.")
    public void kullaniciVeIşaretleriniKullanmadanEMailAdresiGirer() {
    }
}
