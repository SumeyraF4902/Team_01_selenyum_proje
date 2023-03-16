package runners;

import Hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        glue = {"stepdefinitions","Hooks"},
        plugin ={"pretty"}
)

public class login_runner {


}