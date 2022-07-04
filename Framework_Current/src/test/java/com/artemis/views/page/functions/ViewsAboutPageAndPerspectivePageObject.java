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
import com.artemis.views.page.locators.ViewsAboutPageAndPerspectiveLocators;

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
public class ViewsAboutPageAndPerspectivePageObject extends AbstractBasePage {
	final ViewsAboutPageAndPerspectiveLocators aboutLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public ViewsAboutPageAndPerspectivePageObject(final WebDriver driver) {
		super(driver);
		aboutLoc = PageFactory.initElements(driver, ViewsAboutPageAndPerspectiveLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void clickOkButton(String buttonText) {
		By buttonLoc = By.xpath("//span[contains(@id,'button')][contains(text(),'OK')]");
		WebElement buttonElm = findDisplayedElement(itsDriver, buttonLoc);
		wait.until(ExpectedConditions.elementToBeClickable(buttonElm));
		buttonElm.click();
	}

	public void clickDashboardDropdownOption(String option) {
		wait.until(ExpectedConditions.elementToBeClickable(aboutLoc.locatorBusinessRuleCheckerDropdown));
		aboutLoc.locatorBusinessRuleCheckerDropdown.click();
		By optionLoc = (By.xpath("//span[contains(@id,'menuitem')][contains(text(),'" + option + "')]"));
		WebElement optionElm = findDisplayedElement(itsDriver, optionLoc);
		wait.until(ExpectedConditions.elementToBeClickable(optionElm));
		optionElm.click();
	}

	public void verifyProductVersionAboutPage(String labelName, String value) {
		By prodVersionLoc = By.xpath("//span[contains(text(),'" + labelName
				+ "')]//ancestor::div[contains(@id,'displayfield')]//div[contains(text(),'" + value + "')]");
		WebElement prodVersionElm = findDisplayedElement(itsDriver, prodVersionLoc);
		wait.until(ExpectedConditions.visibilityOf(prodVersionElm));
		Assert.assertTrue(labelName + value + "Header is not displayed", isElementDisplayed(prodVersionElm));
	}

	public void verifyHomePageVisibility(String pageHeader) {
		By headerAboutViewsPortal = By.xpath("//div[contains(@id,'tbtext')][contains(text(),'" + pageHeader + "')]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(headerAboutViewsPortal));
		Assert.assertFalse(isElementDisplayed(headerAboutViewsPortal));
	}

	public void verifyLabelFontAboutPage(String labelName) {
		By aboutPageLabelLoc = By
				.xpath("//span[contains(text(),'" + labelName + "')]//parent::label[contains(@style,'bold')]");
		WebElement aboutPageLabelElm = findDisplayedElement(itsDriver, aboutPageLabelLoc);
		wait.until(ExpectedConditions.visibilityOf(aboutPageLabelElm));
		Assert.assertTrue(labelName + "Label is not displayed", isElementDisplayed(aboutPageLabelElm));
	}

	public void clickExportButtonAboutPage(String buttonName) {
		By exportButtonLoc = By.xpath("//span[contains(text(),'Export')]");
		WebElement exportButtonElm = findDisplayedElement(itsDriver, exportButtonLoc);
		wait.until(ExpectedConditions.elementToBeClickable(exportButtonElm));
		exportButtonElm.click();
	}

	public void clickServerTab(String tabName) {
		By tabNameLoc = By.xpath("//span[contains(@id,'tab')][contains(text(),'" + tabName + "')]");
		WebElement tabNameElm = findDisplayedElement(itsDriver, tabNameLoc);
		wait.until(ExpectedConditions.elementToBeClickable(tabNameElm));
		tabNameElm.click();
	}

	public void verifyDefaultTabSelected(String tabName) {
		By tabNameLoc = By.xpath("//a[contains(@class,'active')]//span[contains(text(),'" + tabName + "')]");
		WebElement tabNameElm = findDisplayedElement(itsDriver, tabNameLoc);
		wait.until(ExpectedConditions.visibilityOf(tabNameElm));
		Assert.assertTrue(tabName + "Tab is not displayed", isElementDisplayed(tabNameElm));
	}
}