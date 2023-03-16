package runners;

import Hooks.Hooks;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/featurer.feature"},
        glue = {"Hooks","stepdefinitions"},
        plugin ={"pretty"}
)

public class firstrunner {


        
}