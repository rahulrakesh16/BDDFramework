import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class TestRunner {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            strict = false,
            features = {"classpath:features/widgets.feature"},
            format = {"pretty","json:target/cucumber.json"},
            glue = {"classpath:stepDefinition"},
            plugin = {"pretty", "html:target/cucumber/html"})
    public class ExampleFeatureRunner {
    }
}
