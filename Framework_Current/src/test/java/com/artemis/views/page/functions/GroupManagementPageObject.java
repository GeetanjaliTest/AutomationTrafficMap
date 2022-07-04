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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.artemis.views.lib.Constants;
import com.artemis.views.lib.utils.AbstractBasePage;
import com.artemis.views.page.locators.GroupCollectionManagementLocators;

/***
 * 
 * @author Rathore Mahipal
 *
 *
 */

public class GroupManagementPageObject extends AbstractBasePage {
	final GroupCollectionManagementLocators groupMngLoc;
	WebDriverWait wait;
	JavascriptExecutor jsExecutor;
	Actions action;
	static final String GROUP_MENU = "Group";
	static final String ADMINISTRATION_MENU = "Administration";
	static final String MANAGEMENT_PANEL = "Group Management";
	static final String ADD_ICON = "Add";
	static final String ADDGROUP_TAB = "Add Group";
	static final String EDITGROUP_TAB = "Edit Group";
	static final String NAME_FIELD = "Name";
	static final String EVALUATIONTYPE_FIELD = "Evaluation Type";
	static final String ACCEPTABLE_FIELD = "Acceptable";
	static final String TYPE_FIELD = "Type";
	static final String TOLERABLE_FIELD = "Tolerable";
	static final String DESCRIPTION_FIELD = "Description";
	static final String SAVE_BUTTON = "Save";
	static final String GROUPCOLLECTION_MENU = "Group Collections";
	static final String GCM_PANEL = "Group Collection Management";
	static final String ADDGC_ICON = "Add";
	static final String GCDETAIL_TITLE = "Group Collection Details";
	static final String EDIT_ICON = "Edit";
	static final String CANCEL_BUTTON = "Cancel";
	static final String ADDICON_XPATH = "//div[@class='x-tool-img x-tool-plus']";
	static final String EDITICON_XPATH = "//div[@class='x-tool-img x-tool-edit']";
	static final String DELETEICON_XPATH = "//div[@class='x-tool-img x-tool-close']";
	static final String ADDASSIGNEDGROUP_ICON = "Add Assigned Group";
	static final String GROUPSELECTION_WINDOW = "Group Selection";
	static final String OK_BUTTON = "OK";
	static final String DELETE_BUTTON = "Delete";
	static final String YES_BUTTON = "Yes";
	static final String DELETE_ICON = "Delete";
	static final String CONFIRMMSG_XPATH = "//div[@class='x-component x-window-text x-box-item x-component-default']";

	@Autowired
	public GroupManagementPageObject(final WebDriver driver) {
		super(driver);
		groupMngLoc = PageFactory.initElements(driver, GroupCollectionManagementLocators.class);
		wait = new WebDriverWait(itsDriver, Constants.pageObjectWaitInSecs);
		jsExecutor = (JavascriptExecutor) itsDriver;
		action = new Actions(getDriver());
	}

	@FindBy(xpath = "//div[contains(text(),'Administration')]")
	private WebElement itsAdminMenu;

	@FindBy(xpath = "//div[text()='Group']")
	private WebElement itsGroupMenu;

	@FindBy(xpath = "//div[@class='x-tool-img x-tool-plus']")
	private WebElement itsGroupAddButton;

	@FindBy(xpath = "//span[contains(text(),'Add Group')]")
	private WebElement itsAddGroupTab;

	@FindBy(xpath = "//textarea[@name = 'description']")
	private WebElement itsDescriptionField;

	@FindBy(xpath = "//span[@data-ref='displayEl']")
	private WebElement itsActiveCheckbox;

	@FindBy(xpath = "//div[@class='x-tool-img x-tool-plus']")
	private WebElement itsGroupCollectionAddButton;

	@FindBy(xpath = "//span[@data-ref='displayEl']")
	private WebElement itsGCMActiveCheckbox;

	@FindBy(xpath = "//div[@class='x-tool-img x-tool-save']")
	private WebElement itsSaveGroupIcon;

	@FindBys(@FindBy(xpath = "//div[@class='x-tool-img x-tool-close']"))
	private List<WebElement> itsDeleteGroupIconList;

	@FindBy(xpath = "//div[@class='x-component x-box-item x-component-default']")
	private WebElement itsConfirmationMessage;

