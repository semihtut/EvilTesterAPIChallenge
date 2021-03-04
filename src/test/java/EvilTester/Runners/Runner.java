package EvilTester.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/",
        glue = "EvilTester/StepDefinitions/",
        dryRun = false,
        tags = "@Challenge3"

)
public class Runner {
}
//mvn test -Dcucumber.options="--tags @api"