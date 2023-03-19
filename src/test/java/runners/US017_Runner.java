package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/US017.feature"},
        glue = {"stepdefinitions","Hooks"},
        tags= "@FirstHooks"
)




public class US017_Runner {



}
