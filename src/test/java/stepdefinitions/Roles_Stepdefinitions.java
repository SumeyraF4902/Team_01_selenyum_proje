package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RolesPage;
import utilities.Driver;

public class Roles_Stepdefinitions {
    RolesPage rolePage = new RolesPage(Driver.getDriver());
    @Given("Kullanici  roller bolumune tiklar")
    public void kullaniciRollerBolumuneTiklar () {

        rolePage.clickRoles();
    }

    @Then("Kullanici roller bolumundeki rolleri gorur ve rolleri listeler")
    public void kullaniciRollerBolumundekiRolleriGorurVeRolleriListeler() {

        rolePage.allRollesGorunurMu();


    }

   @When("Kullanici herbir rolu tiklar ve tiklanir oldugunu kontrol eder")
    public void kullaniciHerbirRoluTiklarVeTiklanirOldugunuKontrolEder()  {

      rolePage.setAllRolesClickAndDogrula();


    }

    @Then("Kullanici roller bolumundeki rolleri tikladiğinda her birinin Permissions gorur")
    public void kullaniciRollerBolumundekiRolleriTikladiğindaHerBirininPermissionsGorur() {

        rolePage.allRolPermissionsList();
    }


    }

