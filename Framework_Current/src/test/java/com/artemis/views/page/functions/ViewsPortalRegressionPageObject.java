package com.artemis.views.page.functions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.utils.AbstractBasePage;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 */
public class ViewsPortalRegressionPageObject extends AbstractBasePage {
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	static final String CHANGE_PASSWORD = "Change Password";
	static final String CANCEL = "Cancel";
	static final String OK = "OK";
	static final String MANDATORY= "Mandatory";
	static final String SAME_PWD= "SamePassword";
	static final String INVALID_PWD= "InvalidPassword";
	static final String NON_MATCHING_PWD= "NotMatchingPassword";
	static final String PWD_POLICY= "PasswordPolicy";
	
	@Autowired
	public ViewsPortalRegressionPageObject(final WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	@FindBy(xpath = "//input[@value='REGISTER']")
	private WebElement itsRegisterButton;

	@FindBy(id = "newPwdId")
	private WebElement itsNewPwdField;

	@FindBy(id = "confirmPwdId")
	private WebElement itsConfirmPwdField;

	@FindBy(id = "displayMsg")
	private WebElement itsErrorMessageField;

	@FindBy(id = "loginMsg")
	private WebElement itsErrorMessageLoginScreenField;

	@FindBy(xpath = "//span[text()='Basic Info']")
	private WebElement itsProfileWindowIdentifier;

	@FindBys(@FindBy(xpath = "//span[@class='x-btn-wrap x-btn-wrap-default-toolbar-small x-btn-arrow x-btn-arrow-right' and @data-ref='btnWrap']"))
	private List<WebElement> itsPanelButtonList;

	@FindBys(@FindBy(xpath = "//input[@type='password']"))
	private List<WebElement> itsPasswordFieldsList;

	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'This field is required')]"))
	private List<WebElement> itsPasswordFieldsPostErrorList;

	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'Current password and New password cannot be same')]"))
	private List<WebElement> itsSamePasswordErrorList;

	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'Provide valid current password.')]"))
	private List<WebElement> itsInvalidPasswordErrorList;

	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'Password didn\'t match')]"))
	private List<WebElement> itsPasswordNotMarchErrorList;

	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'Your new password was rejected because it does not comply with the password policy')]"))
	private List<WebElement> itsPasswordPolicyErrorList;

	@FindBy(xpath = "//span[text()='Current Password:']/../..//input")
	private WebElement itsCurrentPasswordField;

	@FindBy(xpath = "//span[text()='New Password:']/../..//input")
	private WebElement itsNewPasswordField;

	@FindBy(xpath = "//span[text()='Confirm Password:']/../..//input")
	private WebElement itsConfirmPasswordField;

	@FindBy(xpath = "//div[text()='Password changed successfully.']")
	private WebElement itsPasswordChangedStatus;

	public void verifyRegistrationScreenOpen() {
		assertElementIsVisible(itsRegisterButton, "Registration Screen is not open");
	}

	public void inputRegisterPassword(String newPassword, String confirmPassword) {
		typeEditBox(itsNewPwdField, newPassword);
		typeEditBox(itsConfirmPwdField, confirmPassword);
		itsRegisterButton.click();
		waitAndWatch(2);
	}

	public void verifyErrorMessage(String message) {
		Assert.assertTrue("Error or Warning message is not same as expected",
				itsErrorMessageField.getText().contains(message));
	}

	public void verifyErrorMessageForLoginScreen(String message) {
		Assert.assertTrue("Error or warning message could not be verified",
				itsErrorMessageLoginScreenField.getText().contains(message));
	}

	public void clickMenuFromUser(String menuName) {
		itsPanelButtonList.get(2).click();
		getElementUsingSpanText(menuName).click();
		waitAndWatch(3);
	}

	public void verifyProfileWindowOpen() {
		assertElementIsVisible(itsProfileWindowIdentifier, "Profile Window Open could not be verified");
	}

	public void clickChangePasswordUrl() {
		clickElementUsingDivText(CHANGE_PASSWORD);
	}

	public void verifyChangePasswordScreenOpen() {
		assertElementIsVisible(getElementUsingSpanText("Change Password"), "Change Password Tab is not open");
	}

	public void verifyChangePasswordScreenFieldsButtons() {
		assertElementIsVisible(itsPasswordFieldsList.get(0), "Element is not visible");
		assertElementIsVisible(itsPasswordFieldsList.get(1), "Element is not visible");
		assertElementIsVisible(itsPasswordFieldsList.get(2), "Element is not visible");
		assertElementIsVisible(getElementUsingSpanText("Cancel"), "Element is not visible");
	}

	public void clickButtonOnChangePasswordScreen(String buttonName) {
		if (buttonName.equals(CANCEL)) {
			getElementUsingSpanText(buttonName).click();
			waitAndWatch(1);
		} else if (buttonName.equals(OK)) {
			getDriver().findElements(By.xpath("//span[text()='OK']")).get(1).click();
			waitAndWatch(1);
		} else {
			Assert.fail("Given Button is invalid or invisible to click and it is: " + buttonName);
		}
	}

	public void clickOkButtonOnUserProfilePage() {
		waitAndWatch(2);
		getElementUsingSpanText(OK).click();
		waitAndWatch(1);
	}

	public void verifyMandatoryFieldError() {
		Assert.assertTrue("Mandatory Password fields are empty", itsPasswordFieldsPostErrorList.size() == 3);
	}

	public void inputPasswordFieldsOnChangePasswordScreen(String currentPwd, String newPwd, String confirmPwd) {
		typeEditBox(itsCurrentPasswordField, currentPwd);
		typeEditBox(itsNewPasswordField, newPwd);
		typeEditBox(itsConfirmPasswordField, confirmPwd);
	}
	
	public void verifyWarningDisplayedOnPasswordScreen(String warningType) {
		switch (warningType) {
		case MANDATORY:
			Assert.assertTrue("Mandatory Password fields are empty", itsPasswordFieldsPostErrorList.size() == 3);
			break;
		case SAME_PWD:
			assertElementIsVisible(itsSamePasswordErrorList.get(0), "Same Password error is not visible");
			break;
		case INVALID_PWD:
			assertElementIsVisible(itsInvalidPasswordErrorList.get(0), "Invalid password error is not visible");
			break;
		case NON_MATCHING_PWD:
			assertElementIsVisible(itsPasswordNotMarchErrorList.get(0),
					"Different password for new password error is not visible");
			break;
		case PWD_POLICY:
			assertElementIsVisible(itsPasswordPolicyErrorList.get(0),
					"Different password for new password error is not visible");
			break;
		default:
			Assert.fail("Given Type of warning is invalid and unavailable to verify");
			break;
		}
	}

	public void confirmPasswordChanged() {
		waitAndWatch(1);
		assertElementIsVisible(itsPasswordChangedStatus, "Password change status is not verified");
	}

	public void verifyWarningDisplayedOnPasswordScreenField(String warningMsg, String fieldName) {
		WebElement inputPasswd = itsDriver.findElement(
				By.xpath("//span[contains(text(),'" + fieldName + "')]//parent::label//following-sibling::div//input"));
		wait.until(ExpectedConditions.visibilityOf(inputPasswd));
		Assert.assertTrue(inputPasswd.getAttribute("data-errorqtip").contains(warningMsg));
	}
}