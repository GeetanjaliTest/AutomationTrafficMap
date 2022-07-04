package com.artemis.views.page.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all locators specific to About Page And Perspective
 * of Artimis Views application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class GroupCollectionManagementLocators {
	@Autowired
	public GroupCollectionManagementLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[contains(@id,'tool')]//div[contains(@class,'plus')])[1]")
	public WebElement buttonAddGroupCollection;

	@FindBy(xpath = "//span[contains(@id,'checkbox')]")
	public WebElement checkBoxGroupCollection;

	@FindBy(xpath = "(//div[contains(@id,'picker')]//ancestor::div[contains(@id,'triggerWrap')])[1]")
	public WebElement dropdownEvaluatuionType;

	@FindBy(xpath = "(//div[contains(@id,'picker')])[2]")
	public WebElement dropdownType;

	@FindBy(xpath = "//tr[contains(@class,'row')]")
	public List<WebElement> rulesCount;

	@FindBy(xpath = "//div[contains(@class,'edit')]")
	public WebElement editButtonGroupManagement;

	@FindBy(xpath = "(//div[contains(@id,'tool')]//div[contains(@class,'plus')])[2]")
	public WebElement buttonAssignedRules;

	public By checkBoxRule = By.xpath("//input[contains(@id,'checkbox')]");

	public By checkBoxGroup = By.xpath("//span[contains(@id,'checkbox')]");
}