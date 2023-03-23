package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.US017Page;
import utilities.Driver;

public class US017_StepDefinitions {
    US017Page us017Page=new US017Page(Driver.getDriver());
    @Given("Kullanici Account Management sayfasindadir")
    public void kullaniciAccountManagementSayfasindadir() {
        us017Page.assertIfAccManagementPage();
    }

    @When("Soldaki menuden User modulune gectiginde")
    public void soldakiMenudenUserModuluneGectiginde() {
        us017Page.clickUserModule();
    }

    @And("New Registration butonuna tikladiginda")
    public void newRegistrationButonunaTikladiginda() {
        us017Page.clickNewUserRegistration();
    }

    @And("Rol ve valid mail girisi yaptiginda")
    public void rolVeValidMailGirisiYaptiginda() {
        us017Page.chooseARole();
        us017Page.enterAnValidEmail();
    }

    @And("Register butonuna tikladiginda")
    public void registerButonunaTikladiginda() {

        us017Page.clickRegButton();
    }

    @Then("New user registration successful yazisini goruntuler")
    public void newUserRegistrationSuccessfulYazisiniGoruntuler() {
        us017Page.assertUserRegSuccessAlert();

    }

    @And("Rol ve invalid mail girisi yaptiginda")
    public void rolVeInvalidMailGirisiYaptiginda() {
        us017Page.RolAndenterAnInvalidEmail();
    }

    @Then("Please enter a valid email yazisini goruntuler")
    public void pleaseEnterAValidEmailYazisiniGoruntuler() {
        us017Page.assertInvalidMailAlert();
    }

    @And("New User Invitation butonuna tikladiginda")
    public void newUserInvitationButonunaTikladiginda() {
        us017Page.clickNewUserInvitation();
    }

    @And("Send Invitation butonunu tikladiginda")
    public void sendInvitationButonunuTikladiginda() {
        us017Page.clickSendInvitation();
    }

    @Then("A invitation e-mail has been sent to the e-mail address you entered yazisini goruntuler")
    public void aInvitationEMailHasBeenSentToTheEMailAddressYouEnteredYazisiniGoruntuler() {
        us017Page.mailSentAlert();
    }
}
