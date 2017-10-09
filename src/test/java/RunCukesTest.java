import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/test-results"})
public class RunCukesTest {
}
