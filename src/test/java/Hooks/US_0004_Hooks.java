package Hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;

public class US_0004_Hooks {

    @Before("@US_0004_Hooks")
    public void setUp() {
        LoginStep ls = new LoginStep(Driver.getDriver());
        ls.driverGet("https://qa-gm3.quaspareparts.com/");
        ls.clickLogin();
        ls.typeUsername(ConfigReader.getProperty("Serhat_email"));
        ls.typePassword(ConfigReader.getProperty("Serhatpassword"));
        ls.clickSubBtn();


    }

    @After("@US_0004_Hooks")
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }
}
