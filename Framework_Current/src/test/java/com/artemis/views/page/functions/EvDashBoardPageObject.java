package com.artemis.views.page.functions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.utils.AbstractBasePage;

import cucumber.api.DataTable;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 */
public class EvDashBoardPageObject extends AbstractBasePage {
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	static final String VIEWS_PORTAL= "Views Portal";
	static final String USER_AUDIT = "User Audit";
	static final String DASHBOARDS = "Dashboards";
	static final String PROJECT_OPTION ="Project option";
	static final String STRUCTURE_OPTION = "Structure option";
	static final String VALUE_TYPE = "Value Type";
	static final String REPORTING_PERIOD = "Reporting Period";
	static final String SEARCH = "Search";
	static final String RESET= "Reset";
	static final String LOG_OUT = "Log Out";
	static final String BUSINESS_RULE_CHECKER = "Business Rule Checker";
	
	@Autowired
	public EvDashBoardPageObject(final WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}

	@FindBy(xpath = "//input[@value='LOGIN']")
	private WebElement itsLoginButton;

	@FindBy(id = "formUserId")
	private WebElement itsUserNameField;

	@FindBy(id = "pwdField")
	private WebElement itsPasswordField;

	@FindBy(id = "formDatasetId")
	private WebElement itsDatasetField;
	
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement	itsProjectNameDropDown;
	
	
	@FindBy(xpath = "//input[@name='structureType']")
	private WebElement	itsStructureDropDown;
	
	
	@FindBy(xpath = "//input[@name='valueType']")
	private WebElement	itsValueTypeDropDown;
	
	@FindBy(xpath = "//input[@name='reportingPeriod']")
	private WebElement	itsReportingPeriodDropDown;
	
	@FindBy(xpath = "//input[@name='popTime']")
	private WebElement	itsPopTimeField;
	
	@FindBys(@FindBy(xpath = "//table[@class='x-grid-item']"))
	private List<WebElement>	itsTableItemsMasterWidget;

	@FindBy(xpath = "//div[contains(@data-ref,'collapseEl')]/..")
	private WebElement	itsSearchPanelButton;
	
	@FindBy(xpath = "//div[contains(@id,'evSearchPanel') and @data-ref='textEl']")
	private WebElement	itsSearchPanelSearchOption;
	
	@FindBys(@FindBy(xpath = "//span[@class='x-btn-wrap x-btn-wrap-default-toolbar-small x-btn-arrow x-btn-arrow-right' and @data-ref='btnWrap']"))
	private List<WebElement> itsPanelButtonList;
	
	@FindBys(@FindBy(xpath = "//input[contains(@data-errorqtip,'This field is required')]"))
	private List<WebElement>	itsSearchFieldsPostErrorList;

	@FindBy(xpath = "//input[@name='structureLevel']")
	private WebElement itsStructureLevelDropDown;

	public void verifyLoginPageOpen() {
		assertElementIsVisible(itsLoginButton, "Login Page open could not be verified");
	}

	public void loginViewsPortalUsingCredentials(String userName, String password, String dataset) {
		wait.until(ExpectedConditions.elementToBeClickable(itsLoginButton));
		typeEditBox(itsUserNameField, userName);
		typeEditBox(itsPasswordField, password);
		typeEditBox(itsDatasetField, dataset);
		clickElement(itsLoginButton);
	}

	public void verifyBusinessRuleCheckerWindowDisplayed() {
		waitAndWatch(5);
		assertElementIsVisible(getElementUsingSpanText("Business Rule Checker"),
				"Business Rule checker window could not be verified to open");
	}

	public void selectOptionFromBusinessRulecheckerDropDown(String optionName, String url) {
		WebElement businessRuleCheckerDropDown = getElementUsingSpanText("Business Rule Checker");
		businessRuleCheckerDropDown.click();
		getDriver().get(url);
		waitAndWatch(5);
	}

	public void verifyWindowOpen(String windowName) {
		if (windowName.equals(VIEWS_PORTAL)) {
			waitAndWatch(5);
			assertElementIsVisible(getElementUsingDivText("Views Portal"),
					"Element having Views portal text could not be verified to be present");
		}else if(windowName.equals(USER_AUDIT)){
			waitAndWatch(5);
			assertElementIsVisible(getElementUsingDivText("User Audit"),
					"Element having User Audit text as title could not be verified to be present");
		}else if(windowName.equals(DASHBOARDS)){
			waitAndWatch(5);
			assertElementIsVisible(getElementUsingDivText("Dashboards"),
					"Element having User Audit text as title could not be verified to be present");
		}
		else {
			Assert.fail("Window given is not verifief to be open and it is: " + windowName);
		}
	}
	
