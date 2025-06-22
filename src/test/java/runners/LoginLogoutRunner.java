package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login_and_logout.feature", glue = "stepdefinitions", plugin = {
        "pretty", "json:target/cucumber-report.json" }, monochrome = true)
public class LoginLogoutRunner {
}