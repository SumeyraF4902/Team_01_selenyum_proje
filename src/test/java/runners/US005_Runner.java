package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/US015.feature"},
        glue = {"stepdefinitions","Hooks"},
        plugin = {"pretty","html: target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/json-reports/cucumber.json"},
        monochrome = true
)
public class US005_Runner


{
}
