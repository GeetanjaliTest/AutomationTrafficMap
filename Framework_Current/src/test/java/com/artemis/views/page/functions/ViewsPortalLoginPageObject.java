package com.artemis.views.page.functions;

import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.helper.PropertiesLoader;
import com.artemis.views.lib.utils.AbstractBasePage;
import com.artemis.views.page.locators.ViewsPortalLoginLocators;
import com.artemis.views.stepdefinition.ViewsPortalLoginSteps;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Login page of Artimis Views
 * application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ViewsPortalLoginPageObject extends AbstractBasePage {
	final ViewsPortalLoginLocators loginLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	private final static Logger Log = Logger.getLogger(ViewsPortalLoginSteps.class.getName());

	@Autowired
	public ViewsPortalLoginPageObject(final WebDriver driver) {
		super(driver);
		loginLoc = PageFactory.initElements(driver, ViewsPortalLoginLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;

	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifyLogInPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(loginLoc.imgeArtemisLoginPage));
		Assert.assertTrue(loginLoc.imgeArtemisLoginPage.getAttribute("src").contains("login.png"));
		Assert.assertTrue(loginLoc.imgeArtemisLoginPage.isDisplayed());
		Assert.assertTrue(loginLoc.textViewsArtemisLoginPage.isDisplayed());
		Assert.assertTrue(loginLoc.usernameTextBoxLoginPage.isDisplayed());
		Assert.assertTrue(loginLoc.passwordTextBoxLoginPage.isDisplayed());
		Assert.assertTrue(loginLoc.datasetTextBoxLoginPage.isDisplayed());
		Assert.assertTrue(itsDriver.findElement(loginLoc.loginButtonArtemisLoginPage).isDisplayed());
	}

	public void inputCredLoginPage(String username, String password, String dataset) {
		wait.until(ExpectedConditions.elementToBeClickable(loginLoc.usernameTextBoxLoginPage));
		typeEditBox(loginLoc.usernameTextBoxLoginPage, username);
		typeEditBox(loginLoc.passwordTextBoxLoginPage, password);
		typeEditBox(loginLoc.datasetTextBoxLoginPage, dataset);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginLoc.loginButtonArtemisLoginPage));
		itsDriver.findElement(loginLoc.loginButtonArtemisLoginPage).click();
	}

	public void verifyLoginSuccessfull(String headerText) {
		pause(2000);
		By headerTextDisplayed = By.xpath("//div[contains(@id,'toolbar')]//div[contains(@id,'tbtext')][contains(text(),'" + headerText + "')]");
		WebElement headerTextDisplayedElm = findDisplayedElement(itsDriver, headerTextDisplayed);
		wait.until(ExpectedConditions.visibilityOf(headerTextDisplayedElm));
		wait.until(ExpectedConditions.elementToBeClickable(headerTextDisplayedElm));
		Assert.assertTrue("Header text is not displayed", isElementDisplayed(headerTextDisplayedElm));
	}

	public void chooseOptionOption(String profileOption) {
		WebElement dropdownElem = findDisplayedElement(itsDriver, loginLoc.profileDropdownButton);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElem));
		jsExecutor.executeScript("arguments[0].click();", dropdownElem);
		By headerTextDisplayed =	By.xpath("//div[contains(@id, 'menuitem')]//a//span[contains(text(),'" + profileOption + "')]");
		WebElement headerTextDisplayedElm = findDisplayedElement(itsDriver, headerTextDisplayed);
		wait.until(ExpectedConditions.elementToBeClickable(headerTextDisplayedElm));
		jsExecutor.executeScript("arguments[0].click();", headerTextDisplayedElm);
	}

	public void verifyFirstTimeLoginPanelDisibility(String panelText) {
		By firstTimeLoginText = By.xpath("//div[@id='openModal']//font[contains(text(),'" + panelText + "')]");
		WebElement firstTimeLoginTextElm = findDisplayedElement(itsDriver, firstTimeLoginText);
		wait.until(ExpectedConditions.visibilityOf(firstTimeLoginTextElm));
		Assert.assertTrue("Header text is not displayed", isElementDisplayed(firstTimeLoginTextElm));
	}

	public void inputCredFirstLoginPage(String password, String confirmPassword) {
		typeEditBox(loginLoc.passwordTextBoxLoginFirstTime, password);
		typeEditBox(loginLoc.confirmPasswordTextBoxLoginFirstTime, confirmPassword);
	}

	public void clickRegisterButton() {
		loginLoc.btnRegisterLoginFirstTime.click();
	}

	public void verifyLoginPanelVisibility() {
		Assert.assertFalse(isElementDisplayed(loginLoc.textBoxPasswordLoginFirstTime));
		Assert.assertTrue(isElementDisplayed(loginLoc.loginButtonArtemisLoginPage));
	}

	public void verifyAboutViewsPortalVisibility(String portalHeaderText) {
		WebElement pageHeaderElm = findDisplayedElement(itsDriver, loginLoc.headerAboutViewsPortal);
		wait.until(ExpectedConditions.visibilityOf(pageHeaderElm));
		Assert.assertEquals(portalHeaderText, pageHeaderElm.getText().trim());
	}

	public void clickOKButtonPortal() {
		wait.until(ExpectedConditions.elementToBeClickable(loginLoc.buttonOKAboutViewsPortal));
		jsMoveToElementAndClick(itsDriver, loginLoc.buttonOKAboutViewsPortal);
	}

	public void verifyAboutViewsPortalVisibility() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loginLoc.headerAboutViewsPortal));
		Assert.assertFalse(isElementDisplayed(loginLoc.headerAboutViewsPortal));
	}

	public void clickOptionPanel(String panelOption) {
		By panelItemLoc = By.xpath("//div[contains(@class,'item-text')][contains(text(),'" + panelOption + "')]");
		WebElement panelItem = findDisplayedElement(itsDriver, panelItemLoc);
		wait.until(ExpectedConditions.elementToBeClickable(panelItem));
		jsMoveToElementAndClick(itsDriver, panelItem);
	}

	public void clickOptionRuleExecution(String option) {
		By panelInnerItem = By.xpath("//div[contains(@class,'treelist-item-text')][text()= '" + option + "']");
		WebElement panelInnerItemLoc = findDisplayedElement(itsDriver, panelInnerItem);
		wait.until(ExpectedConditions.elementToBeClickable(panelInnerItemLoc));
		jsExecutor.executeScript("arguments[0].click();", panelInnerItemLoc);
		pause(5000);
	}

	public void verifyPageDisplayed(String pageHeaderText, String option) {
		By headerText =	By.xpath("//div[contains(@class,'title-text-default')][contains(text(),'" + pageHeaderText + "')]");
		WebElement headerTextElm = findDisplayedElement(itsDriver, headerText);
		wait.until(ExpectedConditions.visibilityOf(headerTextElm));
		Assert.assertTrue("Page text is not displayed", isElementDisplayed(headerTextElm));
		By panelTextdisplayedLoc = By.xpath("//div[contains(@class,'item-text')][contains(text(),'" + option
						+ "')]//ancestor::li[contains(@class,'selected')][not(contains(@class,'expand'))]");
		WebElement panelTextdisplayedElm = findDisplayedElement(itsDriver, panelTextdisplayedLoc);
		wait.until(ExpectedConditions.visibilityOf(panelTextdisplayedElm));
		Assert.assertTrue("Page text is not displayed", isElementDisplayed(panelTextdisplayedElm));
	}

	public void verifyErrorTextLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(loginLoc.logInPageError));
		Assert.assertTrue("Error text is not displayed", isElementDisplayed(loginLoc.logInPageError));
	}

	public void clickChangePasswordLink(String labelText) {
		By passwordChangeLoc = By.xpath("//div[contains(@class,'blueline')][contains(text(),'" + labelText + "')]");
		WebElement passwordChangeElm = findDisplayedElement(itsDriver, passwordChangeLoc);
		wait.until(ExpectedConditions.elementToBeClickable(passwordChangeElm));
		passwordChangeElm.click();
	}

	public void verifyNameDisplayed(String headerText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'header-title-textEl')][contains(text(),'" + headerText + "')]")));
		Assert.assertTrue(itsDriver
				.findElement(
						By.xpath("//div[contains(@id, 'header-title-textEl')][contains(text(),'" + headerText + "')]"))
				.isDisplayed());
	}

	public void putPasswordUserProfile(String password, String fieldName) {
		WebElement inputPasswd = itsDriver.findElement(
				By.xpath("//span[contains(text(),'" + fieldName + "')]//parent::label//following-sibling::div//input"));
		wait.until(ExpectedConditions.elementToBeClickable(inputPasswd));
		inputPasswd.clear();
		inputPasswd.sendKeys(password);
	}

	public void clickOkButtonChngPswd() {
		wait.until(ExpectedConditions.elementToBeClickable(loginLoc.buttonOKInsidePanel));
		jsExecutor.executeScript("arguments[0].click();", loginLoc.buttonOKInsidePanel);
	}

	public void clickOkButtonBasicInfo() {
		wait.until(ExpectedConditions.elementToBeClickable(loginLoc.buttonOKInsidePanelBasicInfo));
		loginLoc.buttonOKInsidePanelBasicInfo.click();
	}

	public void verifyPsswdSucMsg(String sucMsg) {
		WebElement successMsgElm = itsDriver.findElement(By.xpath("//div[contains(@id, 'displayfield')][contains(text(),'" + sucMsg + "')]"));
		wait.until(ExpectedConditions.visibilityOf(successMsgElm));
		Assert.assertTrue(successMsgElm.isDisplayed());
	}

	public void verifyPortalVisibility(String dialogName) {
		By dialog = By.xpath("//div[contains(@id, 'header-title-textEl')][contains(text(),'" + dialogName + "')]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(dialog));
		Assert.assertFalse(isElementDisplayed(dialog));
	}
}