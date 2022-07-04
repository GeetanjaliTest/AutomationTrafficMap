package com.artemis.views.page.functions;

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
import com.artemis.views.page.locators.MultiDatasetSupportLocators;

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
public class MultiDatasetSupportPageObject extends AbstractBasePage {
	final MultiDatasetSupportLocators multiLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public MultiDatasetSupportPageObject(final WebDriver driver) {
		super(driver);
		multiLoc = PageFactory.initElements(driver, MultiDatasetSupportLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void clickSettingDropdown(String dropdownOption) {
		wait.until(ExpectedConditions.elementToBeClickable(multiLoc.settingToolbar));
		multiLoc.settingToolbar.click();
		By optionLoc = By.xpath("//span[contains(@id,'menuitem')][contains(text(),'" + dropdownOption + "')]");
		WebElement optionElm = findDisplayedElement(itsDriver, optionLoc);
		wait.until(ExpectedConditions.elementToBeClickable(optionElm));
		optionElm.click();
	}

	public void verifyDatasetListed(String datasetName) {
		By datasetLoc = By
				.xpath("//span[contains(@class, 'text-inner')][contains(text(),'Dataset')]//ancestor::div[contains(@id,'datasetDetailsGrid')]//td[1]//div[contains(text(),'"
						+ datasetName + "')]");
		WebElement datasetElm = findDisplayedElement(itsDriver, datasetLoc);
		wait.until(ExpectedConditions.visibilityOf(datasetElm));
		Assert.assertTrue(datasetName + "Dataset name is not displayed", isElementDisplayed(datasetElm));
	}

	public void verifyOverlayVisibility(String headerText) {
		By dataManagementheader = By
				.xpath("//div[contains(@id, 'header-title-textEl')][contains(text(),'" + headerText + "')]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(dataManagementheader));
		Assert.assertFalse(isElementDisplayed(dataManagementheader));
	}

	public void verifySubOptionsVisibility(String subOptions) {
			By subOptionsLoc = By.xpath("//li[contains(@class, 'selected')]//ul//div[contains(text(), '" + subOptions + "')]");
			WebElement subOptionsElm = findDisplayedElement(itsDriver, subOptionsLoc);
			wait.until(ExpectedConditions.visibilityOf(subOptionsElm));
			Assert.assertTrue(subOptions + "Sub option is not displayed", isElementDisplayed(subOptionsElm));
	}

	public void verifyViewsDataSetVisibility() {
		pause(3000);
		Assert.assertTrue(multiLoc.viewsDataSet.size() > 0);
	}

	public void verifyDefenseDataSetVisibility() {
		pause(3000);
		Assert.assertTrue(multiLoc.viewsDataSet.size() > 0);
	}

	public void verifyDataSetTabVisibility(String dataTab) {
		By dataTabLoc = By.xpath("//span[contains(text(),'" + dataTab + "')]");
		WebElement dataTabElm = findDisplayedElement(itsDriver, dataTabLoc);
		wait.until(ExpectedConditions.visibilityOf(dataTabElm));
		Assert.assertTrue(dataTab + "Data tab is not displayed", isElementDisplayed(dataTabElm));
	}

	public void clickButtonInfoPop(String btnText) {
		By btnTextLoc = By
				.xpath("//div[contains(@id,'messagebox')]//span[contains(text(), '" + btnText + "')]//ancestor::a");
		WebElement btnTextElm = findDisplayedElement(itsDriver, btnTextLoc);
		wait.until(ExpectedConditions.elementToBeClickable(btnTextElm));
		btnTextElm.click();
		pause(2000);
	}

	public void verifyDatasetBase(String databaseName) {
		By databaseNameLoc = By.xpath("//td//div[contains(text(),'" + databaseName + "')]");
		WebElement databaseNameElm = findDisplayedElement(itsDriver, databaseNameLoc);
		wait.until(ExpectedConditions.visibilityOf(databaseNameElm));
		Assert.assertTrue(databaseName + "Database name is not displayed", isElementDisplayed(databaseNameElm));
	}

	public void clickValidateButtonHeader() {
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		wait.until(ExpectedConditions.elementToBeClickable(multiLoc.buttonValidateHeader));
		executor.executeScript("arguments[0].click();", multiLoc.buttonValidateHeader);
		pause(2000);
	}

	public void verifyPopupText(String popupText) {
		By popupTextLoc = By.xpath("//div[contains(@id, 'messagebox')][contains(text(),'" + popupText + "')]");
		WebElement popupTextElm = findDisplayedElement(itsDriver, popupTextLoc);
		wait.until(ExpectedConditions.visibilityOf(popupTextElm));
		Assert.assertTrue(popupText + "Popup text is not displayed", isElementDisplayed(popupTextElm));
	}

	public void clickDeleteButtonHeader() {
		JavascriptExecutor executor = (JavascriptExecutor) itsDriver;
		wait.until(ExpectedConditions.elementToBeClickable(multiLoc.buttonDeleteHeader));
		executor.executeScript("arguments[0].click();", multiLoc.buttonDeleteHeader);
		pause(2000);
	}

	public void verifyErrorInField(String fieldName) {
		By fieldLoc = By.xpath("//span[contains(text(),'" + fieldName
				+ "')]//ancestor::label//following-sibling::div//input[contains(@class,'invalid')]");
		WebElement fieldElm = findDisplayedElement(itsDriver, fieldLoc);
		wait.until(ExpectedConditions.visibilityOf(fieldElm));
		Assert.assertTrue(fieldName + "Field name is not displayed", isElementDisplayed(fieldElm));
	}
}