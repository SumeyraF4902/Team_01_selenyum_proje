package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US_0001 {
    LoginStep ls = new LoginStep(Driver.getDriver());

    @When(": Kullanici {string} ve {string} işareti içeren geçerli bir e-mail ve geçerli password girer.")
    public void kullaniciVeIşaretiIçerenBirEMailGirer(String a, String nokta) {
        String mail = "group1" + a + "test" + nokta + "com";
        ls.typeUsername(mail);
        ls.typePassword(ls.get_Config("password"));
    }

    @Then(": Kullanici e-mail adresinin {string} ve {string} işareti içerdiğini kontrol eder.")
    public void kullaniciEMailAdresininVeIşaretiIçerdiğiniKontrolEder(String a, String nokta) {
        String mail = "group1" + a + "test" + nokta + "com";
        ls.AssertTrue(mail.contains("@") & mail.contains("."));
    }

    @And(":Kullanici sign in butonuna tıklar.")
    public void kullaniciSignInButonunaTıklar() {
        ls.clickSubBtn();
    }

    @Then(":Kullanıcı siteye giriş yaptığını doğrular .")
    public void kullanıcıSiteyeGirişYaptığınıDoğrular() {
        ls.AssertTrue(ls.login_email.isDisplayed());
    }

    //--------------------------------------------------------------------------------------------------------------
    @When(": Kullanici credential'a uymayan e-mail adresi girer.")
    public void kullaniciCredentialAUymayanEMailAdresiGirer(List<String> items) {


            String mail = "group1" + items.get(0) + "test";
            ls.typeUsername(mail);

        ls.typePassword(ls.get_Config("password"));
    }

    @And(": Kullanıcı sign in butonuna tıklar")
    public void kullanıcıSignInButonunaTıklar() {
        ls.clickSubBtn();
    }

    @Then(": Kullanici {string} uyarısını aldığını doğrular.")
    public void kullaniciUyarısınıAldığınıDoğrular(String arg0) {
        ls.AssertTrue(ls.GetText(ls.Authorized).contains(arg0));
    }

    @When(": Kullanici crendential içermeyen e-mail adresi girer.")
    public void kullaniciVeIşaretleriniKullanmadanEMailAdresiGirer() {
        String mail= ls.get_Config("mail_notAuthorized");
        ls.typeUsername(mail);
        ls.typePassword(ls.get_Config("password"));
    }


}
