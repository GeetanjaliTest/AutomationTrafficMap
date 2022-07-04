package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.ViewsAboutPageAndPerspectivePageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class ViewsAboutPageAndPerspectiveSteps {
	private final static Logger Log = Logger.getLogger(ViewsAboutPageAndPerspectiveSteps.class.getName());

	private WebDriver itsDriver;
	private ViewsAboutPageAndPerspectivePageObject viewAboutPage;

	public ViewsAboutPageAndPerspectiveSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		viewAboutPage = PageFactory.initElements(itsDriver, ViewsAboutPageAndPerspectivePageObject.class);
	}

	@When("^Click on \"([^\"]*)\" button in the dialog$")
	public void click_Ok_Button_In_User_Profile_Dialog(String buttonText) {
		viewAboutPage.clickOkButton(buttonText);
	}

	@When("^Click on \"([^\"]*)\" dropdown option$")
	public void click_On_Dashboard_Option_From_Business_Rule_Checker(String option) {
		viewAboutPage.clickDashboardDropdownOption(option);
	}

	@When("^Verify the \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verify_Product_Version_In_About_Page(String labelName, String value) {
		viewAboutPage.verifyProductVersionAboutPage(labelName, value);
	}

	@When("^Verify \"([^\"]*)\" window is closed$")
	public void verify_Page_Disappeared(String pageHeader) {
		viewAboutPage.verifyHomePageVisibility(pageHeader);
	}

	@When("^Verify \"([^\"]*)\" label is in bold font$")
	public void verify_Label_Font_About_Page(String labelName) {
		viewAboutPage.verifyLabelFontAboutPage(labelName);
	}

	@When("^Click on \"([^\"]*)\" button in About View Portal Window$")
	public void click_Export_Button_About_Page(String buttonName) {
		viewAboutPage.clickExportButtonAboutPage(buttonName);
	}

	@When("^Click on \"([^\"]*)\" tab$")
	public void click_Export_Tab_In_About_Page(String tabName) {
		viewAboutPage.clickServerTab(tabName);
	}

	@When("^Verify \"([^\"]*)\" tab is selected by default$")
	public void verify_Default_Tab_Selected_In_About_Page(String tabName) {
		viewAboutPage.verifyDefaultTabSelected(tabName);
	}
}