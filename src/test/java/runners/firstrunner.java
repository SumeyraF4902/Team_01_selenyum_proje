package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/feature.feature"},
        glue = {"Hooks","stepdefinitions"},
        plugin = {"html: target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags= "@FirstHooks"
)
public class firstrunner {


        
}