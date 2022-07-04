package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.ManageBcrPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageBcrSD {
	private final static Logger Log = Logger.getLogger(ManageBcrSD.class.getName());

	private WebDriver itsDriver;
	private ManageBcrPageObject manageBcrPage;

	public ManageBcrSD() {
		Log.info("Constructor: ManageBCRStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		manageBcrPage = PageFactory.initElements(itsDriver, ManageBcrPageObject.class);
	}

	@Given("^user navigates to application URL : \"([^\"]*)\" application$")
	public void openAppUrl(String url) {
		manageBcrPage.openAppUrl(url);
	}

	@Given("^That I am on Savvion login page$")
	public void verifyLoginPageOpened() {
		manageBcrPage.verifyLoginPageOpened();
	}

	@When("^I login using \"([^\"]*)\" as username \"([^\"]*)\" as password and \"([^\"]*)\" as DataSet$")
	public void loginUsingCredentials(String userName, String password, String dataset) {

		manageBcrPage.loginUsingCredentials(userName, password, dataset);
	}

	@Then("^I should see Manage BCR page displayed$")
	public void verifyLoggedIn() {
		manageBcrPage.verifyLoggedIn();
	}

	@When("^I click on \"([^\"]*)\" button on Manage BCR page$")
	public void clickParticularButtonOnManageBCRPage(String buttonName) {
		manageBcrPage.clickParticularButtonOnManageBCRPage(buttonName);
	}

	@When("^I click on \"([^\"]*)\" button on Manage BCR page again$")
	public void reconfirmOk(String buttonName) {
		manageBcrPage.reconfirmOk(buttonName);
	}

	@Then("^I should see \"([^\"]*)\" window displayed$")
	public void verifyWindowOpened(String windowName) {
		manageBcrPage.verifyWindowOpened(windowName);
	}

	@When("^I select \"([^\"]*)\" with \"([^\"]*)\" value from drop down list$")
	public void selectValueFromDropDown(String dropDownName, String value) {
		manageBcrPage.selectValueFromDropDown(dropDownName, value);
	}

	@When("^I put \"([^\"]*)\" value in category text field$")
	public void inputCategoryValye(String value) {
		manageBcrPage.inputCategoryValue(value);
	}

	@Then("^I should see confirmation window$")
	public void verifyConfirmationPopUp() {
		manageBcrPage.verifyConfirmationPopUp();
	}

	@Then("^I should see BCR tasks window displayed$")
	public void verifyBCRTaskWindowOpen() {
		manageBcrPage.verifyBCRTaskWindowOpen();
	}

	@Then("^I should see log out happened successfully$")
	public void verifyLogout() {
		manageBcrPage.verifyLogOut();
	}

	@Then("^I should see \"([^\"]*)\" BCR listed on BCR Tasks page$")
	public void verifyBcrListed(String bcrId) {
		manageBcrPage.verifyBcrListed(bcrId);
	}

	@When("^I click on Intiate BCR request hyperlink for \"([^\"]*)\" BCR$")
	public void clickInitializeBcrLink(String bcrId) {
		manageBcrPage.clickInitializeBcrLink(bcrId);
	}

	@Then("^I should see \"([^\"]*)\" section displayed on My Tasks page$")
	public void verifySectionDisplayed(String sectionName) {
		manageBcrPage.verifySectionDisplayed(sectionName);
	}

	@When("^I expand \"([^\"]*)\" segment on My Tasks page for \"([^\"]*)\"$")
	public void expandSegment(String segmentName, String bcrId) {
		manageBcrPage.expandSegment(segmentName, bcrId);
	}

	@When("^I fill \"([^\"]*)\" for Replan Cost Type$")
	public void enterReplanCostType(String replanCostType) {
		manageBcrPage.enterReplanCostType(replanCostType);
	}

	@When("^I fill \"([^\"]*)\" for Actual Cost Type$")
	public void enterActualCostType(String actualCostType) {
		manageBcrPage.enterActualCostType(actualCostType);
	}

	@When("^I fill \"([^\"]*)\" for New Plan Cost Type$")
	public void enterNewPlanCostType(String newPlanCostType) {
		manageBcrPage.enterNewPlanCostType(newPlanCostType);
	}

	@When("^I fill \"([^\"]*)\" for Earned Cost Type$")
	public void enterEanrnedCostType(String earnedCostType) {
		manageBcrPage.enterEarnedCostType(earnedCostType);
	}

	@When("^I select \"([^\"]*)\" in type field on MyTasks page for \"([^\"]*)\"$")
	public void selectTypeField(String selectValue, String bcrId) {
		manageBcrPage.selectTypeField(selectValue,bcrId);
	}

	@When("^I click on \"([^\"]*)\" button on My Tasks page$")
	public void clickParticularButtonOnMyTaskPage(String buttonName) {
		manageBcrPage.clickParticularButtonOnMyTaskPage(buttonName);
	}

	@When("^I click on Approve BCR request hyperlink for \"([^\"]*)\" BCR$")
	public void clickApproveBcr(String bcrId) {
		manageBcrPage.clickApproveBcrLink(bcrId);
	}

	@When("^I enter \"([^\"]*)\" as comment in given dialog box$")
	public void enterCommentForRejection(String comment) {
		manageBcrPage.enterCommentForRejection(comment);
	}
}