package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.DropDownPage;
import utilities.Driver;

public class US003_StepDefinitions {
    DropDownPage US003Page=new DropDownPage(Driver.getDriver());
    @Given("Kullanici marketplace sayfasindadir")
    public void kullaniciMarketplaceSayfasindadir() {
      US003Page.AssertIfOnMarketPlace();

    }

    @When("acilan sayfanin sag ust kosesinde yer alan drop-down menusune tikladiginda")
    public void acilanSayfaninSagUstKosesindeYerAlanDropDownMenusuneTikladiginda()  {

        US003Page.openDropdown();

    }

    @Then("Username i goruntuler")
    public void usernameIGoruntuler(){

        US003Page.AssertVisibiltyOfUsername();

    }

    @And("Rolu goruntuler")
    public void roluGoruntuler() {

        US003Page.AssertVisibilityOfRole();

        }

    @And("Account Management butonuna tiladiginda")
    public void accountManagementButonunaTiladiginda() {

        US003Page.ClickAccManagementButton();

    }

    @Then("Account Management sayfasini goruntuler")
    public void accountManagementSayfasiniGoruntuler() {

        US003Page.AssetIfOnAccManagementPage();
    }


}

