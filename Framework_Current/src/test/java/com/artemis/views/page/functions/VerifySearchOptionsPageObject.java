package com.artemis.views.page.functions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.utils.AbstractBasePage;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 */
public class VerifySearchOptionsPageObject extends AbstractBasePage {
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	static final String PROJECT_FIELD = "Project";
	static final String STRUCTURE_FIELD = "Structure";
	static final String TYPE_FIELD = "Type";
	static final String REPORTINGTIME_FIELD = "Reporting Period";
	static final String STRUCTURELEVEL_FIELD = "Structure Level";
	static final String ELEMENTNAME_FIELD = "Element Name";
	static final String ELEMENTRESP1_FIELD = "Element Resp1";
	static final String ELEMENTRESP2_FIELD = "Element Resp2";
	static final String ELEMENTRESP3_FIELD = "Element Resp3";
	static final String ELEMENTRESP4_FIELD = "Element Resp4";
	static final String ELEMENTRESP5_FIELD = "Element Resp5";
	static final String UPARROW_XPATH = "//div[contains(@class,'x-form-spinner x-form-spinner-default x-form-spinner-up')]";
	static final String DOWNARROW_XPATH = "//div[contains(@class,'x-form-spinner x-form-spinner-default x-form-spinner-down')]";

	@Autowired
	public VerifySearchOptionsPageObject(final WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	@FindBys(@FindBy(xpath = "//div[@class='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default ']"))
	private List<WebElement> itsDropDownList;

	@FindBy(xpath = "//div[contains(@class,'x-form-spinner x-form-spinner-default x-form-spinner-up')]")
	private WebElement itsUpArrow;

	@FindBy(xpath = "//div[contains(@class,'x-form-spinner x-form-spinner-default x-form-spinner-down')]")
	private WebElement itsDownArrow;

	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement itsProjectNameDropDown;

	@FindBy(xpath = "//input[@name='structureType']")
	private WebElement itsStructureDropDown;

	@FindBy(xpath = "//input[@name='valueType']")
	private WebElement itsValueTypeDropDown;

	@FindBy(xpath = "//input[@name='reportingPeriod']")
	private WebElement itsReportingPeriodDropDown;

	@FindBy(xpath = "//input[@name='popTime']")
	private WebElement itsPopTimeField;

	public void verifyOptionsListedForRequiredField(String options, String fieldName) {
		String[] optionValues = options.split(",");
		verifyOptionsListed(optionValues);
	}

	public void clickDropDownForField(String fieldName) {
		switch (fieldName) {
		case PROJECT_FIELD:
			waitAndWatch(1);
			typeEditBox(itsProjectNameDropDown, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case STRUCTURE_FIELD:
			waitAndWatch(1);
			typeEditBox(itsStructureDropDown, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case TYPE_FIELD:
			waitAndWatch(1);
			typeEditBox(itsValueTypeDropDown, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case REPORTINGTIME_FIELD:
			waitAndWatch(1);
			typeEditBox(itsReportingPeriodDropDown, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		default:
			Assert.fail("Given Input field is not valid and it's name is: " + fieldName);
			break;
		}
	}

	public void verifyPopTimeValuePopulated(String value) {
		String actualPopTimeValue = getElementUsingInputName("popTime").getAttribute("aria-valuenow");
		Assert.assertEquals("Actual value not matching to expected", value, actualPopTimeValue);
		waitAndWatch(1);
	}

	public void clickParticularArrowOnPopTimeWindow(String arrowName, String hitCount) {
		for (int i = 0; i < Integer.parseInt(hitCount); i++) {
			if (arrowName.equals("UP")) {
				clickElementUsingDivText("Search");
				itsUpArrow = getDriver().findElement(By.xpath(UPARROW_XPATH));
				itsUpArrow.click();
			} else {
				clickElementUsingDivText("Search");
				itsDownArrow = getDriver().findElement(By.xpath(DOWNARROW_XPATH));
				itsDownArrow.click();
			}
		}
	}

	public void verifyListedOptionalFieldValues(String options, String fieldName) {
		String[] optionValues = options.split(",");
		verifyOptionsListed(optionValues);
	}

	public void clickDropDownForOptionalField(String fieldName) {
		WebElement fieldElement;
		switch (fieldName) {
		case STRUCTURELEVEL_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("structureLevel");
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case ELEMENTNAME_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementName");
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case ELEMENTRESP1_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp1");
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case ELEMENTRESP2_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp2");
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case ELEMENTRESP3_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp3");
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		case ELEMENTRESP4_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp4");
			typeEditBox(fieldElement, "" + Keys.DOWN + Keys.TAB);
			waitAndWatch(1);
			break;
		case ELEMENTRESP5_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp5");
			scrollIntoView(fieldElement);
			typeEditBox(fieldElement, "" + Keys.DOWN);
			waitAndWatch(1);
			break;
		default:
			Assert.fail("Given Input field is not valid and it's name is: " + fieldName);
			break;
		}
	}

	private void verifyOptionsListed(String[] optionValues) {
		for (String optionValue : optionValues) {
			assertElementIsVisible(getDriver().findElement(By.xpath("//div[contains(.,'" + optionValue + "')]")),
					"Option Value not present among listed ones");
		}
		clickElementUsingDivText("Search");
		waitAndWatch(1);
	}

	public void selectValueForField(String value, String fieldName) {
		WebElement fieldElement;
		switch (fieldName) {
		case STRUCTURELEVEL_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("structureLevel");
			typeEditBox(fieldElement, value + Keys.ENTER);
			waitAndWatch(1);
			break;
		case ELEMENTNAME_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementName");
			typeEditBox(fieldElement, value + Keys.ENTER);
			waitAndWatch(1);
			break;
		case ELEMENTRESP1_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp1");
			typeEditBox(fieldElement, value + Keys.ENTER);
			waitAndWatch(1);
			break;
		case ELEMENTRESP2_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp2");
			typeEditBox(fieldElement, value + Keys.ENTER);
			waitAndWatch(1);
			break;
		case ELEMENTRESP3_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp3");
			typeEditBox(fieldElement, value + Keys.ENTER + Keys.TAB);
			waitAndWatch(1);
			break;
		case ELEMENTRESP4_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp4");
			typeEditBox(fieldElement, value + Keys.ENTER + Keys.TAB);
			waitAndWatch(1);
			break;
		case ELEMENTRESP5_FIELD:
			waitAndWatch(1);
			fieldElement = getElementUsingInputName("elementResp5");
			typeEditBox(fieldElement, value + Keys.ENTER);
			waitAndWatch(1);
			break;
		default:
			Assert.fail("Given Input field is not valid and it's name is: " + fieldName);
			break;
		}
	}
}