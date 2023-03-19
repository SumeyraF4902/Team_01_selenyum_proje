package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/US_0012.feature"},
        glue = {"US_0012_StepDefinitions", "Hooks"},
        plugin = {"pretty"},
        monochrome = true
)


public class US_0012_Runner {
}
