package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TeamsPage;
import utilities.Driver;
public class US013_Stepdefs {
    TeamsPage tp = new TeamsPage(Driver.getDriver());
    @When("Kullanici Teams butonuna tiklar")
    public void kullaniciTeamsButonunaTiklar() {
    tp.teamsPage();
    }
    @Then("Kullanici takimlari liste halinde sayfada gorundugunu dogrular")
    public void kullaniciTakimlariListeHalindeSayfadaGorundugunuDogrular() {

    }
    @When("Kullanici ilk secebildigi takima tiklar")
    public void kullaniciIlkSecebildigiTakimaTiklar() {
    tp.clickFistTeam();
    }
    @Then("Kullanici tikladigi takimin bilgilerinin detayli olarak sayfada gorundugunu dogrular")
    public void kullaniciTikladigiTakiminBilgilerininDetayliOlarakSayfadaGorundugunuDogrular() {

    }
    @When("Kullanici sayfada sag ustte bulunan Add New Team butonuna tiklar")
    public void kullaniciSayfadaSagUstteBulunanAddNewTeamButonunaTiklar() {
    tp.addNewAndEditTeam();
    }
    @And("Kullanici cıkan sayfadaki bosluklari doldurur.")
    public void kullaniciCıkanSayfadakiBosluklariDoldurur() {
    tp.inputInfo();
    }
    @And("Kullanici sayfada sag altta bulunan Save butonuna tiklar")
    public void kullaniciSayfadaSagAlttaBulunanSaveButonunaTiklar() {
    tp.saveTeam();
    }
    @And("Kullanici sayfada sol ortada bulunan Teams butonuna tekrar tiklar")
    public void kullaniciSayfadaSolOrtadaBulunanTeamsButonunaTekrarTiklar() {
    tp.teamsPage();
    }
    @Then("Kullanici ekledigi takimin Teams sayfasinda bulundugunu dogrular")
    public void kullaniciEkledigiTakiminTeamsSayfasindaBulundugunuDogrular() {

    }
}
