package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.BasicRuleExecutionPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicRuleExecutionSteps {
	private final static Logger Log = Logger.getLogger(BasicRuleExecutionSteps.class.getName());

	private WebDriver itsDriver;
	private BasicRuleExecutionPageObject ruleExecutionPage;

	public BasicRuleExecutionSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		ruleExecutionPage = PageFactory.initElements(itsDriver, BasicRuleExecutionPageObject.class);
	}

	@Then("^Verify \"([^\"]*)\" field is displayed$")
	public void verify_Search_Field_Is_Diplayed(String searchText) {
		ruleExecutionPage.verifySearchFiledDisplayed(searchText);
	}

	@Then("^Verify Grid Search Field is active$")
	public void verify_Grid_Search_Field_Is_Active() {
		ruleExecutionPage.verifySearchFiledActive();
	}

	@When("^Input \"([^\"]*)\" in Grid Search box$")
	public void input_In_Grid_Search_Field(String searchText) {
		ruleExecutionPage.inputDataSearchFiled(searchText);
	}

	@When("^Verify all (\\d+) \"([^\"]*)\" are highlighted$")
	public void verify_Search_Text_Highlighted(int searchResultCount, String searchText) {
		ruleExecutionPage.verifySearchTextHighlighted(searchResultCount, searchText);
	}

	@When("^Clear the Grid search field$")
	public void clear_Grid_Search_Field() {
		ruleExecutionPage.clearSearchField();
	}

	@When("^Verify all (\\d+) \"([^\"]*)\" are not highlighted$")
	public void verify_Search_Text_Not_Highlighted(int searchResultCount, String searchText) {
		ruleExecutionPage.verifySearchTextNotHighlighted(searchResultCount, searchText);
	}

	@When("^Cick on \"([^\"]*)\" checkbox$")
	public void click_On_Checkbox_In_Grid(String ruleName) {
		ruleExecutionPage.clickCheckboxGrid(ruleName);
	}

	@When("^Input \"([^\"]*)\" in comments textarea$")
	public void input_Comments_In_Textarea(String commnets) {
		ruleExecutionPage.inputCommnets(commnets);
	}

	@When("^Click on all checkbox$")
	public void click_On_All_Checkbox() {
		ruleExecutionPage.clickAllCheckbox();
	}
}