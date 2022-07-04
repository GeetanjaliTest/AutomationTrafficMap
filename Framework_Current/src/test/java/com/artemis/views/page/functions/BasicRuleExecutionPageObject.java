package com.artemis.views.page.functions;

import java.util.List;
import java.util.Properties;
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
import com.artemis.views.page.locators.BasicRuleExecutionLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Basic Rule Execution
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class BasicRuleExecutionPageObject extends AbstractBasePage {
	final BasicRuleExecutionLocators ruleExecLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public BasicRuleExecutionPageObject(final WebDriver driver) {
		super(driver);
		ruleExecLoc = PageFactory.initElements(driver, BasicRuleExecutionLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifySearchFiledDisplayed(String searchText) {
		By searchFieldLoc = By
				.xpath("//div[contains(@id,'searchField')]//input[contains(@placeholder,'" + searchText + "')]");
		WebElement searchFieldElm = findDisplayedElement(itsDriver, searchFieldLoc);
		wait.until(ExpectedConditions.visibilityOf(searchFieldElm));
		Assert.assertTrue(searchText + "Search text is not displayed", isElementDisplayed(searchFieldElm));
	}

	public void verifySearchFiledActive() {
		wait.until(ExpectedConditions.elementToBeClickable(ruleExecLoc.gridSearchBoxRuleExecute));
		Assert.assertTrue(isAttribtuePresent(ruleExecLoc.gridSearchBoxRuleExecute, "value"));
	}

	public void inputDataSearchFiled(String searchText) {
		WebElement gridSearchBoxRuleExecuteField = itsDriver.findElement(ruleExecLoc.gridSearchBoxRuleExecute);
		wait.until(ExpectedConditions.elementToBeClickable(gridSearchBoxRuleExecuteField));
		typeEditBox(gridSearchBoxRuleExecuteField, searchText);
	}

	public void verifySearchTextHighlighted(int searchResultCount, String searchText) {
		List<WebElement> searchResult = itsDriver
				.findElements(By.xpath("//span[contains(text(),'" + searchText + "')]"));
		Assert.assertEquals(searchResultCount, searchResult.size());
	}

	public void clearSearchField() {
		WebElement gridSearchBoxRuleExecuteField = itsDriver.findElement(ruleExecLoc.gridSearchBoxRuleExecute);
		wait.until(ExpectedConditions.elementToBeClickable(gridSearchBoxRuleExecuteField));
		gridSearchBoxRuleExecuteField.clear();
		pause(2000);
	}

	public void verifySearchTextNotHighlighted(int searchResultCount, String searchText) {
		By searchResultCountLoc = By.xpath("//span[contains(text(),'" + searchText + "')]");
		pause(4000);
		Assert.assertFalse(isElementDisplayed(searchResultCountLoc));
	}

	public void clickCheckboxGrid(String ruleName) {
		WebElement checkBoxRule = itsDriver.findElement(
				By.xpath("//div[contains(text(),'" + ruleName + "')]//ancestor::tr//div[contains(@class,'checker')]"));
		wait.until(ExpectedConditions.visibilityOf(checkBoxRule));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxRule));
		checkCheckbox(checkBoxRule);
	}

	public void inputCommnets(String commnets) {
		wait.until(ExpectedConditions.elementToBeClickable(ruleExecLoc.commnetsTextarea));
		typeEditBox(ruleExecLoc.commnetsTextarea, commnets);
	}

	public void clickAllCheckbox() {
		wait.until(ExpectedConditions.elementToBeClickable(ruleExecLoc.checkBoxAll));
		checkCheckbox(ruleExecLoc.checkBoxAll);
	}
}