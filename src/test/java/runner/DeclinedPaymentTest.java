package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        plugin = {"html:target/cucumber"},
        features = "classpath:features",
        glue =  "classpath:flow",
        tags = "~@ignore")

public class DeclinedPaymentTest {
}
