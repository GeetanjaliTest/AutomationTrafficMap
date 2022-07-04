Feature: About Page and Perspective 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1027935
	@SmokeSuite @GroupCollectionManagement @Views
Scenario: Viewing the List of Groups Collections [C1027935] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1027936
	@SmokeSuite @GroupCollectionManagement @Views
Scenario: Add a New Group Collection [C1027936] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Delete the group name "MRTGroupCollection" if it is displayed in group collection
	When Click on Add button in Group Collection Management 
	Then Verify "Group Collection Details" window is displayed in the dialog 
	When Input "MRTGroupCollection" in "Name" field 
	And Input "DCMA" in "Type" field 
	And Input "BEI Group Collections Test" in "Description" textarea 
	And Check Active checkbox 
	And Click on "Save" button in Group Collection 
	Then Verify "MRTGroupCollection" is visible in group list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "MRTGroupCollection" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option
	
	#TC-C1027755
	@SmokeSuite @GroupManagement @Views
Scenario: Viewing the List of Groups [C1027755] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1027877
	@SmokeSuite @GroupManagement  @Views 
Scenario: Add a New Group with Evaluation Type as Threshold [C1027877] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "MRTGroup" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Group Management" window is displayed in the dialog 
	When Input "MRTGroup" in "Name" field in Group Management 
	When Select "Threshold" in Evaluation Type field 
	And Select "DCMA" in Type field 
	When Input "3" in "Acceptable" field in Group Management 
	When Input "2" in "Tolerable" field in Group Management 
	And Input "BEI Test Group" in "Description" textarea in Group Management 
	And Check Active checkbox 
	And Click on "Save" button in Group Collection 
	Then Verify "MRTGroup" is visible in group list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "MRTGroup" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	#TC-C1027408
	@SmokeSuite @RuleManagement @Views
Scenario: Viewing all Rules [C1027408] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Rule" from left side menu panel under option 
	Then Verify "Rule" page is opened for "Rule" option 
	When Select "DCMA" in "Type" field in Search page 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
	
	#TC-C1027924
	#DependOn:TC-C1027877
	@SmokeSuite @GroupManagement @Views 
Scenario: Edit a Group [C1027924] 
#Precondition:
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "MRTGroup" if it is displayed 
	When Delete the group name "MRTGroup - Edited" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Group Management" window is displayed in the dialog 
	When Input "MRTGroup" in "Name" field in Group Management 
	When Select "Threshold" in Evaluation Type field 
	And Select "DCMA" in Type field 
	When Input "3" in "Acceptable" field in Group Management 
	When Input "2" in "Tolerable" field in Group Management 
	And Input "BEI Test Group" in "Description" textarea in Group Management 
	And Check Active checkbox 
	And Click on "Save" button in Group Collection 
	Then Verify "MRTGroup" is visible in group list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
#TC: C1027924
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "MRTGroup" group name 
	And Click on Edit button in Group Management page 
	Then Verify "Edit Group" tab is visible 
	When Input "MRTGroup - Edited" in "Name" field in Group Management 
	And Input "BEI Test Group - Edited" in "Description" textarea in Group Management 
	And Click on "Save" button in Group Collection 
	Then Verify "MRTGroup - Edited" is visible in group list 
	Then Verify "BEI Test Group - Edited" is visible in group list 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed  
#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "MRTGroup - Edited" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 