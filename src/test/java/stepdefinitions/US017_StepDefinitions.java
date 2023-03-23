package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserPage;
import utilities.Driver;

public class US017_StepDefinitions {
    UserPage userPage =new UserPage(Driver.getDriver());
    @Given("Kullanici Account Management sayfasindadir")
    public void kullaniciAccountManagementSayfasindadir() {
        userPage.assertIfAccManagementPage();
    }

    @When("Soldaki menuden User modulune gectiginde")
    public void soldakiMenudenUserModuluneGectiginde() {
        userPage.clickUserModule();
    }

    @And("New Registration butonuna tikladiginda")
    public void newRegistrationButonunaTikladiginda() {
        userPage.clickNewUserRegistration();
    }

    @And("Rol ve valid mail girisi yaptiginda")
    public void rolVeValidMailGirisiYaptiginda() {
        userPage.chooseARole();
        userPage.enterAnValidEmail();
    }

    @And("Register butonuna tikladiginda")
    public void registerButonunaTikladiginda() {

        userPage.clickRegButton();
    }

    @Then("New user registration successful yazisini goruntuler")
    public void newUserRegistrationSuccessfulYazisiniGoruntuler() {
        userPage.assertUserRegSuccessAlert();

    }

    @And("Rol ve invalid mail girisi yaptiginda")
    public void rolVeInvalidMailGirisiYaptiginda() {
        userPage.RolAndenterAnInvalidEmail();
    }

    @Then("Please enter a valid email yazisini goruntuler")
    public void pleaseEnterAValidEmailYazisiniGoruntuler() {
        userPage.assertInvalidMailAlert();
    }

    @And("New User Invitation butonuna tikladiginda")
    public void newUserInvitationButonunaTikladiginda() {
        userPage.clickNewUserInvitation();
    }

    @And("Send Invitation butonunu tikladiginda")
    public void sendInvitationButonunuTikladiginda() {
        userPage.clickSendInvitation();
    }

    @Then("A invitation e-mail has been sent to the e-mail address you entered yazisini goruntuler")
    public void aInvitationEMailHasBeenSentToTheEMailAddressYouEnteredYazisiniGoruntuler() {
        userPage.mailSentAlert();
    }
}
