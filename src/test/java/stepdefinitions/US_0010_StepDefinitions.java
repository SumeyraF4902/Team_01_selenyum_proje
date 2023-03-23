package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.RemoteUnitsPage;

import utilities.Driver;

public class US_0010_StepDefinitions {

    RemoteUnitsPage remoteUnitsPage=new RemoteUnitsPage(Driver.getDriver());

    @When("Kullanici Remote Units butonuna tiklar")
    public void kullaniciRemoteUnitsButonunaTiklar() {
        remoteUnitsPage.remoteUnitsButton();
    }

    @Then("Kullanıcı Remote Unitsleri sayfada goruntuledigini dogrular")
    public void kullanıcıRemoteUnitsleriSayfadaGoruntulediginiDogrular() {
        remoteUnitsPage.assertRemoteUnits();

    }
}
