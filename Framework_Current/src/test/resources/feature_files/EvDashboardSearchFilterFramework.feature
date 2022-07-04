Feature: This feature is related to EV Dashboard with various scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 
	
@RegressionSuite @EvDashBoard @Views
Scenario: Verify Search UI is displayed [C1272936] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then I should see Verify Business Rule Checker Window displayed 
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}" 
	Then I should see "Views Portal" window open 
	When Select "VIEWS5-DEMO 3" option for "Project:" field 
	And Select "OBS" option for "Structure:" field 
	And Select "Total Cost" option for "Value Type:" field 
	And Select "Apr 29, 2001" option for "Reporting Period:" field 
	And I type "60" as time value for POP time window field 
	And I click on "Search" button for Views Dashboard Window 
	Then I should see Master Window displayed 
	When I click on arrow widget on Master Window 
	Then I should see search options displayed 
	When I click on "Reset" button for Views Dashboard Window 
	Then I should see Master Widget as empty 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	
	
@RegressionSuite @EvDashBoard @Views
Scenario: Verify Dashboard perspective is shown in the list [C1263141] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I click on Business Rule Checker drop down
	Then I should see drop down menus <menuItem> in ascending order
	|Artemis Manager|
	|Artemis Project Management|
	|Dashboards|
	|ProjectView|
	|TrackView|
	|User Audit|
	When I click on "Dashboards" menu listed under Business Rule Checker drop down
	Then I should see "Views Portal" window open
	When I logout of Views Portal
	Then I should see default login page displayed

@RegressionSuite @EvDashBoard @Views
Scenario: Verify selection of Dashboard redirects to this application [C1272934] 
	Given I am on Views Login Page
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then I should see Verify Business Rule Checker Window displayed
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}"
	Then I should see "Views Portal" window open
	When I click on Dashboards drop down
	And I click on "User Audit" menu listed under Business Rule Checker drop down
	Then I should see "User Audit" window open
	When I click on User Audit drop down
	And I click on Dashboards drop down
	Then I should see "Dashboards" window open
	When I logout of Views Portal
	Then I should see default login page displayed
	
@RegressionSuite @EvDashBoard @Views
Scenario: Verify Validations are required [C1272935] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then I should see Verify Business Rule Checker Window displayed 
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}" 
	Then I should see "Dashboards" window open 
	When Select "VIEWS5-DEMO 3" option for "Project:" field 
	And I click on "Search" button for Views Dashboard Window 
	Then I should see rest of the mandatory fields being highlighted in red to be filled 
	And Select "WBS" option for "Structure:" field 
	And Select "Hours" option for "Value Type:" field 
	And Select "Apr 29, 2001" option for "Reporting Period:" field 
	And I click on "Search" button for Views Dashboard Window 
	Then I should see Master Window displayed 
	When I click on arrow widget on Master Window 
	Then I should see search options displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed