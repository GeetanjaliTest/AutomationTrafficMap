Feature: About Page and Perspective 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1027453
	@SmokeSuite @RuleManagement @Views
Scenario: Create a Single Threshold New Rule [C1027453] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Rule" from left side menu panel under option 
	Then Verify "Search" page is displayed 
	When Click on "Add" button
	Then Verify "Rule Details" page is displayed 
	When Input "MRTBEISingle" in "Name" field in Group Management 
	When Input "DCMA" in "Type" field in Rule Management
	When Input "1" in "Weight" field in Group Management  
	And Input "Single Threshold rule for the BEI metric. The Baseline Execution Index (BEI) metric that calculates the efficiency with which tasks have been accomplished when measured against the baseline tasks" in "Description" textarea in Group Management 
	And Select "Single" as "Threshold Type"
	When Input "#RFR# >= 1" in "On Track" field in Group Management 
	And Check Active checkbox 
	And Click on "Next" button in Group Collection
	Then Verify "Formula Details" page is displayed  
	And Input "#TNTC#/#BC#" in Formula Details textarea
	And Click on "Apply" button in Group Collection
	Then Verify "BC" page is displayed  
	Then Verify "TNTC" page is displayed 
	When Click on "BC" group name  
	Then Verify "BC" page is displayed
	When Input "select count(*) from av_activity where proj = #PROJECT# and ver = (select bver from av_project where proj = #PROJECT#) and ef < (select otn from av_version where proj = #PROJECT# and ver = #VERSION#) and atyp <> 'H' and od > 0 and evmethod <> 'D'" in "BC" query textarea
	When Input "Baseline Count (BC): Number of activities with a baseline finish date within time now" in "BC" description textarea
	And Click on "Apply" button in Formula Details
	Then Verify query "select" is displayed
	When Click on "TNTC" group name  
	Then Verify "TNTC" page is displayed 
	When Input "select count(*) from av_activity where proj=#PROJECT# and ver=#VERSION# and afd < (select otn from av_version where proj=#PROJECT# and ver=#VERSION# ) and atyp <> 'H' and od > 0 and evmethod <> 'D'" in "TNTC" query textarea
	When Input "Total Number of Activities Completed (TNTC): Number of activities with an Actual finish date within time now" in "TNTC" description textarea
	And Click on "Apply" button in Formula Details
	Then Verify query "select count" is displayed
	And Click on "Save" button in Group Collection
	Then Verify "Formula Details" Portal is closed in rules overlay
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page  
	Then Verify "MRTBEISingle" is visible in group list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed
	
	#TC-C1027927	
	#DependOn:TC-C1027453
	@SmokeSuite @RuleManagement @Views
Scenario: Verify that Only Active Rules can be Assigned to a Group [C1027927] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Rule" from left side menu panel under option 
	Then Verify "Search" page is displayed 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify "MRTBEISingle" is visible in group list 
	When Click on "MRTBEISingle" group name 
	When Click on "Edit" button 
	Then Verify "Rule Details" page is displayed 
	And Check Active checkbox 
	And Click on "Next" button in Group Collection 
	Then Verify "Formula Details" page is displayed 
	And Click on "Save" button in Group Collection 
	Then Verify "Formula Details" Portal is closed 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "IMS" group name 
	When Click on Edit button in the header 
	Then Verify "Edit Group" tab is visible 
	When Click on Add button in Assigned Rules Group Collection Management 
	Then Verify "Rules" page is displayed in overlay
	When Select "DCMA" in "Type" field in Rules page 
	And Click on "Search" button in Search page 
	Then Verify "MRTBEISingle" is not displayed in result list 
	And Click on "Cancel" button in Rules overlay 
	Then Verify "Rules" Portal is closed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed
	
	#TC-C1027557
	#DependOn:TC-C1027453
	@SmokeSuite @RuleManagement @Views
Scenario: Deleting a Rule [C1027557] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Rule" from left side menu panel under option 
	Then Verify "Search" page is displayed 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify "MRTBEISingle" is visible in group list 
	When Click on "MRTBEISingle" group name 
	When Click on "Delete" button 
	Then Verify "Rule Deletion" page is displayed 
	Then Verify Are you sure you want to delete the selected Rule "[MRTBEISingle]" is visible in the popup 
	When Click on "Yes" button in popup
	Then Verify "MRTBEISingle" is not displayed in result list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed