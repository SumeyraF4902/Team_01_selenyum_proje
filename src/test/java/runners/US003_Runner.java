package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/US003.feature"},
        glue = {"stepdefinitions","Hooks"},
        plugin = {"html: target/cucumber-reports",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags= "@SecondHooks"
)

public class US003_Runner {
}
