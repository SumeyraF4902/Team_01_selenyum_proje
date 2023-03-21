package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RemoteUnitsPage;
import utilities.Driver;

public class US_0012_StepDefinitions {

    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage(Driver.getDriver());

    @When("Kullanici ilgili duzenlemeleri yapar")
    public void kullaniciIlgiliDuzenlemeleriYapar() {

        remoteUnitsPage.randomUnitButton();
        remoteUnitsPage.editRemoteUnitButton();
        remoteUnitsPage.nameButton();
        remoteUnitsPage.departmentShortName();
        remoteUnitsPage.departmentTypeSelectDropdown();
        remoteUnitsPage.departmentDescriptionButton2();
        remoteUnitsPage.saveButton2();
    }

    @Then("Kullanici duzenleme yaptigini sayfada dogrular")
    public void kullaniciDuzenlemeYaptiginiSayfadaDogrular() {


    }

    @When("Kullanıcı Delete  Department butonuna tiklar")
    public void kullanıcıDeleteDepartmentButonunaTiklar() {

        remoteUnitsPage.deleteUnitButtonr();
        remoteUnitsPage.editRemoteUnitButton2();
        remoteUnitsPage.deleteDepartmentButton();


    }

    @And("Kullanıcı cikan uyarida Tamam butonuna tiklar")
    public void kullanıcıCikanUyaridaTamamButonunaTiklar() {
        remoteUnitsPage.acceptAllert();
    }

    @Then("Kullanici sildigi birimin sayfada olmadigini dogrular")
    public void kullaniciSildigiBiriminSayfadaOlmadiginiDogrular() {
    }


    //(//div[@class='col-4'])[2]//a
    //(//div[@class='col-4'])[2]//a

}
