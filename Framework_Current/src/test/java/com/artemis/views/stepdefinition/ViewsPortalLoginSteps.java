package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.ViewsPortalLoginPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewsPortalLoginSteps {
	private final static Logger Log = Logger.getLogger(ViewsPortalLoginSteps.class.getName());

	private WebDriver itsDriver;
	private ViewsPortalLoginPageObject viewLogInPage;

	public ViewsPortalLoginSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		viewLogInPage = PageFactory.initElements(itsDriver, ViewsPortalLoginPageObject.class);
	}

	@Given("^user navigates to URL : \"([^\"]*)\" application$")
	public void navigateAdminUI(final String appURL) {
		itsDriver.get(appURL);
	}

	@When("^Verify Artemis Views Login page is displayed$")
	public void verify_Artemis_Login_Page_Is_Displayed() {
		viewLogInPage.verifyLogInPageDisplayed();
	}

	@When("^Enter Username \"([^\"]*)\" and Password \"([^\"]*)\" and Dataset \"([^\"]*)\" in login panel$")
	public void input_Username_Password_Dataset_In_Login_Page(String username, String password, String dataset) {
		viewLogInPage.inputCredLoginPage(username, password, dataset);
	}

	@And("^Click on Login Button$")
	public void click_on_login_button() throws Throwable {
		viewLogInPage.clickLoginButton();
	}

	@Then("^Verify Login is successful and \"([^\"]*)\" Page is displayed$")
	public void verify_login_is_successful_and_something_page_is_displayed(String headerText) {
		viewLogInPage.verifyLoginSuccessfull(headerText);
	}

	@When("^Click on \"([^\"]*)\" option$")
	public void click_on_An_option(String profileOption) {
		viewLogInPage.chooseOptionOption(profileOption);
	}

	@Then("^Verify \"([^\"]*)\" panel is displayed$")
	public void verify_First_Time_Login_Panel_Is_Displayed(String panelText) {
		viewLogInPage.verifyFirstTimeLoginPanelDisibility(panelText);
	}

	@When("^Enter Password \"([^\"]*)\" and Confirm Password \"([^\"]*)\" in first time login panel$")
	public void input_Username_Password_Dataset_In_Login_Page(String password, String confirmPassword) {
		viewLogInPage.inputCredFirstLoginPage(password, confirmPassword);
	}

	@And("^Click on Register Button$")
	public void click_on_Register_button() throws Throwable {
		viewLogInPage.clickRegisterButton();
	}

	@Then("^Verify First Time Login panel is closed and the Artemis Views Login page is displayed$")
	public void verify_first_time_login_panel_is_closed_and_the_artemis_views_login_page_is_displayed() {
		viewLogInPage.verifyLoginPanelVisibility();
	}

	@Then("^Verify \"([^\"]*)\" window is displayed$")
	public void verify_About_Views_Portal_Displayed(String portalHeaderText) {
		viewLogInPage.verifyAboutViewsPortalVisibility(portalHeaderText);
	}

	@When("^Click on OK button in About View Portal Window$")
	public void click_On_Ok_Button_In_Portal() {
		viewLogInPage.clickOKButtonPortal();
	}

	@Then("^Verify About Views Portal is closed$")
	public void verify_About_Views_Portal_Visibility() {
		viewLogInPage.verifyAboutViewsPortalVisibility();
	}

	@Then("^Click on \"([^\"]*)\" from left side menu panel$")
	public void click_Option_From_Left_Side_Menu_Panel(String panelOption) {
		viewLogInPage.clickOptionPanel(panelOption);
	}

	@Then("^Click on \"([^\"]*)\" from left side menu panel under option$")
	public void click_Option_From_Left_Side_Menu_Panel_Rule_Execution(String option) {
		viewLogInPage.clickOptionRuleExecution(option);
	}

	@Then("^Verify \"([^\"]*)\" page is opened for \"([^\"]*)\" option$")
	public void verify_Page_For_Basic_Option(String pageHeaderText, String option) {
		viewLogInPage.verifyPageDisplayed(pageHeaderText, option);
	}

	@Then("^Verify Invalid Username/Password option is displayed$")
	public void verify_Error_Message_Desplayed() {
		viewLogInPage.verifyErrorTextLoginPage();
	}

	@Then("^Click on \"([^\"]*)\" link in User Profile overlay$")
	public void click_Change_Password_Link_In_User_Profile_Overlay(String labelText) {
		viewLogInPage.clickChangePasswordLink(labelText);
	}

	@Then("^Verify \"([^\"]*)\" window is displayed in the dialog$")
	public void verify_Dialog_Displayed_In_User_Profile(String headerText) {
		viewLogInPage.verifyNameDisplayed(headerText);
	}

	@Then("^Put \"([^\"]*)\" in \"([^\"]*)\" under User Profile overlay$")
	public void put_Input_For_Password_Field(String password, String fieldName) {
		viewLogInPage.putPasswordUserProfile(password, fieldName);
	}

	@Then("^Click on OK Button inside the dialog change password$")
	public void click_OK_Button_In_User_Profile_Dialog_Chng_Passwd() {
		viewLogInPage.clickOkButtonChngPswd();
	}

	@Then("^Click on OK Button inside the dialog basic info$")
	public void click_OK_Button_In_User_Profile_Dialog_Basic_Info() {
		viewLogInPage.clickOkButtonBasicInfo();
	}

	@Then("^Verify \"([^\"]*)\" text is visible in the dialog$")
	public void click_Password_Change_Success_Message(String sucMsg) {
		viewLogInPage.verifyPsswdSucMsg(sucMsg);
	}

	@Then("^Verify \"([^\"]*)\" dialog is closed$")
	public void verify_Dialog_Visibility(String dialogName) {
		viewLogInPage.verifyPortalVisibility(dialogName);
	}
}
