package com.artemis.views.page.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all locators specific to Login page of LLM
 * application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ViewsPortalLoginLocators {
	@Autowired
	public ViewsPortalLoginLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='imgcontainer']//img")
	public WebElement imgeArtemisLoginPage;

	@FindBy(xpath = "//div[@class='imgcontainer']//font//b[contains(text(),'VIEWS')]")
	public WebElement textViewsArtemisLoginPage;

	@FindBy(id = "formUserId")
	public WebElement usernameTextBoxLoginPage;

	@FindBy(id = "pwdField")
	public WebElement passwordTextBoxLoginPage;

	@FindBy(id = "formDatasetId")
	public WebElement datasetTextBoxLoginPage;

	@FindBy(id = "newPwdId")
	public WebElement passwordTextBoxLoginFirstTime;

	@FindBy(id = "confirmPwdId")
	public WebElement confirmPasswordTextBoxLoginFirstTime;

	@FindBy(xpath = "//div[@id='openModal']//input[@type='button']")
	public WebElement btnRegisterLoginFirstTime;

	@FindBy(xpath = "//span[contains(@id,'button')][contains(text(),'OK')]")
	public WebElement buttonOKAboutViewsPortal;

	@FindBy(xpath = "//div[contains(@class, 'autocontainer')]//label[contains(@id,'textfield')]//span[contains(text(),'Rule Name:')]")
	public WebElement ruleNameFieldRuleExecution;

	@FindBy(xpath = "//div[contains(@class, 'autocontainer')]//label[contains(@id,'textfield')]//span[contains(text(),'Owner:')]")
	public WebElement ownerFieldRuleExecution;

	@FindBy(xpath = "//div[contains(@class, 'container')]//label[contains(@id,'combo')]//span[contains(text(),'Group Collection:')]")
	public WebElement groupCollectionFieldAdvanced;

	@FindBy(xpath = "//div[contains(@class, 'container')]//label[contains(@id,'tagfield')]//span[contains(text(),'Group:')]")
	public WebElement groupFieldAdvanced;

	@FindBy(id = "loginMsg")
	public WebElement logInPageError;

	@FindBy(xpath = "//span[contains(text(),'Username')]//ancestor::label//following-sibling::div[contains(@id,'textfield')]//input")
	public WebElement userNameProfileDialog;

	@FindBy(xpath = "(//div[contains(@id,'Panel')]//span[contains(@id,'button')][contains(text(),'OK')])[2]")
	public WebElement buttonOKInsidePanel;

	@FindBy(xpath = "//div[contains(@id,'Panel')]//span[contains(@id,'button')][contains(text(),'OK')]")
	public WebElement buttonOKInsidePanelBasicInfo;

	public By loginButtonArtemisLoginPage = By.xpath("//div[@class='dataset']//input[@type='submit']");
	public By profileDropdownButton = By.xpath("//span[contains(@class, 'user')]//ancestor::a");
	public By textBoxPasswordLoginFirstTime = By.id("newPwdId");
	public By headerAboutViewsPortal = By.xpath("//div[contains(@id, 'aboutTabPanel_header-title-textEl')]");
}