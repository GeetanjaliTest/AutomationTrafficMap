package com.artemis.views.page.functions;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
import com.artemis.views.lib.helper.PropertiesLoader;
import com.artemis.views.lib.utils.AbstractBasePage;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ManageBcrPageObject extends AbstractBasePage {
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;

	@Autowired
	public ManageBcrPageObject(final WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
	}
	final String bcrIdList= getProps().getProperty("scheduleTcrIds");
	static final String CREATE_BCR = "Create BCR";
	static final String CREATE = "Create";
	static final String OK_BUTTON = "OK";
	static final String OK_SMALL_BUTTON = "Ok";
	static final String LOGOUT = "Logout";
	static final String BCR_TASKS = "BCR Tasks";
	static final String BCR = "Baseline Change Request";
	static final String APP_FRAME = "AppShowFrame";
	static final String CREATE_TEXT = " Create";
	static final String BCR_TYPE = "BCR Type";
	static final String PROJECT_NAME = "Project Name";
	static final String TRACE_ID = "Trace ID";
	static final String PRIORITY = "Priority";
	static final String CONF_TEXT = "Confirmation !";
	static final String SEND_FOR_APPROVAL = "Send For Approval";
	static final String SAVE = "Save";
	static final String BACK_TO_TASKLIST = "Back To TaskList";
	static final String REJECT = "Reject";
	static final String COST_TYPE = "Cost Type";
	static final String SCHEDULE_ADJUSTMENT = "Schedule Adjustment";
	static final String TASK_FRAME = "TaskShowFrame";

	@FindBy(id = "login")
	private WebElement itsLoginButton;

	@FindBy(id = "txtBizPassUserID")
	private WebElement itsUserNameTextField;

	@FindBy(id = "txtBizPassUserPassword")
	private WebElement itsPasswordTextField;

	@FindBy(name = "dataset")
	private WebElement itsDataSetTextField;

	@FindBy(xpath = "//span[text()='Create BCR']")
	private WebElement itsCreateBCRButton;

	@FindBy(xpath = "//input[@name='bcrType']")
	private WebElement itsBcrTypeInputField;

	@FindBy(xpath = "//input[@name='projects']")
	private WebElement itsProjectNameInputField;

	@FindBy(xpath = "//input[@name='traceIds']")
	private WebElement itsTraceIdInputField;

	@FindBy(xpath = "//input[@name='priorities']")
	private WebElement itsPriorityInputField;

	@FindBy(xpath = "//input[@name='category']")
	private WebElement itsCategoryInputField;

	@FindBy(xpath = "//span[contains(@id,'searchBtn-btnInnerEl')]")
	private WebElement itsBcrTasksIdentifier;

	@FindBy(xpath = "//a[@href='javascript:goToLogout()']")
	private WebElement itsLogoutButton;

	@FindBys(@FindBy(xpath = "//input[contains(@id,'bcr-costTypeCombo')]"))
	private List<WebElement> itsCostTypeFieldList;

	@FindBy(xpath = "//input[@name='scheduleAdjType']")
	private WebElement itsScheduleTypeField;

	@FindBy(xpath = "//textarea[contains(@id,'vpm-confmsgbox')]")
	private WebElement itsRejectionCommentBox;

	public Properties getProps()
	{
		try
		{
			return PropertiesLoader.getInstance().load("bcr.properties");
		}
		catch (final Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<String> getListOfScheduleIds(String bcrIdList){
		return Arrays.asList(bcrIdList.split(","));
	}
	
	public void openAppUrl(String url) {
		getDriver().get(url);
	}

	public void verifyLoginPageOpened() {
		assertElementIsVisible(itsLoginButton, "Login Page is not verified to be open");
	}

	public void loginUsingCredentials(String userName, String password, String dataset) {
		typeEditBox(itsUserNameTextField, userName);
		typeEditBox(itsPasswordTextField, password);
		typeEditBox(itsDataSetTextField, dataset);
		clickElement(itsLoginButton);
	}

	public void verifyLoggedIn() {
		assertElementIsVisible(itsCreateBCRButton, "User Not logged in properly yet");
	}

	public void clickParticularButtonOnManageBCRPage(String buttonName) {
		switch (buttonName) {
		case CREATE_BCR:
			waitAndWatch(1);
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case CREATE:
			waitAndWatch(1);
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case OK_BUTTON:
			waitAndWatch(1);
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case OK_SMALL_BUTTON:
			waitAndWatch(1);
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case LOGOUT:
			waitAndWatch(2);
			clickElement(itsLogoutButton);
			waitAndWatch(2);
			break;
		case BCR_TASKS:
			waitAndWatch(1);
			clickElementUsingSpanText(buttonName);
			waitAndWatch(5);
			break;
		default:
			Assert.fail("Given button is not available to click and it is: " + buttonName);
			break;
		}
	}

	public void verifyWindowOpened(String windowName) {
		switch (windowName) {
		case BCR:
			getDriver().switchTo().frame(APP_FRAME);
			assertElementIsVisible(getElementUsingSpanText(CREATE_TEXT),
					"Given Title window is not verified to be open");
			break;
		default:
			Assert.fail("Given WindowName is not among available options and it's : " + windowName);
		}
	}

	public void selectValueFromDropDown(String dropDownName, String value) {
		switch (dropDownName) {
		case BCR_TYPE:
			typeEditBox(itsBcrTypeInputField, value);
			clickElement(getListOptionElementUsingText(value));
			break;
		case PROJECT_NAME:
			typeEditBox(itsProjectNameInputField, value);
			clickElement(getListOptionElementUsingText(value));
			break;
		case TRACE_ID:
			typeEditBox(itsTraceIdInputField, value);
			clickElement(getListOptionElementUsingText(value));
			break;
		case PRIORITY:
			typeEditBox(itsPriorityInputField, value);
			clickElement(getListOptionElementUsingText(value));
			break;
		default:
			Assert.fail("Given DropDownOption is not available and it's name is: " + dropDownName);
			break;
		}
	}

	public void inputCategoryValue(String value) {
		typeEditBox(itsCategoryInputField, value);
	}

	public void verifyConfirmationPopUp() {
		waitAndWatch(5);
		assertElementIsVisible(getElementUsingSpanText(CONF_TEXT), "Confirmation Dialog not open");
	}

	public void verifyBCRTaskWindowOpen() {
		waitAndWatch(3);
		assertElementIsVisible(itsBcrTasksIdentifier, "BCR Tasks page could not be verified to be open");
	}

	public void verifyLogOut() {
		assertElementIsVisible(getDriver().findElement(By.id("login")), "Log Out did not happen properly");
	}

	public void clickParticularButtonOnMyTaskPage(String buttonName) {
		if (buttonName.equals(SEND_FOR_APPROVAL)) {
			clickElementUsingSpanText(buttonName);
			waitAndWatch(5);
		} else if (buttonName.equals(SAVE)) {
			clickElementUsingSpanText(buttonName);
			waitAndWatch(3);
		} else if (buttonName.equals(BACK_TO_TASKLIST)) {
			clickElementUsingSpanText(buttonName);
			waitAndWatch(3);
		} else if (buttonName.equals(REJECT)) {
			clickElementUsingSpanText(buttonName);
			waitAndWatch(3);
		} else {
			Assert.fail("Given button not available to click and it is: " + buttonName);
		}
	}

	public void selectTypeField(String selectValue, String bcrId) {
		if (getListOfScheduleIds(bcrIdList).contains(bcrId)) {
			typeEditBox(itsScheduleTypeField, selectValue + Keys.ENTER);
		}
	}

	public void enterEarnedCostType(String earnedCostType) {
		typeEditBox(itsCostTypeFieldList.get(3), earnedCostType);
	}

	public void enterNewPlanCostType(String newPlanCostType) {
		typeEditBox(itsCostTypeFieldList.get(2), newPlanCostType);
	}

	public void enterActualCostType(String actualCostType) {
		typeEditBox(itsCostTypeFieldList.get(1), actualCostType);
	}

	public void enterReplanCostType(String replanCostType) {
		typeEditBox(itsCostTypeFieldList.get(0), replanCostType);
	}

	public void expandSegment(String segmentName, String bcrId) {
		switch (segmentName) {
		case COST_TYPE:
			waitAndWatch(3);
			clickElementUsingSpanText(segmentName);
			waitAndWatch(2);
			break;
		case SCHEDULE_ADJUSTMENT:
			if (getListOfScheduleIds(bcrIdList).contains(bcrId)) {
				waitAndWatch(1);
				clickElementUsingSpanText(segmentName);
				waitAndWatch(1);
			}
			break;
		default:
			Assert.fail("Given Section does not present in list");
			break;
		}
	}

	public void verifySectionDisplayed(String sectionName) {
		switch (sectionName) {
		case COST_TYPE:
			waitAndWatch(3);
			getDriver().switchTo().frame(TASK_FRAME);
			assertElementIsVisible(getElementUsingSpanText(sectionName),
					"Given section is not visible and it's name is: " + sectionName);
			break;
		default:
			Assert.fail("Given Section does not present in list");
			break;
		}
	}

	public void clickInitializeBcrLink(String bcrId) {
		getDriver().findElement(By.xpath("//div[text()='" + bcrId + "']/../..//td[5]//a")).click();
	}

	public void verifyBcrListed(String bcrId) {
		assertElementIsVisible(getElementUsingDivText(bcrId), "Given BCR with this ID doesn't exist");
	}

	public void clickApproveBcrLink(String bcrId) {
		getDriver().findElement(By.xpath("//div[text()='" + bcrId + "']/../..//td[5]//a")).click();
	}

	public void enterCommentForRejection(String comment) {
		typeEditBox(itsRejectionCommentBox, comment);
	}

	public void reconfirmOk(String buttonName) {
		if (buttonName.equals(OK_BUTTON)) {
			waitAndWatch(5);
			getDriver().findElements(By.xpath("//span[text()='OK']")).get(1).click();
			waitAndWatch(2);
		}
	}
}