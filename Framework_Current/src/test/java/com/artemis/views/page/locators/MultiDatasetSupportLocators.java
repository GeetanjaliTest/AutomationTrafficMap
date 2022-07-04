package com.artemis.views.page.locators;

import java.util.List;

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
public class MultiDatasetSupportLocators {
	@Autowired
	public MultiDatasetSupportLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(@class, 'cog')]//ancestor::a")
	public WebElement settingToolbar;

	@FindBy(xpath = "//tr[contains(@class,'grid-row')]")
	public List<WebElement> viewsDataSet;

	@FindBy(xpath = "//div[contains(@id,'tool')]//div[contains(@class,'tick')]")
	public WebElement buttonValidateHeader;

	@FindBy(xpath = "//div[contains(@id,'tool')]//div[contains(@class,'close')]")
	public WebElement buttonDeleteHeader;
}