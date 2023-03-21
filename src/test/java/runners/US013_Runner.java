package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/US013.feature"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"},
        tags = "@FirstHooks"
        )
public class US013_Runner {

}