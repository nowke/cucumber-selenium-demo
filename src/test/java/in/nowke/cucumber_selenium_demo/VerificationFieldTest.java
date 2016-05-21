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

    private final WebDriver driver;

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
        driver.close();
    }

    @And("^I fill single digit number \"([^\"]*)\" in verification field$")
    public void i_fill_non_two_digit_number_in_verification_field(String single_digit) throws Throwable {
        i_fill_two_digit_number_in_verification_field(single_digit);
    }

    @Then("^I get at least 2 character required error message$")
    public void i_get_at_least_two_character_required_error_message() throws Throwable {
        VerifyLabelStr("Please enter at least 2 characters.");
        driver.close();
    }

    @Then("^I get field required error message$")
    public void i_get_field_required_error_message() throws Throwable {
        VerifyLabelStr("This field is required.");
        driver.close();
    }

    @And("^I fill multiple digit number \"([^\"]*)\" in verification field$")
    public void i_fill_multiple_digit_number_in_verification_field(String multiple) throws Throwable {
        i_fill_two_digit_number_in_verification_field(multiple);
    }

    @Then("^I get no more than two characters error message$")
    public void i_get_no_more_than_two_characters_error_message() throws Throwable {
        VerifyLabelStr("Please enter no more than 2 characters.");
        driver.close();
    }

    @And("^I fill non-digit \"([^\"]*)\" in verification field$")
    public void i_fill_non_digit_in_verification_field(String character) throws Throwable {
        i_fill_two_digit_number_in_verification_field(character);
    }

    @Then("^I get digits only error message$")
    public void i_get_digits_only_error_message() throws Throwable {
        VerifyLabelStr("Please enter only digits.");
        driver.close();
    }

    /* Helper methods */

    /**
     * Finds Verification field error label element,
     * asserts label text against @param expectedLabelStr
     * @param expectedLabelStr Expected Label String
     */
    private void VerifyLabelStr(String expectedLabelStr) {
        WebElement verificationErrorLabel = driver.findElement(By.cssSelector("label[for='vfb-3'][class='vfb-error']"));
        String verificationError = verificationErrorLabel.getText();
        Assert.assertEquals(
                verificationErrorLabel.isDisplayed(),
                true
        );
        Assert.assertEquals(
                expectedLabelStr,
                verificationError
        );
    }
}