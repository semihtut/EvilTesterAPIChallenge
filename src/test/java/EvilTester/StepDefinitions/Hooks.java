package EvilTester.StepDefinitions;

import EvilTester.Utilities.ConfigurationReader;
import EvilTester.Utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {


    @Before
    public void setUp() {
        // we put a logic that should apply to every scenario
    }
    @After
    public void tearDown(Scenario scenario) {

    }





}