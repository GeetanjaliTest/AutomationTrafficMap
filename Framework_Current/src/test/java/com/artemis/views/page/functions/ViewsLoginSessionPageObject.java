package com.artemis.views.page.functions;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

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
import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;
import com.artemis.views.lib.utils.AbstractBasePage;
import com.artemis.views.page.locators.ViewsPortalLoginLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Login page of Artimis Views
 * application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ViewsLoginSessionPageObject extends AbstractBasePage {
	final ViewsPortalLoginLocators loginLoc;
	WebDriverWait wait, waitNewBrowser;
	JavascriptExecutor jsExecutor;
	String parentWindowHandle;
	String currentWindowHandle;
	static final String ADMINISTRATION_MENU = "Administration";
	private WebDriver newBrowser;

	@Autowired
	public ViewsLoginSessionPageObject(final WebDriver driver) {
		super(driver);
		loginLoc = PageFactory.initElements(driver, ViewsPortalLoginLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public void openTabWithUrl(String url) {
		parentWindowHandle = getDriver().getWindowHandle();
		((JavascriptExecutor) getDriver()).executeScript("window.open()");
		List<String> windowHandles = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(windowHandles.get(1));
		getDriver().get(url);
		currentWindowHandle = getDriver().getWindowHandle();
		waitAndWatch(2);
	}

	public void switchBackToFirstTab() {
		getDriver().switchTo().window(parentWindowHandle);
		getDriver().switchTo().activeElement();
		waitAndWatch(2);
	}

	public void switchBackToSecondTab() {
		getDriver().switchTo().window(currentWindowHandle);
		waitAndWatch(2);
	}

	public void clickAdministrationMenu() {
		getElementUsingDivText(ADMINISTRATION_MENU).click();
		waitAndWatch(2);
	}

	public void verifyLoginPageOpened() {
		WebElement loginButton = getDriver().findElement(By.xpath("//input[@value='LOGIN']"));
		assertElementIsVisible(loginButton, "Default login screen could not be verified");
		waitAndWatch(2);
	}

	public void closeFirstTab() {
		getDriver().switchTo().window(parentWindowHandle);
		getDriver().close();
		waitAndWatch(1);
	}

	public void openBrowserWithUrl(String url) throws MalformedURLException, ScumberException {
		newBrowser = WebDriverActions.openNewBrowser();
		waitNewBrowser = new WebDriverWait(newBrowser, 20);
		newBrowser.get(url);
	}

	public void loginViewsPortalUsingCredentials(String userName, String password, String dataset) {
		By nameLoc = By.id("formUserId");
		newBrowser.findElement(nameLoc).clear();
		newBrowser.findElement(nameLoc).sendKeys(userName);
		By passwordLoc = By.id("pwdField");
		newBrowser.findElement(passwordLoc).clear();
		newBrowser.findElement(passwordLoc).sendKeys(password);
		By dataSetLoc = By.id("formDatasetId");
		newBrowser.findElement(dataSetLoc).clear();
		newBrowser.findElement(dataSetLoc).sendKeys(dataset);
		By logInButtonLoc = By.xpath("//input[@value='LOGIN']");
		newBrowser.findElement(logInButtonLoc).click();
	}

	public void clickOptionPanel(String panelOption) {
		By panelItemLoc = By.xpath("//div[contains(@class,'item-text')][contains(text(),'" + panelOption + "')]");
		newBrowser.findElement(panelItemLoc).click();
	}

	public void clickOptionRuleExecution(String option) {
		By panelInnerItem = By.xpath("//li[contains(@id,'treelistitem')]//div[contains(@class,'group')]");
		waitNewBrowser.until(ExpectedConditions.elementToBeClickable(panelInnerItem));
		newBrowser.findElement(panelInnerItem).click();
	}

	public void verifyPageDisplayed(String pageHeaderText, String option) {
		By headerText = By
				.xpath("//div[contains(@class,'title-text-default')][contains(text(),'" + pageHeaderText + "')]");
		waitNewBrowser.until(ExpectedConditions.visibilityOfElementLocated(headerText));
		Assert.assertTrue(pageHeaderText + "Page is not displayed", newBrowser.findElement(headerText).isDisplayed());
		Assert.assertTrue(newBrowser
				.findElement(By.xpath("//div[contains(@class,'item-text')][contains(text(),'" + option
						+ "')]//ancestor::li[contains(@class,'selected')][not(contains(@class,'expand'))]"))
				.isDisplayed());
	}

	public void chooseOption(String profileOption) {
		newBrowser.findElement(loginLoc.profileDropdownButton).click();
		WebElement headerTextDisplayed = newBrowser.findElement(
				By.xpath("//div[contains(@id, 'menuitem')]//a//span[contains(text(),'" + profileOption + "')]"));
		headerTextDisplayed.click();
	}

	public void verifyHomePageVisibility(String pageHeader) {
		By headerAboutViewsPortal = By.xpath("//div[contains(@id,'tbtext')][contains(text(),'" + pageHeader + "')]");
		Assert.assertFalse(isElementDisplayed(headerAboutViewsPortal));
	}

	public void verifyLoginSuccessfull(String headerText) {
		By headerTextDisplayedLoc = By.xpath(
				"//div[contains(@id,'toolbar')]//div[contains(@id,'tbtext')][contains(text(),'" + headerText + "')]");
		Assert.assertTrue("Login is not successfull", newBrowser.findElement(headerTextDisplayedLoc).isDisplayed());
	}

	public void closeNewBrowser() {
		newBrowser.quit();
	}
}