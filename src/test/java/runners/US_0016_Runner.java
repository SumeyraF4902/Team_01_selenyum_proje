package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/US016.feature"},
        glue = {"stepdefinitions","Hooks"},
        plugin = {"pretty"},
        monochrome = true
)

public class US_0016_Runner {


}
