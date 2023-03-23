package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ={"src/test/resources/features/roles.feature"},
        glue = {"Hooks" ,"stepdefinitions"},
        plugin = {"pretty",
                "html: target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags= "@Regression"
)
public class regression {
}
