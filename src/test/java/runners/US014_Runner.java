package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
// raporlari olustururken format:path seklinde raporun nerede ve hangi formatta olusturacagimizi belirtiriz
@CucumberOptions(
        features = {"src/test/resources/features/US014.feature"},
        glue = {"US014_Stepdefs", "hooks"},
        plugin = {"pretty"},
        monochrome = true
        )
public class US014_Runner {

}
