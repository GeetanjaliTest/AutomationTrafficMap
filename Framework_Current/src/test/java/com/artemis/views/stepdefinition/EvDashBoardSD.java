package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.EvDashBoardPageObject;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EvDashBoardSD {
	private final static Logger Log = Logger.getLogger(EvDashBoardSD.class.getName());

	private WebDriver itsDriver;
	private EvDashBoardPageObject evDashBoardPage;

	public EvDashBoardSD() {
		Log.info("Constructor: EvDashBoardStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		evDashBoardPage = PageFactory.initElements(itsDriver, EvDashBoardPageObject.class);
	}

	@Given("^I am on Views Login Page$")
	public void verifyLoginPageOpen() {
		evDashBoardPage.verifyLoginPageOpen();
	}

	@When("^I login using \"([^\"]*)\" as username \"([^\"]*)\" as password and \"([^\"]*)\" as DataSet for views portal$")
	public void loginViewsPortalUsingCredentials(String userName, String password, String dataset) {
		evDashBoardPage.loginViewsPortalUsingCredentials(userName, password, dataset);
	}

	@Then("^I should see Verify Business Rule Checker Window displayed$")
	public void verifyBusinessRuleCheckerWindowDisplayed() {
		evDashBoardPage.verifyBusinessRuleCheckerWindowDisplayed();
	}

	@When("^I click on Business Rule Checker drop down and select \"([^\"]*)\" option listed with url \"([^\"]*)\"$")
	public void selectOptionFromBusinessRulecheckerDropDown(String optionName, String url) {
		evDashBoardPage.selectOptionFromBusinessRulecheckerDropDown(optionName, url);
	}

	@Then("^I should see \"([^\"]*)\" window open$")
	public void verifyWindowOpen(String windowName) {
		evDashBoardPage.verifyWindowOpen(windowName);
	}

	@When("^I select \"([^\"]*)\" for \"([^\"]*)\" drop down list$")
	public void selectDropDownWithValue(String value, String dropDownOption) {
		evDashBoardPage.selectDropDownWithValue(value, dropDownOption);
	}

	@When("^I type \"([^\"]*)\" as time value for POP time window field$")
	public void inputTypeValue(String timeValue) {
		evDashBoardPage.inputTypeValue(timeValue);
	}

	@When("^I click on \"([^\"]*)\" button for Views Dashboard Window$")
	public void clickPartcularButtonOnViewsDashBoard(String buttonName) {
		evDashBoardPage.clickPartcularButtonOnViewsDashBoard(buttonName);
	}

	@Then("^I should see Master Window displayed$")
	public void verifyMasterWindowOpen() {
		evDashBoardPage.verifyMasterWindowOpen();
	}

	@When("^I click on arrow widget on Master Window$")
	public void openSearchOptionsWidget() {
		evDashBoardPage.openSearchOptionsWidget();
	}

	@Then("^I should see search options displayed$")
	public void verifySearchOptionsDisplayed() {
		evDashBoardPage.verifySearchOptionsDisplayed();
	}

	@Then("^I should see Master Widget as empty$")
	public void verifyMasterWidgetEmpty() {
		evDashBoardPage.verifyMasterWidgetEmpty();
	}

	@When("^I logout of Views Portal$")
	public void logOutViewsPortal() {
		evDashBoardPage.logOutViewsPortal();
	}

	@Then("^I should see default login page displayed$")
	public void verifyDefaultLogout() {
		evDashBoardPage.verifyDefaultLogout();
	}

	@Then("^I should see drop down menus <menuItem> in ascending order$")
	public void verifyDropDownMenuList(DataTable menuItemList) {
		evDashBoardPage.verifyDropDownMenuList(menuItemList);
	}

	@When("^I click on \"([^\"]*)\" menu listed under Business Rule Checker drop down$")
	public void clickMenuUnderBusinessRuleCheckerDropDown(String menuItem) {
		evDashBoardPage.clickMenuUnderBusinessRuleCheckerDropDown(menuItem);
	}

	@When("^I click on Business Rule Checker drop down$")
	public void clickBusinessRulecheckerDropDown() {
		evDashBoardPage.clickBusinessRulecheckerDropDown();
	}

	@When("^I click on Dashboards drop down$")
	public void clickDashboardsDropDown() {
		evDashBoardPage.clickDashboardsDropDown();
	}

	@When("^I click on User Audit drop down$")
	public void clickUserAuditDropDown() {
		evDashBoardPage.clickUserAuditDropDown();
	}

	@Then("^I should see rest of the mandatory fields being highlighted in red to be filled$")
	public void verifyMandatoryFieldsHighlighted() {
		evDashBoardPage.verifyMandatoryFieldsHighlighted();
	}

	@When("^Select \"([^\"]*)\" option for \"([^\"]*)\" field$")
	public void select_Option_In_Search_Field(String option, String fieldName) {
		evDashBoardPage.selectOptionInSearchField(option, fieldName);
	}
}