package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserDetailPage;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class US015_StepDefinitions {
    UserDetailPage userPage = new UserDetailPage();

    @And("Kullanici Users modülündedir")
    public void kullaniciUsersModülündedir() {

        userPage.navigateToUserModul();

    }

    @When("Kullanici Yeni Kullanici ekler")
    public void kullaniciYeniKullaniciEkler() throws AWTException, IOException, UnsupportedFlavorException {
        userPage.addNewUser();
    }

    @Then("Kullanici yeni eklenenen Kullaniciyi Users Modülde görüntüler")
    public void kullaniciYeniEklenenenKullaniciyiUsersModüldeGörüntüler() {
        userPage.isNewlyAddedUserDisplayed();

    }

    @Then("Kullanici yeni eklennen Kullanicida Yesil Tick isareti görmez")
    public void kullaniciYeniEklennenKullanicidaYesilTickIsaretiGörmez() {
        userPage.IsUserNotVerified();
    }

    @And("Kullanicinin girmis oldugu mail adresine onay icin mesaj gönderir")
    public void kullanicininGirmisOlduguMailAdresineOnayIcinMesajGönderir() {
        userPage.sendVerifyEmailToUser();
    }

    @And("Kullanici mail adresini onaylar")
    public void kullaniciMailAdresiniOnaylar() {
        userPage.verifyEmail();
    }

    @Then("Kullanici yenin eklenen Kullanicida Yesil Tick isaretini görür")
    public void kullaniciYeninEklenenKullanicidaYesilTickIsaretiniGörür() {

        userPage.IsUserVerified();
    }
}
