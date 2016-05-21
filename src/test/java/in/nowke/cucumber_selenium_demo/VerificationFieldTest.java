package in.nowke.cucumber_selenium_demo;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        Assert.assertEquals("Selenium Framework | Practiceform", driver.getTitle());
        Assert.assertEquals("http://www.seleniumframework.com/Practiceform/", driver.getCurrentUrl());
    }

    @And("^I fill two digit number \"([^\"]*)\" in verification field$")
    public void i_fill_two_digit_number_in_verification_field(String number) throws Throwable {
        driver.findElement(By.id("vfb-3")).sendKeys(number);
    }

    @And("^I hit submit button$")
    public void i_hit_submit_button() throws Throwable {
        driver.findElement(By.id("vfb-4")).click();
    }

    @Then("^I get form success message$")
    public void i_get_form_success_message() throws Throwable {
        WebElement formSuccessParagraph = driver.findElement(By.id("form_success"));
        String successStr = formSuccessParagraph.isDisplayed() ? formSuccessParagraph.getText() : "";
        Assert.assertEquals(
                "Your form was successfully submitted. Thank you for contacting us.",
                successStr
        );
    }
}