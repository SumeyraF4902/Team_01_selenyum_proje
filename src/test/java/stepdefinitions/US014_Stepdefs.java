package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TeamsPage;
import utilities.Driver;
public class US014_Stepdefs {
    TeamsPage tp = new TeamsPage(Driver.getDriver());
    @And("Kullanici ilk secilebilen takima tiklar")
    public void kullaniciIlkSecilebilenTakimaTiklar() {
    tp.clickFirstTeam();
    }
    @And("Kullanici sayfada sag ustte bulunan Edit Team butonuna tiklar")
    public void kullaniciSayfadaSagUstteBulunanEditTeamButonunaTiklar() {
    tp.addNewAndEditTeam();
    }
    @When("Kullanici cikan takim bilgilerinde degisiklik yapar")
    public void kullaniciCikanTakimBilgilerindeDegisiklikYapar() {
    tp.inputInfo();
    }
    @And("Kullanici sayfanin sag altinda bulunan Save butonuna tiklar")
    public void kullaniciSayfaninSagAltindaBulunanSaveButonunaTiklar() {
    tp.saveTeam();
    }
    @Then("Kullanici takim bilgilerinde degisiklik oldugunu dogrular")
    public void kullaniciTakimBilgilerindeDegisiklikOldugunuDogrular() {
    tp.editTeamAssertion();
    }
    @When("Kullanici sayfada sol altta bulunan Delete Department butonuna tiklar")
    public void kullaniciSayfadaSolAlttaBulunanDeleteDepartmentButonunaTiklar() {
    tp.deleteTeam();
    }
    @And("Kullanici sayfada ustte cikan Alert Mesajinda Tamam butonuna tiklar")
    public void kullaniciSayfadaUstteCikanAlertMesajindaTamamButonunaTiklar() {
    tp.acceptAlert();
    }
    @Then("Kullanici sildigi takimin sayfada artik bulunmadigini dogrular")
    public void kullaniciSildigiTakiminSayfadaArtikBulunmadiginiDogrular() {

    }
}
