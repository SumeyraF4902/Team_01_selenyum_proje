package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/US_0011.feature"},
        glue = {"US_0011_StepDefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)




public class US_0011_Runner {


}
