package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.page.functions.ViewsPortalRegressionPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewsPortalRegressionSD {
	private final static Logger Log = Logger.getLogger(ViewsPortalRegressionSD.class.getName());

	private WebDriver itsDriver;
	private ViewsPortalRegressionPageObject viewsPortalPage;

	public ViewsPortalRegressionSD() {
		Log.info("Constructor: ViewsPortalRegressionStepDefinition");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		viewsPortalPage = PageFactory.initElements(itsDriver, ViewsPortalRegressionPageObject.class);
	}

	@Then("^I should see Registration Screen open$")
	public void verifyRegistrationScreenOpen() {
		viewsPortalPage.verifyRegistrationScreenOpen();
	}

	@When("^I enter \"([^\"]*)\" as New password and \"([^\"]*)\" as Confirm Password and Click Register button$")
	public void inputRegisterPassword(String newPassword, String confirmPassword) {
		viewsPortalPage.inputRegisterPassword(newPassword, confirmPassword);
	}

	@Then("^I should see \"([^\"]*)\" error message displayed$")
	public void verifyErrorMessage(String message) {
		viewsPortalPage.verifyErrorMessage(message);
	}

	@Then("^I should see \"([^\"]*)\" as warning or error message on Login Screen$")
	public void verifyErrorMessageForLoginScreen(String message) {
		viewsPortalPage.verifyErrorMessageForLoginScreen(message);
	}

	@When("^I click on \"([^\"]*)\" menu item from User Menu$")
	public void clickMenuFromUser(String menuName) {
		viewsPortalPage.clickMenuFromUser(menuName);
	}

	@Then("^I should see User Profile window displayed$")
	public void verifyUserProfileWindowDisplayed() {
		viewsPortalPage.verifyProfileWindowOpen();
	}

	@When("^I click on change password link in User Profile Window$")
	public void clickChangePasswordUrl() {
		viewsPortalPage.clickChangePasswordUrl();
	}

	@Then("^I should see change password screen open$")
	public void verifyChangePasswordScreenOpen() {

		viewsPortalPage.verifyChangePasswordScreenOpen();
	}

	@Then("^I should verify all three text fields available with Ok and Cancel buttons$")
	public void verifyChangePasswordScreenFieldsButtons() {
		viewsPortalPage.verifyChangePasswordScreenFieldsButtons();
	}

	@When("^I click on \"([^\"]*)\" button on change password screen$")
	public void clickButtonOnChangePasswordScreen(String buttonName) {
		viewsPortalPage.clickButtonOnChangePasswordScreen(buttonName);
	}

	@When("^I click OK button on User Profile window$")
	public void clickOkButtonOnUserProfilePage() {
		viewsPortalPage.clickOkButtonOnUserProfilePage();
	}

	@Then("^I should see \"([^\"]*)\" warning displayed on change Password Screen fields$")
	public void verifyWarningDisplayedOnPasswordScreen(String warningType) {
		viewsPortalPage.verifyWarningDisplayedOnPasswordScreen(warningType);
	}

	@When("^I input \"([^\"]*)\" as current password, \"([^\"]*)\" as new password and \"([^\"]*)\" as confirm new password$")
	public void inputPasswordSet(String currentPwd, String newPwd, String confirmPwd) {
		viewsPortalPage.inputPasswordFieldsOnChangePasswordScreen(currentPwd, newPwd, confirmPwd);
	}

	@Then("^I should see password changed status on User Profile Page$")
	public void confirmPasswordChanged() {
		viewsPortalPage.confirmPasswordChanged();
	}

	@Then("^I should see \"([^\"]*)\" warning displayed on change Password Screen for \"([^\"]*)\" field$")
	public void verifyWarningDisplayedOnPasswordScreenField(String warningMsg, String fieldName) {
		viewsPortalPage.verifyWarningDisplayedOnPasswordScreenField(warningMsg, fieldName);
	}
}