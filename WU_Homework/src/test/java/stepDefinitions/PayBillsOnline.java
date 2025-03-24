package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.PayBillsOnlinePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PayBillsOnline {
    PayBillsOnlinePage payBillsPage = new PayBillsOnlinePage();
    Faker faker=new Faker();
    JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        Driver.getDriver().get(url);
        ReusableMethods.waitForPageToLoad(Duration.ofSeconds(10));
    }
    @When("User expands the burger menu")
    public void user_expands_the_burger_menu() {
        ReusableMethods.clickWithJS(payBillsPage.burgerMenuIconLv);
    }
    @When("User selects the Settings page")
    public void user_selects_the_settings_page() {
        ReusableMethods.clickWithJS(payBillsPage.burgerMenuSettings);
    }
    @When("User changes WU.com Country to {string}")
    public void user_changes_wu_com_country_to(String country) {
        Select countrySelect = new Select(payBillsPage.settingsCountrySelectionBox);
        countrySelect.selectByVisibleText(country);
        ReusableMethods.clickWithJS(payBillsPage.settingsCountrySelectionConfirmationYesButton);
    }
    @When("User verifies that page url is updated")
    public void user_verifies_that_page_url_is_updated() {
        ReusableMethods.waitForPageToLoad(Duration.ofSeconds(10));
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue("URL did not update correctly", currentUrl.contains("us/en/home.html"));
        ReusableMethods.waitForVisibility(payBillsPage.privacyIAcceptButton, Duration.ofSeconds(5));
        ReusableMethods.waitForClickablility(payBillsPage.privacyIAcceptButton, Duration.ofSeconds(5));
        ReusableMethods.clickWithJS(payBillsPage.privacyIAcceptButton);
    }
    @When("User selects PAY BILLS from burger menu")
    public void user_selects_pay_bills_from_burger_menu() {
        ReusableMethods.clickWithJS(payBillsPage.burgerMenuIconUs);
        ReusableMethods.clickWithJS(payBillsPage.burgerMenuPayBillsOption);

    }
    @When("User fills out the form with the following details")
    public void user_fills_out_the_form_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> formDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> formDetails : formDetailsList) {
            payBillsPage.payBillsPageCompanySearchBox.sendKeys(formDetails.get("companyName") + Keys.ENTER);
            payBillsPage.payBillsPageAmountInputBox.sendKeys(formDetails.get("amount"));
            payBillsPage.payBillsPageAccountNumberInputBox.sendKeys(formDetails.get("accountNumber") + Keys.TAB);

            ReusableMethods.waitForVisibility(payBillsPage.payBillsPagepayInStoreButton, Duration.ofSeconds(5));
            ReusableMethods.clickWithJS(payBillsPage.payBillsPagepayInStoreButton);
            ReusableMethods.clickWithJS(payBillsPage.payBillsPageUrgentButton);
            Select stateSelect = new Select(payBillsPage.payBillsPageStateInputBox);
            stateSelect.selectByVisibleText(formDetails.get("state"));
        }
    }
    @When("User clicks Continue")
    public void user_clicks_continue() {
        ReusableMethods.clickWithJS(payBillsPage.payBillsPageContinueButton);

    }
    @Then("User should see the confirmation page")
    public void user_should_see_the_confirmation_page() {
        assertTrue("Registration page is not displayed after clicking Continiue in pay bills page form", Driver.getDriver().getCurrentUrl().equals("https://www.westernunion.com/us/en/web/user/sm-login"));
    }

    @Then("User selects Find Location option")
    public void user_selects_find_location_option() {
        ReusableMethods.clickWithJS(payBillsPage.burgerMenuFindLocationsOption);
    }
    @Then("User validates that page is redirected to Find Locations page")
    public void user_validates_that_page_is_redirected_to_find_locations_page() {
        ReusableMethods.waitForPageToLoad(Duration.ofSeconds(10));
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue("Page did not redirect correctly", currentUrl.contains("find-locations"));
    }
    @Then("User clicks on Agent and fills Agent Name,Postal Code")
    public void user_clicks_on_agent_and_fills_agent_name_postal_code() {
        payBillsPage.findLocationPostalCodeInputBox.click();
        payBillsPage.findLocationPostalCodeInputBox.sendKeys(Keys.CONTROL + "a");
        payBillsPage.findLocationPostalCodeInputBox.sendKeys(Keys.DELETE);
        payBillsPage.findLocationPostalCodeInputBox.sendKeys("08247 Vilnius Vilnius City Municipality, Lithuania");
        Driver.wait(2);
        payBillsPage.findLocationPostalCodeInputBox.sendKeys(Keys.ARROW_DOWN);
        payBillsPage.findLocationPostalCodeInputBox.sendKeys(Keys.ENTER);
        Driver.wait(2);
        ReusableMethods.clickWithJS(payBillsPage.findLocationAgentButton);
        payBillsPage.findLocationAgentNameInputBox.sendKeys("TestAgent");
        Driver.wait(2);
    }
    @Then("User clicks on Open and get list of open agents below")
    public void user_clicks_on_open_and_get_list_of_open_agents_below() {
        ReusableMethods.clickWithJS(payBillsPage.findLocationFilterOpenButton);
        Driver.wait(5);
        //ReusableMethods.waitForVisibility(payBillsPage.firstAgentLocatioOnList, Duration.ofSeconds(10));
    }
    @Then("User prints the first open agent details on the list")
    public void user_prints_the_first_open_agent_details_on_the_list() {
        String agentDetails = payBillsPage.firstAgentLocatioOnList.getText() + "\n" +
                payBillsPage.firstAgentLocationStatus.getText() + "\n" +
                payBillsPage.firstAgentLocationAdressCity.getText() + "\n" +
                payBillsPage.firstAgentLocatioPostalCode.getText();
        System.out.println("First open agent details: " + agentDetails);
    }

}
