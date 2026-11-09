package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/Reports/ParaBankReport.html",
                "json:target/Reports/ParaBankReport.json"
        },
        publish = true
)
public class ParaBankRunner{
}
