package com.artemis.views.stepdefinition;

import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.GroupCollectionManagementPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GroupCollectionManagementSteps {
	private final static Logger Log = Logger.getLogger(GroupCollectionManagementSteps.class.getName());

	private WebDriver itsDriver;
	private GroupCollectionManagementPageObject groupCollectionPage;

	public GroupCollectionManagementSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		groupCollectionPage = PageFactory.initElements(itsDriver, GroupCollectionManagementPageObject.class);
	}

	@Then("^Verify \"([^\"]*)\" panel header is displayed$")
	public void verify_Panel_Header_Diplayed(String panelHeader) {
		groupCollectionPage.verifyPanelHeader(panelHeader);
	}

	@When("^Click on Add button in Group Collection Management$")
	public void click_Add_Button_For_Group_Collectinon() {
		groupCollectionPage.clickAddButtonGroupCollection();
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void input_Data_In_Group_Collection(String inputData, String fieldName) {
		groupCollectionPage.inputDataGroupCollection(inputData, fieldName);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" textarea$")
	public void input_Data_In_Textarea_Group_Collection(String inputData, String fieldName) {
		groupCollectionPage.inputDataTextareaGroupCollection(inputData, fieldName);
	}

	@When("^Check Active checkbox$")
	public void check_Active_Checkbox() throws TimeoutException {
		groupCollectionPage.checkActiveCheckbox();
	}

	@When("^Check Active checkbox in rule details$")
	public void check_Active_Checkbox_In_Rule_Details() {
		groupCollectionPage.checkActiveCheckboxRuleDetails();
	}

	@When("^Click on \"([^\"]*)\" button in Group Collection$")
	public void click_Save_Button_Group_Collection(String btnText) {
		groupCollectionPage.clickSaveButton(btnText);
	}

	@Then("^Verify \"([^\"]*)\" is visible in group list$")
	public void verify_Added_Group_Visible_In_List(String groupName) {
		groupCollectionPage.verifyGroupNameVisible(groupName);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" field in Group Management$")
	public void input_Data_In_Group_Management(String inputData, String fieldName) throws TimeoutException {
		groupCollectionPage.inputDataGroupManagement(inputData, fieldName);
	}

	@When("^Select \"([^\"]*)\" in Evaluation Type field$")
	public void select_Option_In_Evaluation_Type_Field(String option) throws InterruptedException {
		groupCollectionPage.selectOptionEvaluationType(option);
	}

	@When("^Select \"([^\"]*)\" in Type field$")
	public void select_Option_In_Type_Field(String option) {
		groupCollectionPage.selectOptionType(option);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" textarea in Group Management$")
	public void input_Data_In_Group_Management_Textarea(String inputData, String fieldName) {
		groupCollectionPage.inputDataGroupManagementTextarea(inputData, fieldName);
	}

	@When("^Select \"([^\"]*)\" in \"([^\"]*)\" field in Search page$")
	public void select_Option_In_Type_Field_In_Search_Page(String option, String fieldName) {
		groupCollectionPage.selectOptionTypeSearchPage(option, fieldName);
	}

	@When("^Click on \"([^\"]*)\" button in Search page$")
	public void click_On_Search_Button_In_Search_Page(String btnText) {
		groupCollectionPage.clickSearchButton(btnText);
	}

	@When("^Verify existing Rules are displayed$")
	public void verify_Existing_Rules_Displayed() {
		groupCollectionPage.verifyExistingRulesDisplayed();
	}

	@When("^Click on \"([^\"]*)\" group name$")
	public void click_On_Group_Name_Under_Group_Management(String grpName) {
		groupCollectionPage.clickGroupName(grpName);
	}

	@When("^Click on Edit button in Group Management page$")
	public void click_On_Edit_Button_Under_Group_Management() {
		groupCollectionPage.clickEditButtonGroupName();
	}

	@When("^Verify \"([^\"]*)\" tab is visible$")
	public void verify_Tab_Text_Diaplayed(String tabText) {
		groupCollectionPage.verifyTabTextDisplayed(tabText);
	}

	@When("^Click on \"([^\"]*)\" button in Group Collection page$")
	public void click_Save_Button_Group_Collection_Page(String btnText) throws TimeoutException {
		groupCollectionPage.clickOnButton(btnText);
	}
}