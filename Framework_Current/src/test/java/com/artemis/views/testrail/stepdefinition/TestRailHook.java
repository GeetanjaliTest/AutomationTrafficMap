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

package com.artemis.views.testrail.stepdefinition;

import com.crossover.testrail.integration.TestRailListener;
import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * 
 * Hook class to instantiate the test rail listener. To be notified about
 * individual results (Pass or Fail)
 * 
 */

public class TestRailHook {
	@After
	public void after(final Scenario scenario) throws Exception {
		final TestRailListener listener = TestRailListener.instance();

		if (listener != null)
			listener.addResult(scenario);
	}
}