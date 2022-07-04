package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.GroupManagementPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/***
 * 
 * @author Rathore Mahipal
 *
 *
 */
public class GroupManagementSD {
	private final static Logger Log = Logger.getLogger(GroupManagementSD.class.getName());

	private WebDriver itsDriver;
	private GroupManagementPageObject groupManagementPage;

	public GroupManagementSD() {
		Log.info("Constructor: GroupManagementStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		groupManagementPage = PageFactory.initElements(itsDriver, GroupManagementPageObject.class);
	}

	@When("^I click on \"([^\"]*)\" under Administration Menu$")
	public void clickMenuUnderAdministration(String menuName) {
		groupManagementPage.clickMenuUnderAdministration(menuName);
	}

	@When("^I click on \"([^\"]*)\" under Administration Menu when its open$")
	public void clickGroupMenuPanelOpen(String menuName) {
		groupManagementPage.clickGroupMenuPanelOpen(menuName);
	}

	@Then("^I should see \"([^\"]*)\" panel displayed$")
	public void verifyPanelDisplayed(String panelName) {
		groupManagementPage.verifyPanelDisplayed(panelName);
	}

	@When("^I click on \"([^\"]*)\" icon on Group Management panel$")
	public void clickIconOnGroupManagementScreen(String iconName) {
		groupManagementPage.clickIconOnGroupManagementScreen(iconName);
	}

	@Then("^I should see \"([^\"]*)\" tab opened$")
	public void verifyTabOpened(String tabName) {
		groupManagementPage.verifyTabOpened(tabName);
	}

	@When("^I enter \"([^\"]*)\" in \"([^\"]*)\" Field for Add Group Tab$")
	public void inputFieldValue(String value, String fieldName) {
		groupManagementPage.inputFieldValue(value, fieldName);
	}

	@When("^I click on \"([^\"]*)\" button on Add Group Tab$")
	public void clickButtonOnAddGroupTab(String buttonName) {
		groupManagementPage.clickParticularButtonOnGroupPages(buttonName);
	}

	@Then("^I should see \"([^\"]*)\" group displayed$")
	public void verifyGroupDisplayed(String groupName) {
		groupManagementPage.verifyGroupDisplayed(groupName);
	}

	@When("^I set \"([^\"]*)\" value for Active checkbox$")
	public void setCheckboxOnAddTab(boolean value) {
		groupManagementPage.setCheckboxOnAddTab(value);
	}

	@When("^I click on \"([^\"]*)\" icon on GCM page$")
	public void clickIconOnGcmPage(String iconName) {
		groupManagementPage.clickIconOnGroupManagementScreen(iconName);
	}

	@When("^I select \"([^\"]*)\" collection among listed$")
	public void selectCollectionAmongListed(String collectionName) {
		groupManagementPage.selectCollectionAmongListed(collectionName);
	}

	@Then("^I should see Group Collection Details window displayed$")
	public void verifyGroupCollectionDetailsWindowOpen() {
		groupManagementPage.verifyGroupCollectionDetailsWindowOpen();
	}

	@When("^I enter \"([^\"]*)\" for Name field on GCD window$")
	public void inputNameOnGcdWindow(String collectionName) {
		groupManagementPage.inputNameOnGcdWindow(collectionName);
	}

	@When("^I select \"([^\"]*)\" as type on GCD window$")
	public void selectTypeOfGcdWindow(String typeOfGcdWindow) {
		groupManagementPage.selectTypeOfGcdWindow(typeOfGcdWindow);
	}

	@When("^I enter Description \"([^\"]*)\" for GCD window$")
	public void inputDescription(String description) {
		groupManagementPage.inputDescrition(description);
	}

	@When("^I click on Activate checkbox present on GCD window$")
	public void activateCheckbox() {
		groupManagementPage.activateCheckbox();
	}

	@When("^I click on \"([^\"]*)\" button on GCD window$")
	public void clickButtonOnGCDWindow(String buttonName) {
		groupManagementPage.clickParticularButtonOnGroupPages(buttonName);
	}

	@Then("^I should see \"([^\"]*)\" displayed in list of Group Collections$")
	public void verifyGroupCollectionListed(String groupCollectionName) {
		groupManagementPage.verifyGroupCollectionListed(groupCollectionName);
	}

	@Then("^I should see Group Selection Window open$")
	public void verifyGroupSelectionWindowOpen() {
		groupManagementPage.verifyGroupSelectionWindowOpen();
	}

	@When("^I select checkbox for \"([^\"]*)\" group on Group Selection Window$")
	public void selectGroupForGroupCollection(String groupName) {
		groupManagementPage.selectGroupForGroupCollection(groupName);
	}

	@When("^I click on \"([^\"]*)\" button on Group Selection Window$")
	public void clickButtonOnGroupSelectionWindow(String buttonName) {
		groupManagementPage.clickButtonOnGroupSelectionWindow(buttonName);
	}

	@Then("^I should see \"([^\"]*)\" in list of assigned group for \"([^\"]*)\" collection on GCM page$")
	public void verifyGroupAssignedForGroupCollection(String groupName, String groupCollectionName) {
		groupManagementPage.verifyGroupAssignedForGroupCollection(groupName, groupCollectionName);
	}

	@Then("^I should see \"([^\"]*)\" message displayed on save window$")
	public void verifySaveMessage(String message) {
		groupManagementPage.verifySaveMessage(message);
	}

	@When("^I select \"([^\"]*)\" group listed on Group Management Panel$")
	public void selectGroupFromList(String group) {
		groupManagementPage.selectGroupFromList(group);
	}

	@Then("^I should see Active Checkbox being \"([^\"]*)\"$")
	public void verifyActiveCheckboxState(String checkBoxState) {
		groupManagementPage.verifyActiveCheckboxState(checkBoxState);
	}

	@When("^I click on \"([^\"]*)\" button on Edit Group Tab$")
	public void clickTabOnGCMPage(String buttonName) {
		groupManagementPage.clickParticularButtonOnGroupPages(buttonName);
	}

	@When("^I click checkbox for \"([^\"]*)\" group listed under Assigned Groups Section$")
	public void selectCheckboxForGroup(String groupName) {
		groupManagementPage.selectCheckboxForGroup(groupName);
	}

	@Then("^I should see confirmation window with \"([^\"]*)\" message$")
	public void verifyConfirmationMessage(String message) {
		groupManagementPage.verifyConfirmationMessage(message);
	}

	@Then("^I should see confirmation window with \"([^\"]*)\" message for GCM$")
	public void verifyConfirmationMessageGCM(String message) {
		groupManagementPage.verifyConfirmationMessageGCM(message);
	}

	@When("^I click \"([^\"]*)\" button on confirmation window$")
	public void clickButtonOnConfirmationWindow(String buttonName) {
		groupManagementPage.clickButtonOnConfirmationWindow(buttonName);
	}

	@When("^I click \"([^\"]*)\" button on confirmation window for Group Collection$")
	public void clickButtonOnConfirmationWindowForGCM(String buttonName) {
		groupManagementPage.clickButtonOnConfirmationWindowForGCM(buttonName);
	}

	@Then("^I should see that \"([^\"]*)\" does not exist anymore in Assigned Groups Section$")
	public void verifyAbsenceOfGroup(String groupName) {
		groupManagementPage.verifyAbsenceOfGroup(groupName);
	}

	@Then("^I should see that \"([^\"]*)\" does not exist anymore in list of Group Collections$")
	public void verifyAbsenceOfGroupCollection(String groupCollectionName) {
		groupManagementPage.verifyAbsenceOfGroupCollection(groupCollectionName);
	}

	@Then("^I should see confirmation window with \"([^\"]*)\" \"([^\"]*)\" message$")
	public void verify_Popup_Text_In_Overlay(String popText, String popTextGroup) {
		groupManagementPage.verifyPopupText(popText, popTextGroup);
	}

	@Then("^I should see confirmation window with \"([^\"]*)\" \"([^\"]*)\" message for gcm$")
	public void verify_Popup_Text_In_Overlay_For_Gcm(String popText, String popTextGroup) {
		groupManagementPage.verifyPopupTextGcm(popText, popTextGroup);
	}

	@When("^I select checkbox for \"([^\"]*)\" group on Group Selection$")
	public void select_Group_For_Group_Collection(String groupName) {
		groupManagementPage.selectGroupForGroupCollectionManagement(groupName);
	}

	@When("^Click on Add button in Assigned Groups Group Collection Management$")
	public void click_Add_Button_For_Assigned_Rules() {
		groupManagementPage.clickAddButtonAssignedGroups();
	}
}