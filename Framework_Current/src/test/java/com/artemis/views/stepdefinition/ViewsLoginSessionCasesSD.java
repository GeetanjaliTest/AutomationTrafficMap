package com.artemis.views.stepdefinition;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.ViewsLoginSessionPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewsLoginSessionCasesSD {
	private final static Logger Log = Logger.getLogger(ViewsLoginSessionCasesSD.class.getName());

	private WebDriver itsDriver;
	private ViewsLoginSessionPageObject viewsLoginSessionPage;

	public ViewsLoginSessionCasesSD() {
		Log.info("Constructor: ViewsPortalRegressionStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		viewsLoginSessionPage = PageFactory.initElements(itsDriver, ViewsLoginSessionPageObject.class);
	}

	@When("^I open a new tab and hit \"([^\"]*)\" url$")
	public void openTabWithUrl(String url) {
		viewsLoginSessionPage.openTabWithUrl(url);
	}

	@When("^I switch back to first tab$")
	public void switchBackToFirstTab() {
		viewsLoginSessionPage.switchBackToFirstTab();
	}

	@When("^I switch back to second tab$")
	public void switchBackToSecondTab() {
		viewsLoginSessionPage.switchBackToSecondTab();
	}

	@When("^I click on Administration Menu$")
	public void clickAdministrationMenu() {
		viewsLoginSessionPage.clickAdministrationMenu();
	}

	@Then("^I should see default login page displayed as redirection$")
	public void verifyLoginPageOpened() {
		viewsLoginSessionPage.verifyLoginPageOpened();
	}

	@When("^I close first tab opened earlier$")
	public void closeFirstTab() {
		viewsLoginSessionPage.closeFirstTab();
	}

	@When("^I open a new browser and hit \"([^\"]*)\" url$")
	public void openBrowserWithUrl(String url) throws MalformedURLException, ScumberException {
		viewsLoginSessionPage.openBrowserWithUrl(url);
	}

	@When("^I login using \"([^\"]*)\" as username \"([^\"]*)\" as password and \"([^\"]*)\" as DataSet for views portal in new browser$")
	public void loginViewsPortalUsingCredentials(String userName, String password, String dataset) {
		viewsLoginSessionPage.loginViewsPortalUsingCredentials(userName, password, dataset);
	}

	@When("^Click on \"([^\"]*)\" from left side menu panel in new browser$")
	public void click_Option_From_Left_Side_Menu_Panel(String panelOption) {
		viewsLoginSessionPage.clickOptionPanel(panelOption);
	}

	@When("^Click on \"([^\"]*)\" from left side menu panel under option in new browser$")
	public void click_Option_From_Left_Side_Menu_Panel_Rule_Execution(String option) {
		viewsLoginSessionPage.clickOptionRuleExecution(option);
	}

	@Then("^Verify \"([^\"]*)\" page is opened for \"([^\"]*)\" option in new browser$")
	public void verify_Page_For_Basic_Option(String pageHeaderText, String option) {
		viewsLoginSessionPage.verifyPageDisplayed(pageHeaderText, option);
	}

	@When("^Click on \"([^\"]*)\" option in new browser$")
	public void click_on_An_option(String profileOption) {
		viewsLoginSessionPage.chooseOption(profileOption);
	}

	@Then("^Verify \"([^\"]*)\" window is closed in new browser$")
	public void verify_Page_Disappeared(String pageHeader) {
		viewsLoginSessionPage.verifyHomePageVisibility(pageHeader);
	}

	@Then("^Verify Login is successful and \"([^\"]*)\" Page is displayed in new browser$")
	public void verify_login_is_successful_and_something_page_is_displayed(String headerText) {
		viewsLoginSessionPage.verifyLoginSuccessfull(headerText);
	}

	@When("^Close the new broswer$")
	public void close_The_New_Broswer() {
		viewsLoginSessionPage.closeNewBrowser();
	}
}