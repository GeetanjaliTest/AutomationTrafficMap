package com.artemis.views.page.functions;

import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.helper.PropertiesLoader;
import com.artemis.views.lib.utils.AbstractBasePage;
import com.artemis.views.page.locators.AdvancedRuleExecutionLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Advanced Rule Execution of
 * Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class AdvancedRuleExecutionPageObject extends AbstractBasePage {
	final AdvancedRuleExecutionLocators advRuleExecLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public AdvancedRuleExecutionPageObject(final WebDriver driver) {
		super(driver);
		advRuleExecLoc = PageFactory.initElements(driver, AdvancedRuleExecutionLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifySearchFiledDisplayed(String searchText) {
		By searchTextLoc = By
				.xpath("//div[contains(@id,'searchField')]//input[contains(@placeholder,'" + searchText + "')]");
		WebElement searchTextElm = findDisplayedElement(itsDriver, searchTextLoc);
		wait.until(ExpectedConditions.visibilityOf(searchTextElm));
		Assert.assertTrue(searchText + "Search text is not displayed", isElementDisplayed(searchTextElm));
	}

	public void verifySearchFiledActive() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(advRuleExecLoc.gridSearchBoxRuleExecute));
		Assert.assertTrue(isAttribtuePresent(advRuleExecLoc.gridSearchBoxRuleExecute, "value"));
	}

	public void selectOptionEvaluationType(String option, String fieldName) {
		WebElement clickdropdown = itsDriver.findElement(By.xpath("//span[text()='" + fieldName
				+ "']//ancestor::div[contains(@class,'field')]//div[contains(@class,'arrow')]"));
		wait.until(ExpectedConditions.elementToBeClickable(clickdropdown));
		pause(5000);
		clickdropdown.click();
		WebElement optionText = itsDriver.findElement(By.xpath("//li[contains(text(),'" + option + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(optionText));
		jsExecutor.executeScript("arguments[0].click();", optionText);
	}

	public void clickDeleteButtonHeader() {
		wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonDeleteHeader));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", advRuleExecLoc.buttonDeleteHeader);
		pause(2000);
	}

	public void verifyGroupStatus(String status, String groupName) {
		By groupStatusLoc = By.xpath("//div[contains(@id,'runstatusGrid')]//span[contains(text(),'" + groupName
				+ "')]//ancestor::tr//b[contains(text(),'" + status + "')]");
		WebElement groupStatusElm = findDisplayedElement(itsDriver, groupStatusLoc);
		wait.until(ExpectedConditions.visibilityOf(groupStatusElm));
		Assert.assertTrue(status + groupName + "Search text is not displayed", isElementDisplayed(groupStatusElm));
	}

	public void clickSaveButtonAssignedRules() {
		wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonSaveGroupAssgnRule));
		jsExecutor.executeScript("arguments[0].click();", advRuleExecLoc.buttonSaveGroupAssgnRule);
	}

	public void selectOption(String option, String fieldName) {
		WebElement fieldTypeSearch = itsDriver.findElement(By.xpath(
				"(//span[contains(text(),'" + fieldName + "')]//ancestor::label//following-sibling::div//input)[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldTypeSearch));
		pause(2000);
		typeEditBox(fieldTypeSearch, option);
		pause(2000);
		fieldTypeSearch.sendKeys(Keys.ENTER);
	}

	public void clickAddButtonAssignedGroups(String overlayName) {
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonAddGroupAssgnRule));
		executor.executeScript("arguments[0].click();", advRuleExecLoc.buttonAddGroupAssgnRule);
		wait.until(ExpectedConditions.visibilityOf(itsDriver.findElement(
				By.xpath("//div[contains(@id,'assignGroupsWindow')][contains(text(),'" + overlayName + "')]"))));
	}

	public void clickPopupButton(String btnText) {
		By locatorButton = By
				.xpath("//div[contains(@class,'closable')]//span[contains(text(),'" + btnText + "')]//ancestor::a");
		WebElement visibleButton = findDisplayedElement(itsDriver, locatorButton);
		wait.until(ExpectedConditions.elementToBeClickable(visibleButton));
		visibleButton.click();
		pause(2000);
	}

	public void inputCommnets(String commnets) {
		WebElement visibleTextarea = findDisplayedElement(itsDriver, advRuleExecLoc.overlayTextarea);
		wait.until(ExpectedConditions.elementToBeClickable(visibleTextarea));
		typeEditBox(visibleTextarea, commnets);
	}

	public void clickDeleteButtonGroupManagementHeader() {
		wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonDeleteGroupHeader));
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		executor.executeScript("arguments[0].click();", advRuleExecLoc.buttonDeleteGroupHeader);
		pause(2000);
	}

	public void deleteGroupNameGroupName(String grpName) {
		By groupNameLoc = By.xpath("//div[contains(@id,'groupDetails')]//div[text()='" + grpName + "']");
		if (isElementDisplayed(groupNameLoc)) {
			WebElement groupNameElm = findDisplayedElement(itsDriver, groupNameLoc);
			wait.until(ExpectedConditions.elementToBeClickable(groupNameElm));
			moveToElementAndClick(itsDriver, groupNameElm);
			pause(6000);
			wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonDeleteGroupHeader));
			jsMoveToElementAndClick(itsDriver, advRuleExecLoc.buttonDeleteGroupHeader);
			By butonText = By.xpath("//span[contains(@id,'button')][contains(text(),'Yes')]");
			WebElement butonTextElm = findDisplayedElement(itsDriver, butonText);
			pause(4000);
			wait.until(ExpectedConditions.elementToBeClickable(butonTextElm));
			jsMoveToElementAndClick(itsDriver, butonTextElm);
			pause(3000);
		}
	}

	public void deleteGroupNameGroup(String grpName) {
		By groupNameLoc = By.xpath("//div[contains(@id,'grpcoll')]//div[text()='" + grpName + "']");
		if (isElementDisplayed(groupNameLoc)) {
			WebElement groupNameElm = findDisplayedElement(itsDriver, groupNameLoc);
			wait.until(ExpectedConditions.elementToBeClickable(groupNameElm));
			moveToElementAndClick(itsDriver, groupNameElm);
			pause(6000);
			wait.until(ExpectedConditions.elementToBeClickable(advRuleExecLoc.buttonDeleteGroupHeader));
			jsMoveToElementAndClick(itsDriver, advRuleExecLoc.buttonDeleteGroupHeader);
			By butonText = By.xpath("//span[contains(@id,'button')][contains(text(),'Yes')]");
			WebElement butonTextElm = findDisplayedElement(itsDriver, butonText);
			pause(4000);
			wait.until(ExpectedConditions.elementToBeClickable(butonTextElm));
			jsMoveToElementAndClick(itsDriver, butonTextElm);
			pause(3000);
		}
	}
}