	public void selectDropDownWithValue(String value, String dropDownOption) {
		switch (dropDownOption) {
		case PROJECT_OPTION:
			waitAndWatch(1);
			typeEditBox(itsProjectNameDropDown, value+Keys.ENTER);
			waitAndWatch(1);
			break;
		case STRUCTURE_OPTION:
			waitAndWatch(1);
			typeEditBox(itsStructureDropDown, value+Keys.ENTER);
			waitAndWatch(1);
			break;
		case VALUE_TYPE:
			waitAndWatch(1);
			typeEditBox(itsValueTypeDropDown, value+Keys.ENTER);
			waitAndWatch(1);
			break;
		case REPORTING_PERIOD:
			waitAndWatch(1);
			typeEditBox(itsReportingPeriodDropDown, value+Keys.ENTER);
			waitAndWatch(1);
			break;
		default:
			Assert.fail("Given Drop Down option is invalid and it is: " + dropDownOption);
			break;
		}
	}

	public void inputTypeValue(String timeValue) {
		typeEditBox(itsPopTimeField, timeValue);
	}

	public void clickPartcularButtonOnViewsDashBoard(String buttonName) {
		switch(buttonName){
			case SEARCH:
				clickElementUsingSpanText(buttonName);
				break;
			case RESET:
				clickElementUsingSpanText(buttonName);
				break;
			default:
					Assert.fail("Given Button name is not available to click and it is: "+buttonName);
		}
	}

	public void verifyMasterWindowOpen() {
		waitAndWatch(4);
		assertElementIsVisible(getElementUsingDivText("Master Widget"), "Master Widget not open");
		Assert.assertTrue("Master Widget has no Data", itsTableItemsMasterWidget.size()>0);
	}

	public void openSearchOptionsWidget() {
		Actions action= new Actions(getDriver());
		action.moveToElement(itsSearchPanelButton).click(itsSearchPanelButton).build().perform();
	}

	public void verifySearchOptionsDisplayed() {
		assertElementIsVisible(itsSearchPanelSearchOption, "Search Panel open after collapse button click could not be verified");
	}

	public void verifyMasterWidgetEmpty() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Master Widget']")));
	}

	public void logOutViewsPortal() {
		itsPanelButtonList.get(2).click();
		getElementUsingSpanText(LOG_OUT).click();
		waitAndWatch(3);
	}

	public void verifyDefaultLogout() {
		WebElement loginButton=getDriver().findElement(By.xpath("//input[@value='LOGIN']"));
		assertElementIsVisible(loginButton, "Default post log out screen could not be verified");
		waitAndWatch(2);
	}

	public void verifyDropDownMenuList(DataTable menuItemList) {
		for(String menuItem:menuItemList.asList(String.class)){
		assertElementIsVisible(getElementUsingSpanText(menuItem), "Given Menu item could not be verified");
		}
	}

	public void clickMenuUnderBusinessRuleCheckerDropDown(String menuItem) {
		getElementUsingSpanText(menuItem).click();
	}

	public void clickBusinessRulecheckerDropDown() {
		WebElement businessRuleCheckerDropDown = getElementUsingSpanText(BUSINESS_RULE_CHECKER);
		businessRuleCheckerDropDown.click();
		waitAndWatch(1);
	}

	public void verifyMandatoryFieldsHighlighted() {
		waitAndWatch(1);
		Assert.assertTrue("Mandatory Search fields are not verified",itsSearchFieldsPostErrorList.size()>0);
	}

	public void clickDashboardsDropDown() {
		WebElement dashboardsDropDown = getElementUsingSpanText(DASHBOARDS);
		dashboardsDropDown.click();
		waitAndWatch(1);
	}

	public void clickUserAuditDropDown() {
		WebElement userAuditDropDown = getElementUsingSpanText(USER_AUDIT);
		userAuditDropDown.click();
		waitAndWatch(1);
	}

	public void selectOptionInSearchField(String option, String fieldName) {
		itsDriver.findElement(By.xpath("//span[text()='" + fieldName
				+ "']//ancestor::div[contains(@id,'combo')]//div[contains(@id,'picker')]")).click();
		waitAndWatch(4);
		itsDriver.findElement(By.xpath("//li[text()='" + option + "']")).click();
	}
}