package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.BaselineChangeRequestPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BaselineChangeRequestSteps {
	private final static Logger Log = Logger.getLogger(BaselineChangeRequestSteps.class.getName());

	private WebDriver itsDriver;
	private BaselineChangeRequestPageObject bCRPage;

	public BaselineChangeRequestSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		bCRPage = PageFactory.initElements(itsDriver, BaselineChangeRequestPageObject.class);
	}

	@When("^Enter Username \"([^\"]*)\" and Password \"([^\"]*)\" and Dataset \"([^\"]*)\" in Savvion login panel$")
	public void input_Username_Password_Dataset_In_Savvion_Login_Page(String username, String password,
			String dataset) {
		bCRPage.inputCredSavLoginPage(username, password, dataset);
	}

	@And("^Click on Login Button in Savvion login panel$")
	public void click_on_login_button() throws Throwable {
		bCRPage.clickLoginButton();
	}

	@Then("^Verify Login is successful and \"([^\"]*)\" Page is displayed in Savvion$")
	public void verify_login_is_successful_and_something_page_is_displayed(String tabText) {
		bCRPage.verifyLoginSuccessfull(tabText);
	}

	@When("^Click on \"([^\"]*)\" tab from header menu$")
	public void click_Option_From_Header(String option) {
		bCRPage.clickHeaderMenu(option);
	}

	@Then("^Verify \"([^\"]*)\" page is opened$")
	public void verify_Page_Visibility(String pageText) {
		bCRPage.verifyPageVisibility(pageText);
	}

	@When("^Click on \"([^\"]*)\" option of the savvion portal$")
	public void click_on_Logout_option(String optionText) {
		bCRPage.chooseLogoutOption(optionText);
	}

	@When("^Verify Logout is successful$")
	public void verify_Page_Disappeared() {
		bCRPage.verifyHomePageVisibility();
	}

	@When("^Click on \"([^\"]*)\" button in Views Process Management Page$")
	public void verify_Page_Disappeared(String btnText) throws InterruptedException {
		bCRPage.clickBcrButton(btnText);
	}

	@When("^Verify \"([^\"]*)\" overlay is displayed$")
	public void verify_Overlay_Displayed(String overlayHeader) {
		bCRPage.verifyOverlayText(overlayHeader);
	}

	@When("^Select \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void select_Value_In_Create_Bcr(String fieldValue, String labelName) throws InterruptedException {
		bCRPage.selectValueCreateBcr(fieldValue, labelName);
	}

	@When("^Input \"([^\"]*)\" in \"([^\"]*)\" field in BCR$")
	public void input_Value_In_Create_Bcr(String fieldValue, String labelName) throws InterruptedException {
		bCRPage.inputValueCreateBcr(fieldValue, labelName);
	}

	@When("^Verify \"([^\"]*)\" is selected in \"([^\"]*)\" field$")
	public void verify_Value_Selected_In_Field(String fieldValue, String labelName) {
		bCRPage.verifyValueSelectedCreateBcr(fieldValue, labelName);
	}

	@When("^Click on \"([^\"]*)\" button in BCR overlay$")
	public void click_Create_Button_In_BCR_Overlay(String btnText) {
		bCRPage.clickButtonCreateBcr(btnText);
	}

	@When("^Verify \"([^\"]*)\" window overlay is displayed$")
	public void verify_Window_Overlay_Text(String overlayText) {
		bCRPage.verifyOverlayTextConfirmBcr(overlayText);
	}

	@When("^Verify \"([^\"]*)\" overlay page is displayed$")
	public void verify_Page_Text(String overlayText) {
		bCRPage.verifyPageTextBcr(overlayText);
	}

	@When("^Click on \"([^\"]*)\" button in BCR overlay confirm$")
	public void click_Create_Button_In_BCR_Overlay_Confirm(String btnText) {
		bCRPage.clickButtonCreateBcrConfirm(btnText);
	}

	@When("^Verify \"([^\"]*)\" is visible under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void verify_Task_Visible_For_BCR(String task, String traceID, String projectName) {
		bCRPage.verifyBCRTask(task, traceID, projectName);
	}

	@When("^Click \"([^\"]*)\" under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void click_On_Task_In_BCR(String task, String traceID, String projectName) {
		bCRPage.clickBCRTask(task, traceID, projectName);
	}

	@Then("^Verify \"([^\"]*)\" panel overlay is displayed$")
	public void verify_Panel_Overlay_Text(String overlayText) {
		bCRPage.verifyOverlayTextDisplayed(overlayText);
	}

	@When("^Expand \"([^\"]*)\" section$")
	public void expand_Overlay_Section(String overlayText) {
		bCRPage.expandOverlay(overlayText);
	}

	@When("^Verify \"([^\"]*)\" message is shown$")
	public void verify_Success_Mesage_Shown(String sucMsg) {
		bCRPage.verifySuccessMesage(sucMsg);
	}

	@When("^Verify \"([^\"]*)\" tab option is displayed$")
	public void verify_Tab_Option_Text(String overlayText) {
		bCRPage.verifyOverlayTabDisplayed(overlayText);
	}

	@When("^Verify \"([^\"]*)\" is selected in \"([^\"]*)\" field value$")
	public void verify_Value_Selected_In_Field_Value(String fieldValue, String labelName) {
		bCRPage.verifyValueSelectedBcrTasks(fieldValue, labelName);
	}

	@When("^Click on \"([^\"]*)\" button in BCR Tasks$")
	public void click_Create_Button_In_BCR_Tasks(String btnText) {
		bCRPage.clickButtonCreateBcrTasks(btnText);
	}

	@When("^Verify \"([^\"]*)\" window bcr overlay is displayed$")
	public void verify_Window_Bcr_Overlay_Text(String overlayText) {
		bCRPage.verifyTextConfirmBcr(overlayText);
	}

	@Then("^Verify status \"([^\"]*)\" is showing for \"([^\"]*)\" trace id$")
	public void verify_Status_For_Trace_Id(String status, String bcrIndex) {
		bCRPage.verifyBcrStatus(status, bcrIndex);
	}

	@When("^Select first option from \"([^\"]*)\" field in BCR$")
	public void select_First_Option_In_Create_Bcr(String labelName) {
		bCRPage.selectFirstOptionInCreateBcr(labelName);
	}

	@When("^Store the selected dropdown option for \"([^\"]*)\" field$")
	public void store_Selected_Trace_ID_In_Create_Bcr(String labelName) {
		bCRPage.storeTraceIdInCreateBcr(labelName);
	}

	@When("^Validate \"([^\"]*)\" is visible under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void validate_Task_Visible_For_BCR(String task, String bcrIndex, String projectName) {
		bCRPage.validateBCRTaskDisplayed(task, bcrIndex, projectName);
	}

	@When("^Click on \"([^\"]*)\" under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void click_On_The_Task_In_BCR(String task, String bcrIndex, String projectName) {
		bCRPage.clickOnBCRTask(task, bcrIndex, projectName);
	}

	@When("^Select \"([^\"]*)\" option value in \"([^\"]*)\" field$")
	public void select_Option_In_Create_Bcr(String fieldValue, String labelName) {
		bCRPage.selectOptionCreateBcr(fieldValue, labelName);
	}

	@When("^Store the selected option for \"([^\"]*)\" field$")
	public void store_Selected_Trace_ID_Option_In_Create_Bcr(String labelName) {
		bCRPage.storeSelectedTraceIdInCreateBcr(labelName);
	}

	@When("^Store the selected option from dropdown for \"([^\"]*)\" field$")
	public void store_Selected_Trace_ID_Dropdown_Option_In_Create_Bcr_Field(String labelName) {
		bCRPage.storeSelectedTraceIdInCreateBcrField(labelName);
	}

	@When("^Store the selected option from dropdown for \"([^\"]*)\" field value$")
	public void store_Selected_Trace_ID_Dropdown_Option_In_Create_Bcr_Field_Value(String labelName) {
		bCRPage.storeSelectedTraceIdInCreateBcrFieldValue(labelName);
	}

	@When("^Validate the \"([^\"]*)\" is visible under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void validate_The_Task_Visible_For_BCR(String task, String bcrIndex, String projectName) {
		bCRPage.validateBCRTaskVisibility(task, bcrIndex, projectName);
	}

	@When("^Click on the \"([^\"]*)\" under Trace ID \"([^\"]*)\" and project \"([^\"]*)\"$")
	public void click_On_Task_BCR_ID(String task, String bcrIndex, String projectName) {
		bCRPage.clickOnVisibleBCRTask(task, bcrIndex, projectName);
	}

	@Then("^Verify the status \"([^\"]*)\" is showing for \"([^\"]*)\" trace id$")
	public void verify_The_Status_For_Trace_Id(String status, String bcrIndex) {
		bCRPage.verifyBcrStatusPM(status, bcrIndex);
	}

	@Then("^Verify the status \"([^\"]*)\" is showing for \"([^\"]*)\" trace id for PM$")
	public void verify_The_Status_For_Trace_Id_PM(String status, String bcrIndex) {
		bCRPage.verifyBcrStatusForPM(status, bcrIndex);
	}

	@Then("^Validate the status \"([^\"]*)\" is showing for \"([^\"]*)\" trace id for PM$")
	public void validate_The_Status_For_Trace_Id_PM(String status, String bcrIndex) {
		bCRPage.validateBcrStatusForPM(status, bcrIndex);
	}
}