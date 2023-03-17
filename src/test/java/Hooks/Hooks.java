package Hooks;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;
public class Hooks {

    @Before
    public void setUp() {
        LoginStep ls = new LoginStep(Driver.getDriver());
        ls.driverGet(ConfigReader.getProperty("url"));
        ls.clickLogin();
        String email = ConfigReader.getProperty("email").replaceAll(" ","");
        String password = ConfigReader.getProperty("password").replaceAll(" ","");
        ls.typeUsername(email);
        ls.typePassword(password);
        ls.clickSubBtn();
        ls.clickprofile();
        ls.clickAccount_mng();
    }

    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }

    }

    @After(order = 0)
    public void tearDown() {
        Driver.closeDriver();

    }
}
