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
 * --> This Class contains all locators specific to Advanced Rule Execution of
 * Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class AdvancedRuleExecutionLocators {
	@Autowired
	public AdvancedRuleExecutionLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@id,'textarea')]//textarea")
	public WebElement commnetsTextarea;

	@FindBy(xpath = "(//div[contains(@id,'headercontainer')]//div[contains(@class,'checkbox')]//div)[4]")
	public WebElement checkBoxAll;

	@FindBy(xpath = "(//div[contains(@id,'tool')]//div[contains(@class,'close')])[2]")
	public WebElement buttonDeleteHeader;

	@FindBy(xpath = "(//div[contains(@id,'tool')]//div[contains(@class,'close')])[1]")
	public WebElement buttonDeleteGroupHeader;

	@FindBy(xpath = "//div[contains(@id,'tool')]//div[contains(@class,'save')]")
	public WebElement buttonSaveGroupAssgnRule;

	@FindBy(xpath = "(//div[contains(@id,'tool')]//div[contains(@class,'plus')])[2]")
	public WebElement buttonAddGroupAssgnRule;

	public By gridSearchBoxRuleExecute = By.xpath("//div[contains(@id,'searchField')]//input");
	public By overlayTextarea = By.xpath("//div[contains(@id,'textarea')]//textarea");
}