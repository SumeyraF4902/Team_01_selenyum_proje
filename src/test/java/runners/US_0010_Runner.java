package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/US_0010.feature"},
        glue = {"stepdefinitions", "Hooks"},
        plugin = {"pretty","html: target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags ="@FirstHooks"
)

public class US_0010_Runner {


}


