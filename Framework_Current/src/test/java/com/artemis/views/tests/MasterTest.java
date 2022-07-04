package com.artemis.views.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.crossover.testrail.integration.TestRailRunner;
import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;

@RunWith(TestRailRunner.class)
@CucumberOptions(features = { "classpath:feature_files/" }, glue = { "com.artemis.views.stepdefinition", 
		"com.artemis.views.testrail.stepdefinition"  }, plugin = { "pretty", "json:target/cucumber",
		"com.cucumber.listener.ExtentCucumberFormatter" })

public class MasterTest {
	@BeforeClass
	public static void setup() {
		// Initiates the extent report and generates the output in the
		// output/Run_<unique timestamp>/report.html file by default.
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

		// Also you can add system information using a hash map
		final Map<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("Cucumber version", "v1.2.4");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}
}