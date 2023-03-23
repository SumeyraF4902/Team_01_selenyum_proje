package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CompanyPage;
import utilities.Driver;

public class US006_StepDefinitions {

    WebDriver driver = Driver.getDriver();
    CompanyPage companyPage = new CompanyPage(driver);


    @When(":kullanici profil sekmesini tiklar")
    public void kullaniciProfilSekmesiniTiklar() {

    }

    @Given("kullanici acilan sidebardan company sekmesini tiklar")
    public void kullaniciAcilanSidebardanCompanySekmesiniTiklar() {

        companyPage.companyClick();

    }

    @Then("kullanici company information verilerini goruntuler")
    public void kullaniciCompanyInformationVerileriniGoruntuler() {

        companyPage.companyVisibleDisplay();

    }

    @And("kullanici edit butonuna tiklar")
    public void kullaniciEditButonunaTiklar() {
        companyPage.editbutonunaTiklar();
    }

    @And("kullanici name ve email textbox'larini siler")
    public void kullaniciNameVeEmailTextboxLariniSiler() {
        companyPage.clearemailandname();
    }

    @And("kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        companyPage.saveTiklar();

    }

    @Then("kullanici bos name ve email textbox'in save olmadigini gorur")
    public void kullaniciBosNameVeEmailTextboxInSaveOlmadiginiGorur() {
        companyPage.gorunurligiDogrula();

    }

    @Given("kullanici cancel butonuna tiklar")
    public void kullaniciCancelButonunaTiklar() {
        companyPage.cancelButtonTiklar();

    }

    @And("kullanici name ve email textbox'larini degistirir")
    public void kullaniciNameVeEmailTextboxLariniDegistirir() {
        companyPage.nameVeEmailTextboxDegistir();

    }

    @Then("kullanici bos name ve email textbox'in degistigini gorur")
    public void kullaniciBosNameVeEmailTextboxInDegistiginiGorur() {
        companyPage.degisimDogrulanir();
    }

}
