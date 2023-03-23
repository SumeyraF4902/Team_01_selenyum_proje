package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CompanyPage;
import pages.SubscriptionsPage;
import utilities.Driver;

public class US005_StepDefinitions {

    SubscriptionsPage subscriptionsPage= new SubscriptionsPage(Driver.getDriver());


    @When("kullanici subscriptiona tiklar")
    public void kullaniciSubscriptionaTiklar() {
        subscriptionsPage.click();
    }

    @Then("kullanici subscriptiona datalari görüntüler")
    public void kullaniciSubscriptionaDatalariGoruntuler() {
        subscriptionsPage.seeData();
    }
}
