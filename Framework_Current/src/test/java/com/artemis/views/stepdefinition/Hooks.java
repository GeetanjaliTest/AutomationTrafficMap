//=====================================================================================================================
// Copyright (c) 2017. Aurea Software, Inc. All Rights Reserved.
//
// You are hereby placed on notice that the software, its related technology and services may be covered by one or
// more United States ("US") and non-US patents. A listing that associates patented and patent-pending products
// included in the software, software updates, their related technology and services with one or more patent numbers
// is available for you and the general public's access at www.aurea.com/legal/ (the "Patent Notice") without charge.
// The association of products-to-patent numbers at the Patent Notice may not be an exclusive listing of associations,
// and other unlisted patents or pending patents may also be associated with the products. Likewise, the patents or
// pending patents may also be associated with unlisted products. You agree to regularly review the products-to-patent
// number(s) association at the Patent Notice to check for updates.
//=====================================================================================================================

package com.artemis.views.stepdefinition;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.artemis.views.lib.WebDriverActions;
import com.artemis.views.lib.helper.ScumberException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Hook class to ensure that we create a single browser per scenario and clean
 * up the browser instance. After Hook also has case result collection for
 * TestRail reporting purpose.
 *
 */

public class Hooks {
	private static final Logger Log = Logger.getLogger(Hooks.class.getName());
	private WebDriver itsDriver;

	public Hooks() {
		Log.info("Constructor: Hooks");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
	}

	@After
	public void after(final Scenario scenario) {
		try {
			WebDriverActions.closeBrowser(scenario, itsDriver);
			itsDriver = null;
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}