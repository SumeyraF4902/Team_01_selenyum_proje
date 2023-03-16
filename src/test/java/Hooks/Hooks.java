package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;
public class Hooks {

    @BeforeClass
    public void setUp() {
        LoginStep ls = new LoginStep(Driver.getDriver());
        ls.driverGet("https://qa-gm3.quaspareparts.com/");
        ls.clickLogin();
        String email = ConfigReader.getProperty("email").replaceAll(" ","");
        String password = ConfigReader.getProperty("password").replaceAll(" ","");
        ls.typeUsername(email);
        ls.typePassword(password);
        ls.clickSubBtn();
        ls.clickprofile();
        ls.clickAccount_mng();
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }
}
