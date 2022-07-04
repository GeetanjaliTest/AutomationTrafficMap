Feature: This feature is related to Search Options under Views Portal with few scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 
	
@RegressionSuite @SearchOptions @Views
Scenario: Verify Requred Search options drop-down lists [C1288372] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}"
	Then I should see "Views Portal" window open
	When I click on drop down for "Project" field
	Then I should see "VIEWS5-DEMO 3" listed for "Project" required field values
	When I click on drop down for "Structure" field
	Then I should see "WBS,OBS" listed for "Structure" required field values
	When I click on drop down for "Type" field
	Then I should see "Hours,Direct,EQH,Total Cost" listed for "Type" required field values
	#Wrong Test Step - When I click on drop down for "Reporting Period" field
	#Wrong Test Step- Then I should see "Apr 29" listed for "Reporting Period" required field values
	When I select "VIEWS5-DEMO 3" for "Project option" drop down list
	Then I should see "90" for POP time window value populated
	When I click "UP" arrow on POP time window for "1" time
	Then I should see "90" for POP time window value populated
	When I click "DOWN" arrow on POP time window for "10" time
	Then I should see "80" for POP time window value populated
	When I click "UP" arrow on POP time window for "12" time
	Then I should see "90" for POP time window value populated
	When I logout of Views Portal
	Then I should see default login page displayed
	
@RegressionSuite @SearchOptions @Views
Scenario: Verify Optional Search options drop-down lists [C1288373] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}"
	Then I should see "Views Portal" window open
	When I select "VIEWS5-DEMO 3" for "Project option" drop down list
	And I select "OBS" for "Structure option" drop down list
	And I select "Hours" for "Value Type" drop down list
	And I select "Apr 29, 2001" for "Reporting Period" drop down list
	And I select "2" value for "Structure Level" field
	And I click down arrow for "Element Resp1" optional field
	Then I should see "MOYERD,ENG4,H/R GRP,ENG2,POLLARDD,FIN GRP,ENG2,ENG3,ENG3" listed for "Element Resp1" optional field values
	When I select "H/R GRP" value for "Element Resp1" field
	And I click down arrow for "Element Resp2" optional field
	Then I should see "I/S PM,FAB2,BROWNLEJ,QA1,NORTHANN,HUBBARDM,QA5,QA2,FAB1" listed for "Element Resp2" optional field values
	When I select "QA1" value for "Element Resp2" field
	And I click down arrow for "Element Resp3" optional field
	Then I should see "OPS2,ENG5,OPS1" listed for "Element Resp3" optional field values
	When I select "ENG5" value for "Element Resp3" field
	And I click down arrow for "Element Resp4" optional field
	And I click down arrow for "Element Resp5" optional field
	And I logout of Views Portal
	Then I should see default login page displayed