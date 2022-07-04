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
 * --> This Class contains all locators specific to About Page And Perspective of Artimis Views
 * application
 * 
 * @author Soumyajit
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class ViewsAboutPageAndPerspectiveLocators {
	@Autowired
	public ViewsAboutPageAndPerspectiveLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, 'buttonAlign')]")
	public WebElement locatorBusinessRuleCheckerDropdown;

}