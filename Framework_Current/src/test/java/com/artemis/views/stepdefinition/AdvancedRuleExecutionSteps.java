package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.AdvancedRuleExecutionPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdvancedRuleExecutionSteps {
	private final static Logger Log = Logger.getLogger(AdvancedRuleExecutionSteps.class.getName());

	private WebDriver itsDriver;
	private AdvancedRuleExecutionPageObject advRuleExecutionPage;

	public AdvancedRuleExecutionSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		advRuleExecutionPage = PageFactory.initElements(itsDriver, AdvancedRuleExecutionPageObject.class);
	}

	@Then("^Verify \"([^\"]*)\" field is displayeds$")
	public void verify_Search_Field_Is_Diplayed(String searchText) {
		advRuleExecutionPage.verifySearchFiledDisplayed(searchText);
	}

	@When("^Select \"([^\"]*)\" in \"([^\"]*)\" field in Group Management$")
	public void select_Option_In_Evaluation_Type_Field(String option, String fieldName) {
		advRuleExecutionPage.selectOptionEvaluationType(option, fieldName);
	}

	@When("^Click on Delete button in the assigned rule header$")
	public void click_On_Delete_Dataset_Button_In_Header() {
		advRuleExecutionPage.clickDeleteButtonHeader();
	}

	@When("^Click on Delete button in the group management header$")
	public void click_On_Delete_Dataset_Button_In_Group_Management_Header() {
		advRuleExecutionPage.clickDeleteButtonGroupManagementHeader();
	}

	@When("^Verify status \"([^\"]*)\" is shown for \"([^\"]*)\" group name$")
	public void verify_Group_Status_Visible(String status, String groupName) {
		advRuleExecutionPage.verifyGroupStatus(status, groupName);
	}

	@When("^Click on Save button in Assigned Rules Group Collection Management$")
	public void click_Save_Button_For_Assigned_Rules() {
		advRuleExecutionPage.clickSaveButtonAssignedRules();
	}

	@When("^Select \"([^\"]*)\" in \"([^\"]*)\" field overlay$")
	public void select_Option_In_Filed(String option, String fieldName) {
		advRuleExecutionPage.selectOption(option, fieldName);
	}

	@When("^Click on Add button in Assigned Groups Group Collection Management and \"([^\"]*)\" overlay appears$")
	public void click_Add_Button_For_Assigned_Rules(String overlayName) {
		advRuleExecutionPage.clickAddButtonAssignedGroups(overlayName);
	}

	@When("^Click on \"([^\"]*)\" button in popup overlay$")
	public void click_Save_Button_Group_Collection(String btnText) {
		advRuleExecutionPage.clickPopupButton(btnText);
	}

	@When("^Input \"([^\"]*)\" in overlay comments textarea$")
	public void input_Comments_In_Textarea(String commnets) {
		advRuleExecutionPage.inputCommnets(commnets);
	}

	@When("^Delete the group name \"([^\"]*)\" if it is displayed$")
	public void delete_Group_Name_If_Displayed_Under_Group_Management(String grpName) {
		advRuleExecutionPage.deleteGroupNameGroupName(grpName);
	}

	@When("^Delete the group name \"([^\"]*)\" if it is displayed in group collection$")
	public void delete_Group_Name_If_Displayed_Under_Group_Collection(String grpName) {
		advRuleExecutionPage.deleteGroupNameGroup(grpName);
	}
}