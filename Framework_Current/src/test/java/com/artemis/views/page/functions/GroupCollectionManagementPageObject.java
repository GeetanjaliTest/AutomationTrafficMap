package com.artemis.views.page.functions;

import java.util.Properties;
import java.util.concurrent.TimeoutException;

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
import com.artemis.views.page.locators.GroupCollectionManagementLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class GroupCollectionManagementPageObject extends AbstractBasePage {
	final GroupCollectionManagementLocators groupMngLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public GroupCollectionManagementPageObject(final WebDriver driver) {
		super(driver);
		groupMngLoc = PageFactory.initElements(driver, GroupCollectionManagementLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifyPanelHeader(String panelHeader) {
		By panelHeaderLoc = By
				.xpath("//div[contains(@class,'title-text-default')][contains(text(),'" + panelHeader + "')] ");
		WebElement panelHeaderElm = findDisplayedElement(itsDriver, panelHeaderLoc);
		wait.until(ExpectedConditions.visibilityOf(panelHeaderElm));
		Assert.assertTrue(panelHeader + "Header is not displayed", isElementDisplayed(panelHeaderElm));
	}

	public void clickAddButtonGroupCollection() {
		pause(4000);
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.buttonAddGroupCollection));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", groupMngLoc.buttonAddGroupCollection);
		pause(8000);
	}

	public void inputDataGroupCollection(String inputData, String fieldName) {
		WebElement fieldAddGroupCollection = itsDriver
				.findElement(By.xpath("//div[contains(@id,'configGrpCollWindow')]//span[contains(text(),'" + fieldName
						+ "')]//ancestor::label//following-sibling::div//input"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldAddGroupCollection));
		fieldAddGroupCollection.clear();
		fieldAddGroupCollection.sendKeys(inputData);
	}

	public void inputDataTextareaGroupCollection(String inputData, String fieldName) {
		WebElement textareaAddGroupCollection = itsDriver
				.findElement(By.xpath("//div[contains(@id,'configGrpCollWindow')]//span[contains(text(),'" + fieldName
						+ "')]//ancestor::label//following-sibling::div//textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(textareaAddGroupCollection));
		textareaAddGroupCollection.clear();
		textareaAddGroupCollection.sendKeys(inputData);
	}

	public void checkActiveCheckbox() throws TimeoutException {
		pause(2000);
		WebElement groupCheckBoxElm = findDisplayedElement(itsDriver, groupMngLoc.checkBoxGroup);
		pause(5000);
		moveToElementAndJsCheckCheckbox(groupCheckBoxElm);
		pause(2000);
	}

	public void clickSaveButton(String btnText) {
		WebElement buttonElem = itsDriver
				.findElement(By.xpath("//span[contains(@id,'button')][contains(text(),'" + btnText + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonElem));
		jsMoveToElementAndClick(itsDriver, buttonElem);
		pause(2000);
	}

	public void verifyGroupNameVisible(String groupName) {
		By groupNameLoc = By.xpath("(//div[contains(@class,'grid')][contains(text(),'" + groupName + "')])[1]");
		WebElement groupNameElm = findDisplayedElement(itsDriver, groupNameLoc);
		wait.until(ExpectedConditions.visibilityOf(groupNameElm));
		Assert.assertTrue(groupName + "Group name not displayed", isElementDisplayed(groupNameElm));
	}

	public void inputDataGroupManagement(String inputData, String fieldName) throws TimeoutException {
		pause(10000);
		WebElement fieldAddGroupMngmnt = itsDriver.findElement(By
				.xpath("//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//input"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldAddGroupMngmnt));
		typeEditBox(fieldAddGroupMngmnt, inputData);
	}

	public void selectOptionEvaluationType(String option) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.dropdownEvaluatuionType));
		groupMngLoc.dropdownEvaluatuionType.click();
		By optionLoc = By.xpath("//li[contains(text(),'" + option + "')]");
		WebElement optionElm = findDisplayedElement(itsDriver, optionLoc);
		wait.until(ExpectedConditions.elementToBeClickable(optionElm));
		optionElm.click();
	}

	public void selectOptionType(String option) {
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.dropdownType));
		groupMngLoc.dropdownType.click();
		By optionLoc = By.xpath("//li[contains(text(),'" + option + "')]");
		WebElement optionElm = findDisplayedElement(itsDriver, optionLoc);
		wait.until(ExpectedConditions.elementToBeClickable(optionElm));
		optionElm.click();
	}

	public void inputDataGroupManagementTextarea(String inputData, String fieldName) {
		WebElement fieldAddGroupDescription = itsDriver.findElement(By.xpath(
				"//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//textarea"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldAddGroupDescription));
		typeEditBox(fieldAddGroupDescription, inputData);
	}

	public void selectOptionTypeSearchPage(String option, String fieldName) {
		pause(5000);
		WebElement fieldTypeSearch = itsDriver.findElement(By
				.xpath("//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//input"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldTypeSearch));
		typeEditBox(fieldTypeSearch, option);
		By fieldLoc = By.xpath("//span[contains(text(), '" + fieldName + "')]//parent::label");
		WebElement fieldElm = findDisplayedElement(itsDriver, fieldLoc);
		wait.until(ExpectedConditions.elementToBeClickable(fieldElm));
		fieldElm.click();
	}

	public void clickSearchButton(String btnText) {
		WebElement clickSearchButton = itsDriver
				.findElement(By.xpath("//span[contains(text(),'" + btnText + "')]//ancestor::a"));
		pause(3000);
		wait.until(ExpectedConditions.elementToBeClickable(clickSearchButton));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", clickSearchButton);
		pause(3000);
	}

	public void verifyExistingRulesDisplayed() {
		pause(3000);
		Assert.assertTrue(groupMngLoc.rulesCount.size() > 0);
	}

	public void clickGroupName(String grpName) {
		WebElement groupElm = itsDriver
				.findElement(By.xpath("//div[contains(@class, 'grid')][contains(text(),'" + grpName + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(groupElm));
		pause(6000);
		jsMoveToElementAndClick(itsDriver, groupElm);
		pause(2000);
	}

	public void clickEditButtonGroupName() {
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.editButtonGroupManagement));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", groupMngLoc.editButtonGroupManagement);		
	}

	public void verifyTabTextDisplayed(String tabText) {
		By tabLoc = By.xpath("//span[contains(text(), '" + tabText + "')]");
		WebElement tabElm = findDisplayedElement(itsDriver, tabLoc);
		wait.until(ExpectedConditions.visibilityOf(tabElm));
		Assert.assertTrue(tabText + "Tab text is not displayed", isElementDisplayed(tabElm));
	}

	public void clickOnButton(String btnText) throws TimeoutException {
		pause(2000);
		By buttonLoc = By.xpath("//span[contains(@id,'button')][contains(text(),'" + btnText + "')]");
		WebElement buttonElm = findDisplayedElement(itsDriver, buttonLoc);
		waitForAtLeastOneElementToAppear(buttonLoc, 30);
		jsMoveToElementAndClick(itsDriver, buttonElm);
		pause(2000);
	}

	public void checkActiveCheckboxRuleDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.checkBoxRule));
		WebElement checkBoxRuleElm = findDisplayedElement(itsDriver, groupMngLoc.checkBoxRule);
		moveToElementAndCheckCheckbox(checkBoxRuleElm);
	}
}