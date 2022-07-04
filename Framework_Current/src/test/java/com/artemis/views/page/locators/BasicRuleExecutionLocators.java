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
 * --> This Class contains all locators specific to Basic Rule Execution
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class BasicRuleExecutionLocators {
	@Autowired
	public BasicRuleExecutionLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@id,'textarea')]//textarea")
	public WebElement commnetsTextarea;

	@FindBy(xpath = "(//div[contains(@id,'headercontainer')]//div[contains(@class,'checkbox')]//div)[4]")
	public WebElement checkBoxAll;

	public By gridSearchBoxRuleExecute = By.xpath("//div[contains(@id,'searchField')]//input");
}