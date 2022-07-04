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
import com.artemis.views.page.locators.RuleManagementLocators;

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
public class RuleManagementPageObject extends AbstractBasePage {
	final RuleManagementLocators ruleMngLoc;
	final GroupCollectionManagementLocators grpLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public RuleManagementPageObject(final WebDriver driver) {
		super(driver);
		ruleMngLoc = PageFactory.initElements(driver, RuleManagementLocators.class);
		grpLoc = PageFactory.initElements(driver, GroupCollectionManagementLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifyPageHeader(String pagelHeader) {
		By pageHeaderLoc = By.xpath("//div[contains(text(),'" + pagelHeader + "')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeaderLoc));
		pause(3000);
		WebElement pageHeaderElm = findDisplayedElement(itsDriver, pageHeaderLoc);
		Assert.assertTrue(pagelHeader + "Page header is not displayed", isElementDisplayed(pageHeaderElm));
	}

	public void clickAddButton(String btnText) {
		WebElement buttnAddRule = itsDriver
				.findElement(By.xpath("//b[contains(text(),'" + btnText + "')]//ancestor::a"));
		wait.until(ExpectedConditions.elementToBeClickable(buttnAddRule));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", buttnAddRule);
		pause(3000);
	}

	public void inputDataRuleManagement(String inputData, String fieldName) throws TimeoutException {
		WebElement fieldAddGroupMngmnt = itsDriver.findElement(By.xpath(
				"(//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//input)[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldAddGroupMngmnt));
		typeEditBox(fieldAddGroupMngmnt, inputData);
	}

	public void selectOptionThreshold(String option, String fieldName) {
		WebElement dropdown = itsDriver.findElement(By.xpath("(//span[contains(text(),'" + fieldName
				+ "')]//ancestor::div[contains(@id,'combo')]//div[contains(@id,'picker')])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", dropdown);
		WebElement optionSelect = itsDriver.findElement(By.xpath("//li[contains(text(),'" + option + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(optionSelect));
		executor.executeScript("arguments[0].click();", optionSelect);
	}

	public void inputDataFormulaDetails(String inputData) {
		wait.until(ExpectedConditions.elementToBeClickable(ruleMngLoc.formulaDetailsTextarea));
		typeEditBox(ruleMngLoc.formulaDetailsTextarea, inputData);
	}

	public void inputQuery(String inputData, String formulaName) {
		WebElement textQuery = itsDriver.findElement(By.xpath("(//div[contains(text(),'" + formulaName
				+ "')]//ancestor::div[contains(@id,'roweditor')]//textarea)[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(textQuery));
		typeEditBox(textQuery, inputData);
	}

	public void inputDescription(String inputData, String formulaName) {
		WebElement textDescription = itsDriver.findElement(By.xpath("(//div[contains(text(),'" + formulaName
				+ "')]//ancestor::div[contains(@id,'roweditor')]//textarea)[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(textDescription));
		typeEditBox(textDescription, inputData);
	}

	public void verifyQueryVisibility(String query) {
		By queryLoc = By.xpath("//div[contains(@class,'grid')]//div[contains(text(),'" + query + "')]");
		WebElement queryElm = findDisplayedElement(itsDriver, queryLoc);
		wait.until(ExpectedConditions.visibilityOf(queryElm));
		Assert.assertTrue(query + "Query is not displayed", isElementDisplayed(queryElm));
	}

	public void clickButton(String btnText) {
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		WebElement bttnApply = itsDriver
				.findElement(By.xpath("//span[contains(@id,'button')][contains(text(),'" + btnText + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(bttnApply));
		executor.executeScript("arguments[0].click();", bttnApply);
	}

	public void uncheckActiveCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(grpLoc.checkBoxGroupCollection));
		uncheckCheckbox(grpLoc.checkBoxGroupCollection);
	}

	public void clickEditButtonGroupCollection() {
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		wait.until(ExpectedConditions.elementToBeClickable(ruleMngLoc.buttonEditGroupCollection));
		executor.executeScript("arguments[0].click();", ruleMngLoc.buttonEditGroupCollection);
	}

	public void clickAddButtonAssignedRules() {
		wait.until(ExpectedConditions.elementToBeClickable(ruleMngLoc.buttonAddGroupAssgnRule));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", ruleMngLoc.buttonAddGroupAssgnRule);
		wait.until(ExpectedConditions
				.visibilityOf(itsDriver.findElement(By.xpath("(//div[contains(text(),'Rules')])[5]"))));
	}

	public void selectOptionTypeSearchPage(String option, String fieldName) {
		WebElement fieldTypeSearch = itsDriver.findElement(By.xpath(
				"(//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//input)[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldTypeSearch));
		typeEditBox(fieldTypeSearch, option);
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		wait.until(ExpectedConditions.elementToBeClickable(ruleMngLoc.labelTypeRulesOverlay));
		executor.executeScript("arguments[0].click();", ruleMngLoc.labelTypeRulesOverlay);
	}

	public void verifyRuleVisibility(String ruleName) {
		By ruleNameDisplay = By.xpath("//div[contains(@class,'grid')][contains(text(),'" + ruleName + "')]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ruleNameDisplay));
		Assert.assertFalse(isElementDisplayed(ruleNameDisplay));
	}

	public void clickCancelButton(String btnText) {
		By btnLoc = By.xpath("(//span[contains(@id,'button')][contains(text(),'" + btnText + "')])[2]");
		WebElement btnElm = findDisplayedElement(itsDriver, btnLoc);
		wait.until(ExpectedConditions.elementToBeClickable(btnElm));
		btnElm.click();
	}

	public void verifyOverlayHeader(String pagelHeader) {
		By pageHeader = By.xpath("(//div[contains(text(),'" + pagelHeader + "')])[5]");
		WebElement pageHeaderElm = findDisplayedElement(itsDriver, pageHeader);
		wait.until(ExpectedConditions.visibilityOf(pageHeaderElm));
		Assert.assertTrue(pagelHeader + "Header is not displayed", isElementDisplayed(pageHeaderElm));
	}

	public void verifyPopupText(String popText) {
		By popLoc = By.xpath("//b[contains(text(),'" + popText + "')]");
		WebElement popElm = findDisplayedElement(itsDriver, popLoc);
		wait.until(ExpectedConditions.visibilityOf(popElm));
		Assert.assertTrue(popText + "Pop Text is not displayed", isElementDisplayed(popElm));
	}

	public void clickButtonPopup(String btnText) {
		By buttonLoc = By.xpath("//span[contains(@id,'button')][contains(text(),'" + btnText + "')]");
		WebElement buttonElm = findDisplayedElement(itsDriver, buttonLoc);
		wait.until(ExpectedConditions.elementToBeClickable(buttonElm));
		buttonElm.click();
		pause(2000);
	}

	public void verifyOverlayVisibility(String headerText) {
		By dataManagementheader = By
				.xpath("//div[contains(@id, 'configFormulaDetailsPanel')][contains(text(),'" + headerText + "')]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(dataManagementheader));
		Assert.assertFalse(isElementDisplayed(dataManagementheader));
		itsDriver.navigate().refresh();
	}
}