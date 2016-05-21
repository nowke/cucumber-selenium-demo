package in.nowke.cucumber_selenium_demo;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

/**
 * Created by nav on 21/5/16.
 */
public class VerificationFieldTest {

    private WebDriver driver;

    public VerificationFieldTest() {
        driver = SeleniumTestRunner.getWebDriver();
    }

    @Given("^Navigate to PracticeForm$")
    public void navigate() {
        driver.navigate().to(SeleniumTestRunner.TEST_URL);
    }
}