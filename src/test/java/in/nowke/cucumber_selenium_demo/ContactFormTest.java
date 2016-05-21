package in.nowke.cucumber_selenium_demo;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by nav on 21/5/16.
 */
public class ContactFormTest {
    private WebDriver driver;
    private WebElement contactForm;

    @Given("^Navigate to PracticeForm for Contact$")
    public void navigateContact() {
        driver = SeleniumTestRunner.getWebDriver();
        driver.navigate().to(SeleniumTestRunner.TEST_URL);
        Assert.assertEquals("Selenium Framework | Practiceform", driver.getTitle());
        Assert.assertEquals("http://www.seleniumframework.com/Practiceform/", driver.getCurrentUrl());
        contactForm = driver.findElement(By.cssSelector(".contact-form.dt-form"));
    }

    @And("^I fill \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in Contact Form$")
    public void i_fill_all_contact_form(String name, String email, String phone, String country, String company, String message) throws Throwable {
        contactForm.findElement(By.name("name")).sendKeys(name);
        contactForm.findElement(By.name("email")).sendKeys(email);
        contactForm.findElement(By.name("telephone")).sendKeys(phone);
        contactForm.findElement(By.name("country")).sendKeys(country);
        contactForm.findElement(By.name("company")).sendKeys(company);
        contactForm.findElement(By.name("message")).sendKeys(message);
    }

    @And("^I hit contact submit button$")
    public void i_hit_contact_submit_button() throws Throwable {
        contactForm.findElement(By.cssSelector(".dt-btn.dt-btn-m.dt-btn-submit")).click();
    }

    @Then("^I get acknowledgement message$")
    public void i_get_ack_message() throws Throwable {

        // Wait for max 2 seconds until success message appears!
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".formErrorContent")));

        String formStatus = contactForm.findElement(By.cssSelector(".formErrorContent")).getText();
        Assert.assertEquals(
                "Feedback has been sent to the administrator",
                formStatus
        );
        driver.close();
    }

    @Then("^I get errors for required fields$")
    public void i_get_errors_for_required_fields() throws Throwable {
        WebElement name = contactForm.findElement(By.className("form-name"));
        Assert.assertEquals(
                true,
                name.findElement(By.className("formErrorContent")).isDisplayed()
        );

        WebElement email = contactForm.findElement(By.className("form-mail"));
        Assert.assertEquals(
                true,
                email.findElement(By.className("formErrorContent")).isDisplayed()
        );

        WebElement phone = contactForm.findElement(By.className("form-telephone"));
        Assert.assertEquals(
                true,
                phone.findElement(By.className("formErrorContent")).isDisplayed()
        );
    }
}