	@FindBys(@FindBy(xpath = "//span[text()='Yes']"))
	private List<WebElement> itsYesButtonList;

	public void clickMenuUnderAdministration(String menuName) {
		getElementUsingDivText(ADMINISTRATION_MENU).click();
		if (menuName.equals(GROUP_MENU)) {
			waitAndWatch(1);
			getDriver().findElement(By.xpath("//div[text()='" + GROUP_MENU + "']")).click();
			waitAndWatch(4);
		} else if (menuName.equals(GROUPCOLLECTION_MENU)) {
			waitAndWatch(1);
			getDriver().findElement(By.xpath("//div[text()='" + GROUPCOLLECTION_MENU + "']")).click();
			waitAndWatch(4);
		} else {
			Assert.fail("Given Menu not available to click and it is: " + menuName);
		}
	}

	public void clickGroupMenuPanelOpen(String menuName) {
		if (menuName.equals(GROUP_MENU)) {
			waitAndWatch(1);
			getDriver().findElement(By.xpath("//div[text()='" + GROUP_MENU + "']")).click();
			waitAndWatch(4);
		} else {
			Assert.fail("Given menu is invalid and it is: " + menuName);
		}
	}

	public void verifyPanelDisplayed(String panelName) {
		if (panelName.equals(MANAGEMENT_PANEL)) {
			waitAndWatch(1);
			assertElementIsVisible(getElementUsingDivText(panelName), "Panel is not visible");
			waitAndWatch(1);
		} else if (panelName.equals(GCM_PANEL)) {
			waitAndWatch(1);
			assertElementIsVisible(getElementUsingDivText(panelName), "Panel is not visible");
			waitAndWatch(1);
		} else {
			Assert.fail("Given Menu not available to click and it is: " + panelName);
		}
	}

	public void clickIconOnGroupManagementScreen(String iconName) {
		switch (iconName) {
		case ADD_ICON:
			clickElement(getDriver().findElement(By.xpath(ADDICON_XPATH)));
			waitAndWatch(2);
			break;
		case EDIT_ICON:
			waitAndWatch(2);
			clickElement(getDriver().findElement(By.xpath(EDITICON_XPATH)));
			waitAndWatch(2);
			break;
		case ADDASSIGNEDGROUP_ICON:
			clickElement(getDriver().findElements(By.xpath(ADDICON_XPATH)).get(1));
			waitAndWatch(2);
			break;
		case DELETE_ICON:
			clickElement(getDriver().findElements(By.xpath(DELETEICON_XPATH)).get(0));
			waitAndWatch(2);
			break;
		default:
			Assert.fail("Given Icon is not present to click and it is: " + iconName);
			break;
		}
	}

	public void verifyTabOpened(String tabName) {
		if (tabName.equals(ADDGROUP_TAB)) {
			assertElementIsVisible(getElementUsingSpanText(tabName), "Add Group tab is not visible");
		} else if (tabName.equals(EDITGROUP_TAB)) {
			assertElementIsVisible(getElementUsingSpanText(tabName), "Edit Group tab is not visible");
		} else {
			Assert.fail("Given tab is not available and it is: " + tabName);
		}
	}

	public void inputFieldValue(String value, String fieldName) {
		switch (fieldName) {
		case NAME_FIELD:
			getElementUsingInputName("groupName").sendKeys(value);
			break;
		case EVALUATIONTYPE_FIELD:
			WebElement evaluationTypeElement = getElementUsingInputName("evaluationType");
			action.moveToElement(evaluationTypeElement).click().sendKeys(Keys.ENTER).build().perform();
			break;
		case ACCEPTABLE_FIELD:
			getElementUsingInputName("expThreshold").clear();
			getElementUsingInputName("expThreshold").sendKeys(value);
			break;
		case TYPE_FIELD:
			getElementUsingInputName("type").clear();
			getElementUsingInputName("type").sendKeys(value + Keys.ENTER);
			break;
		case TOLERABLE_FIELD:
			getElementUsingInputName("minThreshold").clear();
			getElementUsingInputName("minThreshold").sendKeys(value + Keys.ENTER);
			break;
		case DESCRIPTION_FIELD:
			typeEditBox(itsDescriptionField, value);
			break;
		default:
			Assert.fail("Given Field name is not available on Add Tab Screen and it is: " + fieldName);
			break;
		}
	}

