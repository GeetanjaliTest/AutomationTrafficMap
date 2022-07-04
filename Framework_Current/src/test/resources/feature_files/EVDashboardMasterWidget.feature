Feature: EV Dashboard - Master Widget

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	@RegressionSuite @EvDashBoard @Views
Scenario: Verify Master Widget UI Changes where Search includes Optional, Structure is OBS and Value Type is Total Cost [C1288374]
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on Business Rule Checker drop down and select "Dashboards" option listed with url "${views.dashboard.url}"
	Then I should see "Dashboards" window open	
	When Select "VIEWS5-DEMO 3" option for "Project:" field 
	And Select "OBS" option for "Structure:" field 
	And Select "Total Cost" option for "Value Type:" field 
	And Select "Apr 29, 2001" option for "Reporting Period:" field 
	And Select "3" option for "Structure Level:" field
	And Click on "Search" button in Search page
	Then I should see Master Window displayed
	When I click on arrow widget on Master Window
	Then I should see search options displayed
	When  Click on "Log Out" option 
	Then  Verify "Dashboards" window is closed 
	
	@RegressionSuite @EvDashBoard @Views
Scenario: Verify Master Widget UI Changes where Search is Required, Structure is WBS and Value Type is Hours [C1288375]
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