package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utilities.Driver;

public class FirstStepDefinition {

    @Given("Ilk feature icin cucumber indirdim")
    public void ilk_feature_icin_cucumber_indirdim() {
        System.out.println("Given step i calisti");
        Driver.getDriver().get("https://google.com");
    }

    @When("Senaryomu calistirdigimda")
    public void senaryomu_calistirdigimda() {
        System.out.println("When step i calisti");
        Assert.assertTrue(false);
    }

    @Then("Senaryomun calistigini konsolda gormeliyim")
    public void senaryomun_calistigini_konsolda_gormeliyim() {
        System.out.println("Then step i calisti");
    }


}