	public void clickParticularButtonOnGroupPages(String buttonName) {
		switch (buttonName) {
		case SAVE_BUTTON:
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case CANCEL_BUTTON:
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		default:
			Assert.fail("Given Button is not available to click and it is: " + buttonName);
		}
	}

	public void verifyGroupDisplayed(String groupName) {
		String xpath = "//td[@data-qtip='" + groupName + "']";
		assertElementIsVisible(getDriver().findElement(By.xpath(xpath)), "Group is not listed");
	}

	public void setCheckboxOnAddTab(boolean value) {
		if (value) {
			itsActiveCheckbox.click();
		}
	}

	public void verifyGroupCollectionDetailsWindowOpen() {
		assertElementIsVisible(getElementUsingDivText(GCDETAIL_TITLE),
				"Group Collection Details window is not yet open");
	}

	public void inputNameOnGcdWindow(String collectionName) {
		typeEditBox(getElementUsingInputName("categoryName"), collectionName);
	}

	public void selectTypeOfGcdWindow(String typeOfGcdWindow) {
		typeEditBox(getElementUsingInputName("type"), typeOfGcdWindow + Keys.ENTER);
	}

	public void inputDescrition(String description) {
		typeEditBox(getElementUsingTextAreaName("description"), description);
	}

	public void activateCheckbox() {
		itsGCMActiveCheckbox.click();
	}

	public void verifyGroupCollectionListed(String groupCollectionName) {
		String xpath = "//td[@data-qtip='" + groupCollectionName + "']";
		assertElementIsVisible(getDriver().findElement(By.xpath(xpath)), "Group Collection is not listed");
	}

	public void selectCollectionAmongListed(String collectionName) {
		String xpath = "//td[@data-qtip='" + collectionName + "']";
		clickElement(getDriver().findElement(By.xpath(xpath)));
		waitAndWatch(1);
	}

	public void verifyGroupSelectionWindowOpen() {
		assertElementIsVisible(getElementUsingDivText(GROUPSELECTION_WINDOW),
				"Group Selection window is not open or not visible");
	}

	public void selectGroupForGroupCollection(String groupName) {
		String xpath = "//td[@data-qtip='" + groupName + "']/..//td/div/div";
		clickElement(getDriver().findElement(By.xpath(xpath)));
		waitAndWatch(1);
	}

	public void clickButtonOnGroupSelectionWindow(String buttonName) {
		switch (buttonName) {
		case OK_BUTTON:
			clickElementUsingSpanText(buttonName);
			waitAndWatch(2);
			break;
		case SAVE_BUTTON:
			clickElement(itsSaveGroupIcon);
			waitAndWatch(2);
			break;
		case DELETE_BUTTON:
			clickElement(itsDeleteGroupIconList.get(1));
			waitAndWatch(2);
			break;
		default:
			Assert.fail("Given Button not available and it is: " + buttonName);
			break;
		}
	}

	public void verifyGroupAssignedForGroupCollection(String groupName, String groupCollectionName) {
		assertElementIsVisible(getElementUsingDivText(groupName),
				"Given Group name is not associated with groupCollection namely " + groupCollectionName);
	}

	public void verifySaveMessage(String message) {
		String xpath = "//div[text()='" + message + "']";
		WebElement saveMessageElement = getDriver().findElement(By.xpath(xpath));
		assertElementIsVisible(saveMessageElement, "Save message did not display post save action");
	}

	public void selectGroupFromList(String group) {
		waitAndWatch(1);
		String xpath = "//td[@data-qtip='" + group + "']";
		clickElement(getDriver().findElement(By.xpath(xpath)));
		waitAndWatch(1);
	}

	public void verifyActiveCheckboxState(String checkBoxState) {
		if (checkBoxState.equals("Disabled")) {
			Assert.assertTrue("Active Checkbox is still active",
					getElementUsingInputName("active").getAttribute("aria-readonly").equals("true"));
		} else if (checkBoxState.equals("Enabled")) {
			Assert.assertTrue("Active Checkbox is still active",
					getElementUsingInputName("active").getAttribute("aria-readonly").equals("false"));
		} else {
			Assert.fail("Given Checkbox is not present in present screen and its state should be: " + checkBoxState);
		}
	}

