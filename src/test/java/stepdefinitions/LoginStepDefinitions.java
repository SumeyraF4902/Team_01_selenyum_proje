package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.Properties;

public class LoginStepDefinitions {
    LoginStep ls = new LoginStep(Driver.getDriver());
    @Given(": Kullanici login butanuna basar")
    public void kullaniciLoginButanunaBasar() {
        ls.driverGet("https://qa-gm3.quaspareparts.com/");
        ls.clickLogin();
    }
    @When(": username ve password girişini gerçekleştirir")
    public void usernameVePasswordGirişiniGerçekleştirir() {
        String email = ConfigReader.getProperty("email").replaceAll(" ","");
        String password = ConfigReader.getProperty("password").replaceAll(" ","");
        System.out.println(email);
        ls.typeUsername(email);
        ls.typePassword(password);
        ls.clickSubBtn();
    }


    @Then(":Profil simgesine gider ve Account Manegement sekmesini acar")
    public void profilSimgesineGiderVeAccountManegementSekmesiniAcar() {
        ls.clickprofile();
        ls.clickAccount_mng();
    }
}
