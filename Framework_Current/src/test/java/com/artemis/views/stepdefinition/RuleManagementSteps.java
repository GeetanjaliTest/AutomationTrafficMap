package com.artemis.views.stepdefinition;

import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.RuleManagementPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RuleManagementSteps {
	private final static Logger Log = Logger.getLogger(RuleManagementSteps.class.getName());

	private WebDriver itsDriver;
	private RuleManagementPageObject ruleManagemntPage;

	public RuleManagementSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		ruleManagemntPage = PageFactory.initElements(itsDriver, RuleManagementPageObject.class);
	}

	@Then("^Verify \"([^\"]*)\" page is displayed$")
	public void verify_Page_Header_Diplayed(String pagelHeader) {
		ruleManagemntPage.verifyPageHeader(pagelHeader);
	}

	@When("^Click on \"([^\"]*)\" button$")
	public void click_Add_Button(String btnText) {
		ruleManagemntPage.clickAddButton(btnText);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" field in Rule Management$")
	public void input_Data_In_Group_Management(String inputData, String fieldName) throws TimeoutException {
		ruleManagemntPage.inputDataRuleManagement(inputData, fieldName);
	}

	@When("^Select \"([^\"]*)\" as \"([^\"]*)\"$")
	public void select_Threshold_Type_In_Rule_Details_Overlay(String option, String fieldName) {
		ruleManagemntPage.selectOptionThreshold(option, fieldName);
	}

	@When("^Input \"([^\"]*)\" in Formula Details textarea$")
	public void input_Data_In_Formula_Details(String inputData) {
		ruleManagemntPage.inputDataFormulaDetails(inputData);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" query textarea$")
	public void input_Query_In_Textarea(String inputData, String formulaName) {
		ruleManagemntPage.inputQuery(inputData, formulaName);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" description textarea$")
	public void input_Description_In_Textarea(String inputData, String formulaName) {
		ruleManagemntPage.inputDescription(inputData, formulaName);
	}

	@Then("^Verify query \"([^\"]*)\" is displayed$")
	public void verify_Query_Displayed(String query) {
		ruleManagemntPage.verifyQueryVisibility(query);
	}

	@When("^Click on \"([^\"]*)\" button in Formula Details$")
	public void click_button_Formula_Details(String btnText) {
		ruleManagemntPage.clickButton(btnText);
	}

	@When("^Uncheck Active checkbox$")
	public void uncheck_Active_Checkbox() {
		ruleManagemntPage.uncheckActiveCheckbox();
	}

	@When("^Click on Edit button in the header$")
	public void click_Edit_Button_For_Group_Collectinon() {
		ruleManagemntPage.clickEditButtonGroupCollection();
	}

	@When("^Click on Add button in Assigned Rules Group Collection Management$")
	public void click_Add_Button_For_Assigned_Rules() {
		ruleManagemntPage.clickAddButtonAssignedRules();
	}

	@When("^Select \"([^\"]*)\" in \"([^\"]*)\" field in Rules page$")
	public void select_Option_In_Type_Field_In_Rules_Search_Page(String option, String fieldName) {
		ruleManagemntPage.selectOptionTypeSearchPage(option, fieldName);
	}

	@Then("^Verify \"([^\"]*)\" is not displayed in result list$")
	public void verify_Rule_Name_Visibility(String ruleName) {
		ruleManagemntPage.verifyRuleVisibility(ruleName);
	}

	@When("^Click on \"([^\"]*)\" button in Rules overlay$")
	public void click_Save_Button_Group_Collection(String btnText) {
		ruleManagemntPage.clickCancelButton(btnText);
	}

	@Then("^Verify \"([^\"]*)\" page is displayed in overlay$")
	public void verify_Overlay_Header_Diplayed(String pagelHeader) {
		ruleManagemntPage.verifyOverlayHeader(pagelHeader);
	}

	@Then("^Verify Are you sure you want to delete the selected Rule \"([^\"]*)\" is visible in the popup$")
	public void verify_Popup_Text_For_Text(String popText) {
		ruleManagemntPage.verifyPopupText(popText);
	}

	@When("^Click on \"([^\"]*)\" button in popup$")
	public void click_On_Button_In_Popup(String btnText) {
		ruleManagemntPage.clickButtonPopup(btnText);
	}

	@Then("^Verify \"([^\"]*)\" Portal is closed in rules overlay$")
	public void verify_Overlay_Visibility(String headerText) {
		ruleManagemntPage.verifyOverlayVisibility(headerText);
	}
}