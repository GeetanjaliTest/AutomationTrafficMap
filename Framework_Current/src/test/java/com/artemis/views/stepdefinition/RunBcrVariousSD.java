package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.RunBcrVariousPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RunBcrVariousSD {
	private final static Logger Log = Logger.getLogger(RunBcrVariousSD.class.getName());

	private WebDriver itsDriver;
	private RunBcrVariousPageObject runBcrPage;

	public RunBcrVariousSD() {
		Log.info("Constructor: RunBcrVariousSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		runBcrPage = PageFactory.initElements(itsDriver, RunBcrVariousPageObject.class);
	}
	
	@When("^I click on \"([^\"]*)\" under Administration Menu on default landing page$")
	public void clickMenuUnderAdministration(String menuName) {
		runBcrPage.clickMenuUnderAdministration(menuName);
	}
	
	@Then("^I should see \"([^\"]*)\" panel displayed on Admin Segment$")
	public void verifyPanelDisplayed(String panelName) {
		runBcrPage.verifyPanelDisplayed(panelName);
	}
	
	@When("^I click on Disabled button to make it Enabled$")
	public void clickDisabledButton(){
		runBcrPage.clickDisabledButton(); 
	}

	@When("^I open a New Browser Tab for logging into Savvion Portal$")
	public void openNewBrowserTab(){
		runBcrPage.openNewBrowserTab();
	}

	@Then("^I should see \"([^\"]*)\" window$")
	public void verifyWindowOpened(String windowName){
		runBcrPage.verifyWindowOpened(windowName);  
	}

	@When("^I click on \"([^\"]*)\" button for Business Rule Check Failed window$")
	public void clickButtonOnBcrCheckFailPage(String buttonName){
		runBcrPage.clickButtonOnBcrCheckFailPage(buttonName);
	}

	@When("^I click on \"([^\"]*)\" button on Create BCR page$")
	public void clickButtonOnCreateBcrPage(String buttonName){
	    runBcrPage.clickButtonOnCreateBcrPage(buttonName);
	}
	
	@When("^I select \"([^\"]*)\" operation from list of operations$")
	public void selectOperationFromList(String operationName){
		runBcrPage.selectOperationFromList(operationName);
	}

	@When("^I click \"([^\"]*)\" button on operations list page$")
	public void clickButtonOnOperationsListPage(String buttonName){
		runBcrPage.clickButtonOnOperationsListPage(buttonName);
	}

	@When("^I click \"([^\"]*)\" button on Confirmation Window$")
	public void clickButtonOnConfirmationWindow(String buttonName){
		runBcrPage.clickButtonOnConfirmationWindow(buttonName);
	}
	
	@When("^I input \"([^\"]*)\" on Group Collection column of opened Edit operation$")
	public void inputGroupCollectionName(String groupCollectionName){
		runBcrPage.inputGroupCollectionName(groupCollectionName);
	}

	@When("^I select \"([^\"]*)\" for Enabled Column of opened Edit Operation$")
	public void selectEnabledOption(String optionValue){
		runBcrPage.selectEnabledOption(optionValue);
	}

	@Then("^I should see \"([^\"]*)\" for Group Collection and \"([^\"]*)\" for enabled column for \"([^\"]*)\" operation$")
	public void verifyVariousOperationValues(String groupCollectionValue, String enabledValue, String operationName){
		runBcrPage.verifyVariousOperationValues(groupCollectionValue,enabledValue,operationName);
	}

	@When("^Select \"([^\"]*)\" operation from list of operations$")
	public void select_Operation_From_List_Options(String operationName) {
		runBcrPage.selectOperationFromListOptions(operationName);
	}

	@When("^Verify \"([^\"]*)\" button is displayed$")
	public void verify_Enabled_Button_Is_Displayed(String buttonText) {
		runBcrPage.verifyEnabledButtonDisability(buttonText);
	}

	@When("^Click \"([^\"]*)\" button if it is \"([^\"]*)\"$")
	public void click_Enabled_Button_If_It_Is_Disabled(String buttonTextEnbl, String buttonTextDisbl) {
		runBcrPage.clickEnabledButton(buttonTextEnbl, buttonTextDisbl);
	}

	@When("^Select \"([^\"]*)\" on Group Collection column of opened Edit operation$")
	public void select_Group_In_Group_Collection_Column(String groupCollection) {
		runBcrPage.selectGroupInGroupCollectionColumn(groupCollection);
	}

	@When("^Select \"([^\"]*)\" for Enabled Column of opened Edit Operation$")
	public void select_Option_For_Enabled_Column(String enableOption) {
		runBcrPage.selectOptionEnabledColumn(enableOption);
	}

	@When("^Verify \"([^\"]*)\" for Group Collection and \"([^\"]*)\" for enabled column visible for \"([^\"]*)\" operation$")
	public void verify_Group_Collection_And_Enable_Option_visible_For_Operation(String groupCollection, String enabledStatus, String operation) {
		runBcrPage.verifyGroupCollectionUnderOperation(groupCollection, enabledStatus, operation);
	}

	@When("^Validate the \"([^\"]*)\" is displayed under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void validate_The_Task_Visible_For_BCR(String task, String bcrIndex, String projectName) {
		runBcrPage.validateBCRTaskVisibility(task, bcrIndex, projectName);
	}

	@When("^Click on the \"([^\"]*)\" under Trace ID \"([^\"]*)\" and project name \"([^\"]*)\"$")
	public void click_On_Task_BCR_ID(String task, String bcrIndex, String projectName) {
		runBcrPage.clickOnVisibleBCRTask(task, bcrIndex, projectName);
	}
}