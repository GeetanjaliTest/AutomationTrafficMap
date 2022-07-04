package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.MultiDatasetSupportPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultiDatasetSupportSteps {
	private final static Logger Log = Logger.getLogger(MultiDatasetSupportSteps.class.getName());

	private WebDriver itsDriver;
	private MultiDatasetSupportPageObject multiDataPage;

	public MultiDatasetSupportSteps() {
		Log.info("Constructor: LoginStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		multiDataPage = PageFactory.initElements(itsDriver, MultiDatasetSupportPageObject.class);
	}

	@When("^Select \"([^\"]*)\" dropdown option$")
	public void select_Dropdown_Option_From_Settings(String dropdownOption) {
		multiDataPage.clickSettingDropdown(dropdownOption);
	}

	@Then("^Verify \"([^\"]*)\" Dataset are listed$")
	public void verify_Dataset_Listed_In_DataSet_Management_Overlay(String datasetName) {
		multiDataPage.verifyDatasetListed(datasetName);
	}

	@Then("^Verify \"([^\"]*)\" Portal is closed$")
	public void verify_Overlay_Visibility(String headerText) {
		multiDataPage.verifyOverlayVisibility(headerText);
	}

	@Then("^Verify \"([^\"]*)\" option is visible in left side panel$")
	public void verify_Left_Side_Sub_Options_Visibility(String subOptions) {
		multiDataPage.verifySubOptionsVisibility(subOptions);
	}

	@Then("^Verify Views data set is displayed$")
	public void verify_Views_Data_Set_Visibility() {
		multiDataPage.verifyViewsDataSetVisibility();
	}
	
	@Then("^Verify Defense data set is displayed$")
	public void verify_Defense_Data_Set_Visibility() {
		multiDataPage.verifyDefenseDataSetVisibility();
	}
	
	@Then("^Verify \"([^\"]*)\" tab is displayed$")
	public void verify_Data_Set_Tab_Visibility(String dataTab) {
		multiDataPage.verifyDataSetTabVisibility(dataTab);
	}
	
	@When("^Click on \"([^\"]*)\" button in info popup$")
	public void click_On_Button_In_Info_Pop(String btnText) {
		multiDataPage.clickButtonInfoPop(btnText);
	}
	
	@Then("^Verify \"([^\"]*)\" Database are listed$")
	public void verify_Database_Listed_In_DataSet_Management_Overlay(String databaseName) {
		multiDataPage.verifyDatasetBase(databaseName);
	}

	@When("^Click on Validate Dataset button in the header$")
	public void click_On_Validate_Dataset_Button_In_Header() {
		multiDataPage.clickValidateButtonHeader();
	}

	@When("^Verify \"([^\"]*)\" text shown in the popup$")
	public void verify_Text_Shown_On_Popup(String popupText) {
		multiDataPage.verifyPopupText(popupText);
	}

	@When("^Click on Delete Dataset button in the header$")
	public void click_On_Delete_Dataset_Button_In_Header() {
		multiDataPage.clickDeleteButtonHeader();
	}

	@When("^Verify \"([^\"]*)\" input box highlighted with red color$")
	public void verify_Input_Box_Highlighted_With_Red_Color_For_Error(String fieldName) {
		multiDataPage.verifyErrorInField(fieldName);
	}
}