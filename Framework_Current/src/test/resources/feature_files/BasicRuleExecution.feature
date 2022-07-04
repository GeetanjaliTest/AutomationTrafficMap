Feature: Basic Rule Execution 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1118679
	@SmokeSuite @BasicRuleExecution @Views
Scenario: Rule Execution Grid Search [C1118679] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Basic" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Basic" option 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	And Verify "Grid Search Text" field is displayed 
	And Verify Grid Search Field is active 
	When Input "IMS" in Grid Search box 
	Then Verify "12 Matches" page is displayed 
	And Verify all 12 "IMS" are highlighted 
	When Clear the Grid search field 
	And Verify all 12 "IMS" are not highlighted 
	When Input "LEADS" in Grid Search box 
	Then Verify "1 Matches" page is displayed 
	And Verify all 1 "LEADS" are highlighted 
	When Clear the Grid search field 
	And Verify all 1 "LEADS" are not highlighted 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1118681
	@SmokeSuite @BasicRuleExecution @Views
Scenario: Execute a single rule [C1118681] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Basic" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Basic" option 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When Cick on "IMS-LAGS" checkbox 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in Group Collection 
	Then Verify "Run Result" window is displayed in the dialog 
	When Input "Execute a single rule" in comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1118682
	@SmokeSuite @BasicRuleExecution @Views
Scenario: Execute ALL rules [C1118682] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Basic" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Basic" option 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When Click on all checkbox 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in Group Collection 
	Then Verify "Run Result" window is displayed in the dialog 
	When Input "Execute ALL rules" in comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 