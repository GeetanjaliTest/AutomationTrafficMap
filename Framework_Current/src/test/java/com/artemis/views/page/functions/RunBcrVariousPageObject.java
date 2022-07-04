package com.artemis.views.page.functions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.utils.AbstractBasePage;
import com.artemis.views.page.locators.BaselineChangeRequestLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Baseline Chnage Request of
 * Artimis Views application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class RunBcrVariousPageObject extends AbstractBasePage {
	final BaselineChangeRequestLocators bCRLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	static final String ADMINISTRATION_MENU = "Administration";
	static final String OPERATIONS_MENU = "Operations";
	static final String DISABLED = "Disabled";
	static final String BCR_PRECREATE = "BCR PRE-CREATE";
	static final String EDIT_BUTTON = "Edit";
	static final String UPDATE_BUTTON = "Update";
	static final String SCHEDULE_METRIC = "Scehdule Metrics";

	@Autowired
	public RunBcrVariousPageObject(final WebDriver driver) {
		super(driver);
		bCRLoc = PageFactory.initElements(driver, BaselineChangeRequestLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	@FindBy(xpath = "//b[text()='Edit']")
	private WebElement itsEditButton;

	public void clickDisabledButton() {
		assertElementIsVisible(getElementUsingSpanText(DISABLED), "Disabled element is not visible");
		clickElementUsingSpanText(DISABLED);
		waitAndWatch(2);
	}

	public void openNewBrowserTab() {
		waitAndWatch(1);
		((JavascriptExecutor) getDriver()).executeScript("window.open()");
		List<String> windowHandles = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(windowHandles.get(1));
	}

	public void verifyWindowOpened(String windowName) {
		assertElementIsVisible(getElementUsingSpanText(windowName),"BCR Check failed window is not open or not visible");
	}

	public void clickButtonOnBcrCheckFailPage(String buttonName) {
		clickElementUsingSpanText(buttonName);
	}

	public void clickButtonOnCreateBcrPage(String buttonName) {
		clickElementUsingSpanText(buttonName);
	}

	public void clickMenuUnderAdministration(String menuName) {
		getElementUsingDivText(ADMINISTRATION_MENU).click();
		waitAndWatch(1);
		if (menuName.equals(OPERATIONS_MENU)) {
			waitAndWatch(1);
			getDriver().findElement(By.xpath("//div[text()='" + OPERATIONS_MENU + "']")).click();
			waitAndWatch(4);
		} else {
			Assert.fail("Given Menu not available to click and it is: " + menuName);
		}
	}

	public void verifyPanelDisplayed(String panelName) {
		if (panelName.equals(OPERATIONS_MENU)) {
			waitAndWatch(1);
			assertElementIsVisible(getElementUsingDivText(panelName), "Panel is not visible");
			waitAndWatch(1);
		} else {
			Assert.fail("Given Menu not available to click and it is: " + panelName);
		}
	}

	public void selectOperationFromList(String operationName) {
		clickElementUsingDivText(operationName);
	}

	public void clickButtonOnOperationsListPage(String buttonName) {
		if (buttonName.equals(EDIT_BUTTON)) {
			clickElement(itsEditButton);
			waitAndWatch(2);
		} else if (buttonName.equals(UPDATE_BUTTON)) {
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
		} else {
			Assert.fail("Given Button is not available and it is: " + buttonName);
		}
	}

	public void inputGroupCollectionName(String groupCollectionName) {
		// typeEditBox(getElementUsingInputName("categoryId"),
		// groupCollectionName);
		if(groupCollectionName.equals(SCHEDULE_METRIC)){
			getElementUsingInputName("categoryId").click();
			waitAndWatch(1);
			getElementUsingInputName("categoryId").sendKeys("" + Keys.UP + Keys.ENTER);
		}else{
		getElementUsingInputName("categoryId").click();
		waitAndWatch(1);
		getElementUsingInputName("categoryId").sendKeys("" + Keys.DOWN + Keys.DOWN + Keys.DOWN + Keys.ENTER);
		}
	}

	public void selectEnabledOption(String optionValue) {
		getElementUsingInputName("enabled").click();
		// clickElementUsingSpanText(optionValue);
		getElementUsingInputName("enabled").sendKeys("" + Keys.DOWN + Keys.ENTER);
	}

	public void verifyVariousOperationValues(String groupCollectionValue, String enabledValue, String operationName) {
		String GCNAME_XPATH = "//div[text()='"+operationName+"']/../..//td[3]//div";
		String ENABLED_XPATH = "//div[text()='"+operationName+"']/../..//td[4]//div";
		String actualGcName = getDriver().findElement(By.xpath(GCNAME_XPATH)).getText();
		String actualEnabledValue = getDriver().findElement(By.xpath(ENABLED_XPATH)).getText();
		Assert.assertEquals("Actual value of GCName is not matching to expected",groupCollectionValue,actualGcName);
		Assert.assertEquals("Actual value of Enaled Field is not matching to expected",enabledValue,actualEnabledValue);
	}

	public void clickButtonOnConfirmationWindow(String buttonName) {
		waitAndWatch(4);
		clickElementUsingSpanText(buttonName);
		waitAndWatch(2);
	}

	public void selectOperationFromListOptions(String operationName) {
		By operationLoc = By.xpath("//*[contains(text(),'" + operationName + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(operationLoc));
		WebElement operationElm = findDisplayedElement(itsDriver, operationLoc);
		pause(2000);
		jsMoveToElementAndClick(itsDriver, operationElm);
	}

	public void verifyEnabledButtonDisability(String buttonText) {
		By buttonLoc = By.xpath("(//span[text()='" + buttonText + "'])[1]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoc));
		Assert.assertTrue(buttonText + "is not displayed", isElementDisplayed(buttonLoc));
	}

	public void selectGroupInGroupCollectionColumn(String groupCollection) {
		pause(3000);
		By groupCollectionLoc = By.xpath("(//div[contains(@id,'combo')]//div[contains(@id,'picker')])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(groupCollectionLoc));
		WebElement groupCollectionElm = findDisplayedElement(itsDriver, groupCollectionLoc);
		pause(2000);
		jsMoveToElementAndClick(itsDriver, groupCollectionElm);
		pause(2000);
		By groupCollectionOption = By.xpath("//ul[contains(@id,'boundlist')]//li[text()='" + groupCollection + "']");
		wait.until(ExpectedConditions.elementToBeClickable(groupCollectionOption));
		WebElement groupCollectionOptionElm = findDisplayedElement(itsDriver, groupCollectionOption);
		jsMoveToElementAndClick(itsDriver, groupCollectionOptionElm);
		pause(3000);
	}

	public void selectOptionEnabledColumn(String enableOption) {
		pause(3000);
		By groupCollectionLoc = By.xpath("(//div[contains(@id,'combo')]//div[contains(@id,'picker')])[2]");
		wait.until(ExpectedConditions.elementToBeClickable(groupCollectionLoc));
		WebElement groupCollectionElm = findDisplayedElement(itsDriver, groupCollectionLoc);
		pause(2000);
		jsMoveToElementAndClick(itsDriver, groupCollectionElm);
		pause(2000);
		By enableOptionLoc = By.xpath("//ul[contains(@id,'boundlist')]//li[contains(text(),'" + enableOption + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(enableOptionLoc));
		WebElement enableOptionElm = findDisplayedElement(itsDriver, enableOptionLoc);
		enableOptionElm.click();
		pause(2000);
	}

	public void verifyGroupCollectionUnderOperation(String groupCollection, String enabledStatus, String operation) {
		pause(3000);
		By groupCollectionLoc = By
				.xpath("//div[contains(text(),'" + operation + "')]//ancestor::tr//div[contains(text(),'"
						+ groupCollection + "')]//ancestor::tr//div[contains(text(),'" + enabledStatus + "')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupCollectionLoc));
		WebElement groupCollectionElm = findDisplayedElement(itsDriver, groupCollectionLoc);
		Assert.assertTrue(groupCollection + enabledStatus + "Status is not displayed",
				isElementDisplayed(groupCollectionElm));
		pause(5000);
	}

	public void clickEnabledButton(String buttonTextEnbl, String buttonTextDisbl) {
		By buttonTextDisblLoc = By.xpath("//span[contains(@id,'button')][contains(text(),'" + buttonTextDisbl + "')]");
		if (isElementDisplayed(buttonTextDisblLoc)) {
			By buttonTextEnblLoc = By
					.xpath("//span[contains(@id,'button')][contains(text(),'" + buttonTextDisbl + "')]");
			WebElement buttonTextEnblElm = findDisplayedElement(itsDriver, buttonTextEnblLoc);
			wait.until(ExpectedConditions.elementToBeClickable(buttonTextEnblElm));
			moveToElementAndClick(itsDriver, buttonTextEnblElm);
			pause(7000);
		}
	}

	public void validateBCRTaskVisibility(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listSelectedOptionBcrVal.get(Integer.parseInt(bcrIndex));
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'" + projectName
				+ "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElem = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.visibilityOf(taskElem));
		Assert.assertTrue(task + "BCR task is not displayed", isElementDisplayed(taskElem));
	}

	public void clickOnVisibleBCRTask(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listSelectedOptionBcrVal.get(Integer.parseInt(bcrIndex));
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'" + projectName
				+ "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElem = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.elementToBeClickable(taskElem));
		taskElem.click();
	}
}