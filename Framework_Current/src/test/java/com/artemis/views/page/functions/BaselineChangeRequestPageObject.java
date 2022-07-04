package com.artemis.views.page.functions;

import java.util.ArrayList;
import java.util.List;
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
import com.artemis.views.page.locators.BaselineChangeRequestLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Baseline Chnage Request
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class BaselineChangeRequestPageObject extends AbstractBasePage {
	final BaselineChangeRequestLocators bCRLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	private int attempts;

	@Autowired
	public BaselineChangeRequestPageObject(final WebDriver driver) {
		super(driver);
		bCRLoc = PageFactory.initElements(driver, BaselineChangeRequestLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void inputCredSavLoginPage(String username, String password, String dataset) {
		typeEditBox(bCRLoc.usernameTextBoxLoginPage, username);
		typeEditBox(bCRLoc.passwordTextBoxLoginPage, password);
		typeEditBox(bCRLoc.datasetTextBoxLoginPage, dataset);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(bCRLoc.logInButtonLoginPage));
		WebElement logInButtonElm = findDisplayedElement(itsDriver, bCRLoc.logInButtonLoginPage);
		logInButtonElm.click();
	}

	public void verifyLoginSuccessfull(String tabText) {
		By headerTextDisplayed = By.xpath("//span[contains(@id,'bmmenuitembutton')][contains(text(),'" + tabText + "')]");
		WebElement headerTextDisplayedElm = findDisplayedElement(itsDriver, headerTextDisplayed);
		wait.until(ExpectedConditions.visibilityOf(headerTextDisplayedElm));
		Assert.assertTrue("Login is not successful", isElementDisplayed(headerTextDisplayedElm));
	}

	public void clickHeaderMenu(String option) {
		By headerMenuLoc = By.xpath("//span[contains(text(),'" + option + "')]//ancestor::a[contains(@class,'orange-tab')]");
		WebElement headerMenuElm = findDisplayedElement(itsDriver, headerMenuLoc);
		wait.until(ExpectedConditions.elementToBeClickable(headerMenuElm));
		headerMenuElm.click();
	}

	public void verifyPageVisibility(String pageText) {
		By pageLoc = By.xpath("//li[@class='bcLabel'][contains(text(),'" + pageText + "')]");
		WebElement pageElm = findDisplayedElement(itsDriver, pageLoc);
		wait.until(ExpectedConditions.visibilityOf(pageElm));
		Assert.assertTrue("Page text is not displayed", isElementDisplayed(pageElm));
	}

	public void chooseLogoutOption(String optionText) {
		By logOutLoc = By.xpath("//a[contains(text(),'" + optionText + "')]");
		WebElement logOutElm = findDisplayedElement(itsDriver, logOutLoc);
		wait.until(ExpectedConditions.elementToBeClickable(logOutElm));
		logOutElm.click();
	}

	public void verifyHomePageVisibility() {
		Assert.assertFalse(isElementDisplayed(bCRLoc.savHomePage));
	}

	public void clickBcrButton(String btnText) throws InterruptedException {
		By panelItem = By.xpath("//span[contains(@id,'button')][contains(text(), '"
				+ btnText + "')]//ancestor::a[contains(@id,'button')]");
		WebElement panelItemElm = findDisplayedElement(itsDriver, panelItem);
		wait.until(ExpectedConditions.elementToBeClickable(panelItemElm));
		jsExecutor.executeScript("arguments[0].click();", panelItemElm);
	}

	public void verifyOverlayText(String overlayHeader) {
		itsDriver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("AppShowFrame"));
		By overlayLoc = By.xpath(
				"//div[contains(text(),'" + overlayHeader + "')]//ancestor::div[contains(@id,'header-innerCt')]");
		WebElement overlayElm = findDisplayedElement(itsDriver, overlayLoc);
		wait.until(ExpectedConditions.visibilityOf(overlayElm));
		Assert.assertTrue(overlayHeader + "Header is not displayed", isElementDisplayed(overlayElm));
		pause(3000);
	}

	public void selectValueCreateBcr(String fieldValue, String labelName) throws InterruptedException {
		By selectValueLoc = By.xpath("//label[text()='" + labelName + "']//ancestor::tr//input");
		WebElement selectValueElm = findDisplayedElement(itsDriver, selectValueLoc);
		if (!(selectValueElm.getAttribute("value").trim().equals(fieldValue))) {
			WebElement fieldCreateBCR = itsDriver
					.findElement(By.xpath("//label[contains(text(),'" + labelName + "')]//ancestor::tr//input"));
			wait.until(ExpectedConditions.elementToBeClickable(fieldCreateBCR));
			fieldCreateBCR.clear();
			fieldCreateBCR.sendKeys(fieldValue + Keys.ENTER);
			By selectValueOptionLoc = By.xpath("//ul[contains(@class,'list')]//li");
			WebElement selectValueOptionElm = findDisplayedElement(itsDriver, selectValueOptionLoc);
			wait.until(ExpectedConditions.elementToBeClickable(selectValueOptionElm));
			pause(3000);
			while (attempts++ < 3 && isElementDisplayed(selectValueOptionElm)) {
				selectValueOptionElm.click();
			}
		}
	}

	public void verifyValueSelectedCreateBcr(String fieldValue, String labelName) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("AppShowFrame");
		By fieldCreateBCR = By.xpath("//label[contains(text(),'" + labelName + "')]//ancestor::tr//input");
		WebElement fieldCreateBCRElm = findDisplayedElement(itsDriver, fieldCreateBCR);
		wait.until(ExpectedConditions.visibilityOf(fieldCreateBCRElm));
		Assert.assertEquals(fieldValue, fieldCreateBCRElm.getAttribute("value"));
	}

	public void clickButtonCreateBcr(String btnText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("AppShowFrame");
		By createBCrLoc = By.xpath("//span[contains(text(),'" + btnText + "')]");
		WebElement createBCrElm = findDisplayedElement(itsDriver, createBCrLoc);
		wait.until(ExpectedConditions.elementToBeClickable(createBCrElm));
		createBCrElm.click();
	}

	public void verifyOverlayTextConfirmBcr(String overlayText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("AppShowFrame");
		By confirmBcrLoc = By.xpath("//span[contains(text(),'" + overlayText + "')]");
		WebElement confirmBcrElm = findDisplayedElement(itsDriver, confirmBcrLoc);
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBcrLoc));
		Assert.assertTrue("Overlay text is not displayed", isElementDisplayed(confirmBcrElm));
	}

	public void verifyPageTextBcr(String overlayText) {
		itsDriver.switchTo().defaultContent();
		By pageTextLoc = By.xpath("//span[contains(text(),'" + overlayText + "')]");
		WebElement pageTextElm = findDisplayedElement(itsDriver, pageTextLoc);
		wait.until(ExpectedConditions.visibilityOf(pageTextElm));
		Assert.assertTrue("Overlay text is not displayed", isElementDisplayed(pageTextElm));
	}

	public void clickButtonCreateBcrConfirm(String btnText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("AppShowFrame");
		By createBcrConfirmLoc = By.xpath("//span[contains(text(),'" + btnText + "')]");
		WebElement createBcrConfirmElm = findDisplayedElement(itsDriver, createBcrConfirmLoc);
		wait.until(ExpectedConditions.elementToBeClickable(createBcrConfirmElm));
		createBcrConfirmElm.click();
	}

	public void verifyBCRTask(String task, String traceID, String projectName) {
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElm = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.visibilityOf(taskElm));
		Assert.assertTrue(task + "BCR task is not displayed", isElementDisplayed(taskElm));
	}

	public void clickBCRTask(String task, String traceID, String projectName) {
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElm = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.elementToBeClickable(taskElm));
		taskElm.click();
	}

	public void verifyOverlayTextDisplayed(String overlayText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By overTextLoc = By.xpath("//div[contains(text(),'" + overlayText + "')]");
		WebElement overTextElm = findDisplayedElement(itsDriver, overTextLoc);
		wait.until(ExpectedConditions.visibilityOf(overTextElm));
		Assert.assertTrue("Overlay text is not displayed", isElementDisplayed(overTextElm));
	}

	public void expandOverlay(String overlayText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By expandOverlayLoc = By.xpath("//span[contains(text(),'" + overlayText + "')]");
		WebElement expandOverlayElm = findDisplayedElement(itsDriver, expandOverlayLoc);
		wait.until(ExpectedConditions.elementToBeClickable(expandOverlayElm));
		expandOverlayElm.click();
		pause(2000);
	}

	public void verifySuccessMesage(String sucMsg) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By successMessageElm = By.xpath("//textarea[contains(@class,'confMsg')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageElm));
		pause(2000);
		Assert.assertTrue(findDisplayedElement(itsDriver,successMessageElm).getAttribute("value").contains(sucMsg));
	}

	public void verifyOverlayTabDisplayed(String overlayText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By overlayTabLoc = By.xpath("//span[contains(text(),'" + overlayText + "')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(overlayTabLoc));
		WebElement overlayTabElm = findDisplayedElement(itsDriver, overlayTabLoc);
		Assert.assertTrue("Overlay tab is not displayed", isElementDisplayed(overlayTabElm));
	}

	public void verifyValueSelectedBcrTasks(String fieldValue, String labelName) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By fieldCreateBCR = By.xpath("//label[contains(text(),'" + labelName + "')]//ancestor::tr//input");
		WebElement fieldCreateBCRElm = findDisplayedElement(itsDriver, fieldCreateBCR);
		pause(3000);
		wait.until(ExpectedConditions.visibilityOf(fieldCreateBCRElm));
		Assert.assertEquals(fieldValue, fieldCreateBCRElm.getAttribute("value"));
	}

	public void clickButtonCreateBcrTasks(String btnText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By buttonBcrTask = By.xpath("//span[contains(text(),'" + btnText + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(buttonBcrTask));
		WebElement buttonBcrTaskElm = findDisplayedElement(itsDriver, buttonBcrTask);
		jsExecutor.executeScript("arguments[0].click();", buttonBcrTaskElm);
	}

	public void verifyTextConfirmBcr(String overlayText) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("TaskShowFrame");
		By confirmBcrLoc = By.xpath("//span[contains(text(),'" + overlayText + "')]");
		WebElement buttonBcrTaskElm = findDisplayedElement(itsDriver, confirmBcrLoc);
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBcrLoc));
		Assert.assertTrue("Confirm bcr text is not displayed", isElementDisplayed(buttonBcrTaskElm));
	}

	public void verifyBcrStatus(String status, String bcrIndex) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("externalPageFrame");
		String traceID = Constants.listOption.get(Integer.parseInt(bcrIndex));
		By bcrStatusLoc = By.xpath("//div[contains(text(),'" + traceID + "')]//ancestor::tr//div[contains(text(),'" + status + "')]");
		WebElement bcrStatusElm = findDisplayedElement(itsDriver, bcrStatusLoc);
		wait.until(ExpectedConditions.visibilityOf(bcrStatusElm));
		Assert.assertTrue("Bcr status is not displayed", isElementDisplayed(bcrStatusElm));
		itsDriver.switchTo().defaultContent();
	}

	public void inputValueCreateBcr(String fieldValue, String labelName) {
		By fieldCreateBCR = (By.xpath("//label[contains(text(),'" + labelName + "')]//ancestor::tr//input"));
		WebElement fieldCreateBCRElm = findDisplayedElement(itsDriver, fieldCreateBCR);
		wait.until(ExpectedConditions.elementToBeClickable(fieldCreateBCR));
		typeEditBox(fieldCreateBCRElm, fieldValue);
	}

	public void selectFirstOptionInCreateBcr(String labelName) {
		WebElement dropdownElm = itsDriver.findElement(By.xpath("//label[text()='" + labelName
				+ "']//ancestor::tr[contains(@id,'inputRow')]//div[contains(@class,'arrow')]"));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElm));
		moveToElementAndClick(itsDriver, dropdownElm);
		WebElement selectValueElm = findDisplayedElement(itsDriver, bCRLoc.firstDropdownOption);
		wait.until(ExpectedConditions.elementToBeClickable(selectValueElm));
		selectValueElm.click();
	}

	public void storeTraceIdInCreateBcr(String labelName) {
		Constants.listOption
				.add(itsDriver.findElement(By.xpath("//label[text()='" + labelName + "']//ancestor::tr//input"))
						.getAttribute("value").trim());
	}

	public void validateBCRTaskDisplayed(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listOption.get(Integer.parseInt(bcrIndex));
		WebElement taskElem = itsDriver.findElement(By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]"));
		wait.until(ExpectedConditions.visibilityOf(taskElem));
		Assert.assertTrue(task + "BCR task is not displayed", isElementDisplayed(taskElem));
	}

	public void clickOnBCRTask(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listOption.get(Integer.parseInt(bcrIndex));
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElem = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.elementToBeClickable(taskElem));
		taskElem.click();
	}

	public void selectOptionCreateBcr(String fieldValue, String labelName) {
		WebElement dropdownElm = itsDriver.findElement(By.xpath("//label[text()='" + labelName
				+ "']//ancestor::tr[contains(@id,'inputRow')]//div[contains(@class,'arrow')]"));
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElm));
		moveToElementAndClick(itsDriver, dropdownElm);
		By dropdownOption = By.xpath("//ul//li[text()='" + fieldValue + "']");
		WebElement selectValueElm = findDisplayedElement(itsDriver, dropdownOption);
		wait.until(ExpectedConditions.elementToBeClickable(selectValueElm));
		pause(3000);
		selectValueElm.click();
		pause(3000);
	}

	public void storeSelectedTraceIdInCreateBcr(String labelName) {
		Constants.listSelectedOption
				.add(itsDriver.findElement(By.xpath("//label[text()='" + labelName + "']//ancestor::tr//input"))
						.getAttribute("value").trim());
	}

	public void validateBCRTaskVisibility(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listSelectedOption.get(Integer.parseInt(bcrIndex));
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElem = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.visibilityOf(taskElem));
		Assert.assertTrue(task + "BCR task is not displayed", isElementDisplayed(taskElem));
	}

	public void clickOnVisibleBCRTask(String task, String bcrIndex, String projectName) {
		String traceID = Constants.listSelectedOption.get(Integer.parseInt(bcrIndex));
		By taskLoc = By.xpath("//div[contains(@class,'cell-inner')][contains(text(),'"
				+ projectName + "')]//ancestor::tr//div[contains(@class,'cell-inner')][contains(text(),'" + traceID
				+ "')]//ancestor::tr//a[contains(text(),'" + task + "')]");
		WebElement taskElem = findDisplayedElement(itsDriver, taskLoc);
		wait.until(ExpectedConditions.elementToBeClickable(taskElem));
		taskElem.click();
	}

	public void verifyBcrStatusPM(String status, String bcrIndex) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("externalPageFrame");
		String traceID = Constants.listSelectedOption.get(Integer.parseInt(bcrIndex));
		By bcrStatusLoc = By.xpath("//div[contains(text(),'" + traceID + "')]//ancestor::tr//div[contains(text(),'" + status + "')]");
		WebElement bcrStatusElm = findDisplayedElement(itsDriver, bcrStatusLoc);
		wait.until(ExpectedConditions.visibilityOf(bcrStatusElm));
		Assert.assertTrue("Bcr status is not displayed", isElementDisplayed(bcrStatusElm));
		itsDriver.switchTo().defaultContent();
	}

	public void storeSelectedTraceIdInCreateBcrField(String labelName) {
		Constants.listSelectedOptionBcr
				.add(itsDriver.findElement(By.xpath("//label[text()='" + labelName + "']//ancestor::tr//input"))
						.getAttribute("value").trim());
	}

	public void verifyBcrStatusForPM(String status, String bcrIndex) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("externalPageFrame");
		String traceID = Constants.listSelectedOptionBcr.get(Integer.parseInt(bcrIndex));
		By bcrStatusLoc = By.xpath(
				"//div[contains(text(),'" + traceID + "')]//ancestor::tr//div[contains(text(),'" + status + "')]");
		WebElement bcrStatusElm = findDisplayedElement(itsDriver, bcrStatusLoc);
		wait.until(ExpectedConditions.visibilityOf(bcrStatusElm));
		Assert.assertTrue("Bcr status is not displayed", isElementDisplayed(bcrStatusElm));
		itsDriver.switchTo().defaultContent();
	}

	public void storeSelectedTraceIdInCreateBcrFieldValue(String labelName) {
		Constants.listSelectedOptionBcrVal
				.add(itsDriver.findElement(By.xpath("//label[text()='" + labelName + "']//ancestor::tr//input"))
						.getAttribute("value").trim());
	}

	public void validateBcrStatusForPM(String status, String bcrIndex) {
		itsDriver.switchTo().defaultContent();
		itsDriver.switchTo().frame("externalPageFrame");
		String traceID = Constants.listSelectedOptionBcrVal.get(Integer.parseInt(bcrIndex));
		By bcrStatusLoc = By.xpath(
				"//div[contains(text(),'" + traceID + "')]//ancestor::tr//div[contains(text(),'" + status + "')]");
		WebElement bcrStatusElm = findDisplayedElement(itsDriver, bcrStatusLoc);
		wait.until(ExpectedConditions.visibilityOf(bcrStatusElm));
		Assert.assertTrue("Bcr status is not displayed", isElementDisplayed(bcrStatusElm));
		itsDriver.switchTo().defaultContent();
	}
}