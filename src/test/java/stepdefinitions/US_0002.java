package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginStep;
import utilities.Driver;

public class US_0002 {
    LoginStep ls = new LoginStep(Driver.getDriver());
    @Then(": Siteye giriş yaptığını doğrular")
    public void siteyeGirişYaptığınıDoğrular() {
        ls.AssertTrue(ls.login_email.isDisplayed());
    }
    String current_url = Driver.getDriver().getCurrentUrl();

    @When(": Logoya tıkladığında")
    public void logoyaTıkladığında() {

        ls.click(ls.logo);
    }

    @Then(":Logonun işlevini kontrol eder")
    public void logonunIşleviniKontrolEder() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ls.get_Config("url"));
        System.out.println(current_url);
        Driver.getDriver().get(current_url);
    }

    @When(":Hamburger menüye tıkladığında")
    public void hamburgerMenüyeTıkladığında() {
        ls.click(ls.hamburger);
    }

    @And(": Hamburger'in işlevini doğrular")
    public void hamburgerInIşleviniDoğrular() {
        Assert.assertTrue(ls.hamburger_check.isDisplayed());
    }

    @And(": Hamburger'in kapandığını doğrular")
    public void hamburgerInKapandığınıDoğrular() {

        Assert.assertFalse(ls.hamburger_check.isDisplayed());
    }
}
