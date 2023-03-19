package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginStep;
import utilities.ConfigReader;
import utilities.Driver;

public class ThirdHooks {
    @Before("@ThirdHooks")
    public void setUp() {
        LoginStep ls = new LoginStep(Driver.getDriver());
        ls.driverGet("https://qa-gm3.quaspareparts.com/");
        //String URL = ConfigReader.getProperty("URL").replaceAll(" ","");
        //ls.driverGet(URL);
        ls.clickLogin();
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
