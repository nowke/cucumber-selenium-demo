package in.nowke.cucumber_selenium_demo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by nav on 22/5/16.
 */
public class FieldSetTest {
    private WebDriver driver;
    private WebElement fieldsetForm;

    @Given("^Navigate to PracticeForm for Fieldset")
    public void navigateFieldSet() {
        driver = SeleniumTestRunner.getWebDriver();
        driver.navigate().to(SeleniumTestRunner.TEST_URL);
        Assert.assertEquals("Selenium Framework | Practiceform", driver.getTitle());
        Assert.assertEquals("http://www.seleniumframework.com/Practiceform/", driver.getCurrentUrl());
        fieldsetForm = driver.findElement(By.id("practiceform-1"));
    }

    @And("^I fill \"([^\"]*)\" in textarea$")
    public void i_fill_in_textarea(String text) throws Throwable {
        fieldsetForm.findElement(By.id("vfb-10")).sendKeys(text);
    }

    @And("^I fill \"([^\"]*)\" in textbox$")
    public void i_fill_in_textbox(String text) throws Throwable {
        fieldsetForm.findElement(By.id("vfb-9")).sendKeys(text);
    }

    @And("^I check \"([^\"]*)\" in Checkbox$")
    public void i_check_in_checkbox(String option) throws Throwable {
        // Click checkbox with value `option`
        fieldsetForm.findElement(By.cssSelector("input[type='checkbox'][value='" + option + "']")).click();
    }

    @And("^I check \"([^\"]*)\" in RadioBox$")
    public void i_check_in_radiobox(String option) throws Throwable {
        fieldsetForm.findElement(By.cssSelector("input[type='radio'][value='" + option + "']")).click();
    }

    @And("^I fill \"([^\"]*)\" in Date Field$")
    public void i_fill_in_date_field(String date) throws Throwable {
        fieldsetForm.findElement(By.id("vfb-8")).sendKeys(date);
    }

    @And("^I fill \"([^\"]*)\" in URL field$")
    public void i_fill_in_url_field(String url) throws Throwable {
        fieldsetForm.findElement(By.id("vfb-11")).sendKeys(url);
    }

    @And("^I select \"([^\"]*)\" in Select Option$")
    public void i_select_in_select_options(String option) throws Throwable {
        Select selectBox = new Select(driver.findElement(By.id("vfb-12")));
        selectBox.selectByValue(option);
        driver.close();
    }
}
