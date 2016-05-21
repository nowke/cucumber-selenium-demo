package in.nowke.cucumber_selenium_demo;

/**
 * Created by nav on 21/5/16.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features="src/test/resources"
)
public class SeleniumTestRunner {
    static final String TEST_URL = "http://www.seleniumframework.com/Practiceform/";

    public static WebDriver getWebDriver() {
        return new FirefoxDriver();
    }
}