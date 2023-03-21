package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ={"src/test/resources/features/roles.feature"},
        glue = {"Hooks" ,"stepdefinitions"},
        plugin ={"pretty"},
        tags= "@FirstHooks"

)
public class Roles_runner {



}

