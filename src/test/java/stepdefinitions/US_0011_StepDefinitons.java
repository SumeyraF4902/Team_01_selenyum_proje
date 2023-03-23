package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.RemoteUnitsPage;
import utilities.Driver;

import java.security.Key;

public class US_0011_StepDefinitons {


    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage(Driver.getDriver());
    @And("Kullanici Add New Remote Unit' e tiklar.")
    public void kullaniciAddNewRemoteUnitETiklar() {

        remoteUnitsPage.addNewRemoteUnitButton();
    }

    @And("Kullanici çikan sayfada isim ve tur secer")
    public void kullaniciÇikanSayfadaIsimVeTurSecer() {

        remoteUnitsPage.nameButton();
        remoteUnitsPage.departmentTypeSelectDropdown();
    }

    @And("Kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        remoteUnitsPage.saveButton();



    }

    @Then("Kullanici  ekledigi birimin Remote Units sayfasinda bulundugunu dogrular")
    public void kullaniciEkledigiBiriminRemoteUnitsSayfasindaBulundugunuDogrular() {
        remoteUnitsPage.assertNewRemote();
    }

    @And("Kullanici ekledigi birimin isim ve type bilgilerinde degisiklik yapar")
    public void kullaniciEkledigiBiriminIsimVeTypeBilgilerindeDegisiklikYapar() throws InterruptedException {
        remoteUnitsPage.nameButton();
        remoteUnitsPage.departmentTypeSelectDropdown();
        remoteUnitsPage.saveButton();

    }

    @And("Kullanıcı Edit'e tiklar")
    public void kullanıcıEditeTiklar() {
        remoteUnitsPage.edit11();
        remoteUnitsPage.nameButton();
        remoteUnitsPage.departmentShortName();
        remoteUnitsPage.departmentTypeSelectDropdown();
        remoteUnitsPage.departmentDescriptionButton2();
        remoteUnitsPage.saveButton();


    }

    @Then("Kullanici ekledigi birimin bilgilerinde degisiklik oldugunu goruntuler")
    public void kullaniciEkledigiBiriminBilgilerindeDegisiklikOldugunuGoruntuler() {
        remoteUnitsPage.assertEditRemote();
    }



}
