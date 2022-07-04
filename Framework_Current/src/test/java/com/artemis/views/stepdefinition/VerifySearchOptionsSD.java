package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.VerifySearchOptionsPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifySearchOptionsSD {
	private final static Logger Log = Logger.getLogger(VerifySearchOptionsSD.class.getName());

	private WebDriver itsDriver;
	private VerifySearchOptionsPageObject verifySearchOptionsPage;

	public VerifySearchOptionsSD() {
		Log.info("Constructor: VerifySearchOptionsSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		verifySearchOptionsPage = PageFactory.initElements(itsDriver, VerifySearchOptionsPageObject.class);
	}

	@When("^I click on drop down for \"([^\"]*)\" field$")
	public void clickDropDownForField(String fieldName) {
		verifySearchOptionsPage.clickDropDownForField(fieldName);
	}

	@Then("^I should see \"([^\"]*)\" listed for \"([^\"]*)\" required field values$")
	public void verifyOptionsListedForRequiredField(String options, String fieldName) {
		verifySearchOptionsPage.verifyOptionsListedForRequiredField(options, fieldName);
	}

	@Then("^I should see \"([^\"]*)\" for POP time window value populated$")
	public void verifyPopTimeValuePopulated(String value) {
		verifySearchOptionsPage.verifyPopTimeValuePopulated(value);
	}

	@When("^I click \"([^\"]*)\" arrow on POP time window for \"([^\"]*)\" time$")
	public void clickParticularArrowOnPopTimeWindow(String arrowName, String hitCount) {
		verifySearchOptionsPage.clickParticularArrowOnPopTimeWindow(arrowName, hitCount);
	}

	@When("^I click down arrow for \"([^\"]*)\" optional field$")
	public void clickDropDownForOptionalField(String fieldName) {
		verifySearchOptionsPage.clickDropDownForOptionalField(fieldName);
	}

	@Then("^I should see \"([^\"]*)\" listed for \"([^\"]*)\" optional field values$")
	public void verifyListedOptionalFieldValues(String optionValues, String fieldName) {
		verifySearchOptionsPage.verifyListedOptionalFieldValues(optionValues, fieldName);
	}

	@When("^I select \"([^\"]*)\" value for \"([^\"]*)\" field$")
	public void selectValueForField(String value, String fieldName) {
		verifySearchOptionsPage.selectValueForField(value, fieldName);
	}
}