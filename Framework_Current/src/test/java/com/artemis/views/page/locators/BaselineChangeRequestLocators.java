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
 * --> This Class contains all locators specific to Baseline Change Request
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class BaselineChangeRequestLocators {
	@Autowired
	public BaselineChangeRequestLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txtBizPassUserID")
	public WebElement usernameTextBoxLoginPage;

	@FindBy(id = "txtBizPassUserPassword")
	public WebElement passwordTextBoxLoginPage;

	@FindBy(xpath = "//label[contains(text(), 'Dataset')]//ancestor::span//following-sibling::input[@class= 'InptTxt']")
	public WebElement datasetTextBoxLoginPage;

	public By firstDropdownOption = By.xpath("//ul[contains(@class,'list')]//li[1]");

	public By logInButtonLoginPage = By.id("login");
	public By savHomePage = By.xpath("//span[@class='welcomeTitle']");
}