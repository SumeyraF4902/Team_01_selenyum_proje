package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/US_0012.feature"},
        glue = {"stepdefinitions", "Hooks"},
        plugin = {"pretty"},
        monochrome = true,
        tags = "@FirstHooks"
)


public class US_0012_Runner {
}
