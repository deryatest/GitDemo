package cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(features="src/main/java/features", glue="stepDefinitions", monochrome = true,
        tags="@PlaceOrder or @OffersPage", plugin = {"html:target/cucumber.html",
        "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"})
public class JunitTestRunnerTest {

}