	public void selectCheckboxForGroup(String groupName) {
		String xpath = "//td[@data-qtip='" + groupName + "']";
		getDriver().findElement(By.xpath(xpath)).click();
		waitAndWatch(1);
	}

	public void verifyConfirmationMessage(String message) {
		assertElementIsVisible(itsConfirmationMessage, "Confirmation Message window yet not open or visible");
		Assert.assertTrue("Message in confirmation window differs from expected",
				itsConfirmationMessage.getText().trim().equals(message));
	}

	public void verifyConfirmationMessageGCM(String message) {
		itsConfirmationMessage = getDriver().findElement(By.xpath(CONFIRMMSG_XPATH));
		assertElementIsVisible(itsConfirmationMessage, "Confirmation Message window yet not open or visible");
		Assert.assertTrue("Message in confirmation window differs from expected",
				itsConfirmationMessage.getText().trim().equals(message));
	}

	public void clickButtonOnConfirmationWindow(String buttonName) {
		if (buttonName.equals(YES_BUTTON)) {
			itsYesButtonList.get(0).click();
			waitAndWatch(2);
		} else {
			Assert.fail("Given button not available to click and it's: " + buttonName);
		}
	}

	public void verifyAbsenceOfGroup(String groupName) {
		String xpath = "//td[@data-qtip='" + groupName + "']";
		Assert.assertTrue("Given group name still exists in assigned groups",
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))));
	}

	public void verifyAbsenceOfGroupCollection(String groupCollectionName) {
		String xpath = "//td[@data-qtip='" + groupCollectionName + "']";
		Assert.assertTrue("Given Group Collection name still exists in Group Collections list",
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath))));
	}

	public void clickButtonOnConfirmationWindowForGCM(String buttonName) {
		if (buttonName.equals(YES_BUTTON)) {
			getDriver().findElements(By.xpath("//span[text()='Yes']")).get(0).click();
			waitAndWatch(2);
		} else {
			Assert.fail("Given button not available to click and it's: " + buttonName);
		}
	}

	public void verifyPopupText(String popText, String popTextGroup) {
		WebElement poptextElem = itsDriver.findElement(
				By.xpath("//div[contains(@id,'deleteWarningWin')]//label[contains(text(),'" + popText + "')]"));
		wait.until(ExpectedConditions.visibilityOf(poptextElem));
		Assert.assertTrue(popText + "Text is not show in the Popup", poptextElem.isDisplayed());
		Assert.assertTrue(popTextGroup + "Text is not show in the Popup",
				itsDriver.findElement(By.xpath("//label//b[contains(text(),'" + popTextGroup + "')]")).isDisplayed());
	}

	public void verifyPopupTextGcm(String popText, String popTextGroup) {
		WebElement poptextElem = itsDriver
				.findElement(By.xpath("//div[contains(@id,'messagebox')][contains(text(),'" + popText + "')]"));
		wait.until(ExpectedConditions.visibilityOf(poptextElem));
		Assert.assertTrue(popText + "Text is not show in the Popup", poptextElem.isDisplayed());
		Assert.assertTrue(popTextGroup + "Text is not show in the Popup",
				itsDriver.findElement(By.xpath("//b[contains(text(),'" + popTextGroup + "')]")).isDisplayed());
	}

	public void selectGroupForGroupCollectionManagement(String groupName) {
		pause(2000);
		By checkBoxGroup = 	By.xpath("//div[contains(text(),'" + groupName + "')]//ancestor::tr//div[contains(@class,'checker')]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxGroup));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxGroup));
		WebElement checkBoxGroupElm = findDisplayedElement(itsDriver, checkBoxGroup);
		moveToElementAndJsCheckCheckbox(checkBoxGroupElm);
		pause(3000);
	}

	public void clickAddButtonAssignedGroups() {
		wait.until(ExpectedConditions.elementToBeClickable(groupMngLoc.buttonAssignedRules));
		jsMoveToElementAndClick(itsDriver, groupMngLoc.buttonAssignedRules);
		pause(3000);
		wait.until(ExpectedConditions
				.visibilityOf(itsDriver.findElement(By.xpath("//div[contains(text(),'Group Selection')]"))));
	}
}