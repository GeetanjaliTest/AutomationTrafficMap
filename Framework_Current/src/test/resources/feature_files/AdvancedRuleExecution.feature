Feature: Advanced Rule Execution 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1211470
@SmokeSuite @AdvancedRuleExecution @Views
Scenario: Running Basic Rule Execution Group Expression (Well Behind) [C1211470] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "testGroup" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Group" tab is displayed 
	When Input "testGroup" in "Name" field in Group Management 
	When Select "Group Expression" in Evaluation Type field 
	And Input "(#BR00004# AND (#BR00005# OR #BR00006#))" in "Group Expression" textarea in Group Management 
	And Check Active checkbox 
	And Select "DCMA" in Type field 
	And Input "Evaluation Type Test Group" in "Description" textarea in Group Management 
	When Click on Add button in Assigned Rules Group Collection Management 
	Then Verify "Rules" page is displayed in overlay 
	When Select "DCMA" in "Type:" field overlay 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When I select checkbox for "IMS-HARD-CONSTRAINTS" group on Group Selection 
	When I select checkbox for "IMS-HIGH-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-RELATIONSHIPS" group on Group Selection 
	And Click on "OK" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "testGroup" group name 
	Then Verify "IMS-HARD-CONSTRAINTS" page is displayed 
	Then Verify "IMS-HIGH-FLOAT" page is displayed 
	Then Verify "IMS-NEGATIVE-FLOAT" page is displayed 
	Then Verify "IMS-RELATIONSHIPS" page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	When Click on "Schedule Metrics" group name 
	When Click on Add button in Assigned Groups Group Collection Management and "Group Selection" overlay appears 
	Then Verify "testGroup" page is displayed 
	When Click on "testGroup" group name 
	And Click on "OK" button in Group Collection 
	When Click on Save button in Assigned Rules Group Collection Management 
	Then Verify "Save" page is displayed 
	And Click on "OK" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in popup overlay 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "Well Behind" is shown for "testGroup" group name 
	When Input "Execute rules Group Expression (Well Behind)" in overlay comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
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
	When Click on "testGroup" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	
	#TC-C1211526
	#DependOn: TC: C1211470
@SmokeSuite @AdvancedRuleExecution @Views
Scenario: 	Running Basic Rule Execution with OR Evaluation Type, Both Rules Well Behind (Well Behind) [C1211526] 
#Prerequisite TC: C1211470 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "testGroup" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Group" tab is displayed 
	When Input "testGroup" in "Name" field in Group Management 
	When Select "Group Expression" in Evaluation Type field 
	And Input "(#BR00004# AND (#BR00005# OR #BR00006#))" in "Group Expression" textarea in Group Management 
	And Check Active checkbox 
	And Select "DCMA" in Type field 
	And Input "Evaluation Type Test Group" in "Description" textarea in Group Management 
	When Click on Add button in Assigned Rules Group Collection Management 
	Then Verify "Rules" page is displayed in overlay 
	When Select "DCMA" in "Type:" field overlay 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When I select checkbox for "IMS-HARD-CONSTRAINTS" group on Group Selection 
	When I select checkbox for "IMS-HIGH-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-RELATIONSHIPS" group on Group Selection 
	And Click on "OK" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "testGroup" group name 
	Then Verify "IMS-HARD-CONSTRAINTS" page is displayed 
	Then Verify "IMS-HIGH-FLOAT" page is displayed 
	Then Verify "IMS-NEGATIVE-FLOAT" page is displayed 
	Then Verify "IMS-RELATIONSHIPS" page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	When Click on "Schedule Metrics" group name 
	When Click on Add button in Assigned Groups Group Collection Management and "Group Selection" overlay appears 
	Then Verify "testGroup" page is displayed 
	When Click on "testGroup" group name 
	And Click on "OK" button in Group Collection 
	When Click on Save button in Assigned Rules Group Collection Management 
	Then Verify "Save" page is displayed 
	And Click on "OK" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in popup overlay 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "Well Behind" is shown for "testGroup" group name 
	When Input "Execute rules Group Expression (Well Behind)" in overlay comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed 
#TC: C1211526
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "testGroup" group name 
	And Click on Edit button in Group Management page 
	When Select "OR" in "Evaluation Type:" field in Group Management 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-HARD-CONSTRAINTS" group on Group Selection 
	When Click on Delete button in the assigned rule header 
	Then Verify "Confirmation" page is displayed 
	And Click on "Yes" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in Group Collection 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "Well Behind" is shown for "testGroup" group name 
	When Input "Both Rules Well Behind (Well Behind)" in comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
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
	When Click on "testGroup" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	#TC-C1211524
	#DependOn: TC: C1211470 
@SmokeSuite @AdvancedRuleExecution @Views
Scenario: 	Running Advanced Rule Execution with OR Evaluation Type, One Rule On Track and Another Well Behind (On Track) [C1211524] 
	#Prerequisite TC: C1211470
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "testGroup" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Group" tab is displayed 
	When Input "testGroup" in "Name" field in Group Management 
	When Select "Group Expression" in Evaluation Type field 
	And Input "(#BR00004# AND (#BR00005# OR #BR00006#))" in "Group Expression" textarea in Group Management 
	And Check Active checkbox 
	And Select "DCMA" in Type field 
	And Input "Evaluation Type Test Group" in "Description" textarea in Group Management 
	When Click on Add button in Assigned Rules Group Collection Management 
	Then Verify "Rules" page is displayed in overlay 
	When Select "DCMA" in "Type:" field overlay 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When I select checkbox for "IMS-HARD-CONSTRAINTS" group on Group Selection 
	When I select checkbox for "IMS-HIGH-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-RELATIONSHIPS" group on Group Selection 
	And Click on "OK" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "testGroup" group name 
	Then Verify "IMS-HARD-CONSTRAINTS" page is displayed 
	Then Verify "IMS-HIGH-FLOAT" page is displayed 
	Then Verify "IMS-NEGATIVE-FLOAT" page is displayed 
	Then Verify "IMS-RELATIONSHIPS" page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	When Click on "Schedule Metrics" group name 
	When Click on Add button in Assigned Groups Group Collection Management and "Group Selection" overlay appears 
	Then Verify "testGroup" page is displayed 
	When Click on "testGroup" group name 
	And Click on "OK" button in Group Collection 
	When Click on Save button in Assigned Rules Group Collection Management 
	Then Verify "Save" page is displayed 
	And Click on "OK" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in popup overlay 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "Well Behind" is shown for "testGroup" group name 
	When Input "Execute rules Group Expression (Well Behind)" in overlay comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed		
	#TC-C1211524
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "testGroup" group name 
	And Click on Edit button in Group Management page 
	When Select "OR" in "Evaluation Type:" field in Group Management 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-RELATIONSHIPS" group on Group Selection 
	When Click on Delete button in the assigned rule header 
	Then Verify "Confirmation" page is displayed 
	And Click on "Yes" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in Group Collection 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "On Track" is shown for "testGroup" group name 
	When Input "One Rule On Track and Another Well Behind (On Track)" in comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
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
	When Click on "testGroup" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	#TC-C1211512
@SmokeSuite @AdvancedRuleExecution @Views
Scenario: 	Running Advanced Rule Execution with OR Evaluation Type, One Rule On Track and Another Well Behind (On Track) [C1211512] 
	#Prerequisite TC: C1211470
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "testGroup" if it is displayed 
	When Click on Add button in Group Collection Management 
	Then Verify "Add Group" tab is displayed 
	When Input "testGroup" in "Name" field in Group Management 
	When Select "Group Expression" in Evaluation Type field 
	And Input "(#BR00004# AND (#BR00005# OR #BR00006#))" in "Group Expression" textarea in Group Management 
	And Check Active checkbox 
	And Select "DCMA" in Type field 
	And Input "Evaluation Type Test Group" in "Description" textarea in Group Management 
	When Click on Add button in Assigned Rules Group Collection Management 
	Then Verify "Rules" page is displayed in overlay 
	When Select "DCMA" in "Type:" field overlay 
	And Click on "Search" button in Search page 
	Then Verify existing Rules are displayed 
	When I select checkbox for "IMS-HARD-CONSTRAINTS" group on Group Selection 
	When I select checkbox for "IMS-HIGH-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-RELATIONSHIPS" group on Group Selection 
	And Click on "OK" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "testGroup" group name 
	Then Verify "IMS-HARD-CONSTRAINTS" page is displayed 
	Then Verify "IMS-HIGH-FLOAT" page is displayed 
	Then Verify "IMS-NEGATIVE-FLOAT" page is displayed 
	Then Verify "IMS-RELATIONSHIPS" page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	When Click on "Schedule Metrics" group name 
	When Click on Add button in Assigned Groups Group Collection Management and "Group Selection" overlay appears 
	Then Verify "testGroup" page is displayed 
	When Click on "testGroup" group name 
	And Click on "OK" button in Group Collection 
	When Click on Save button in Assigned Rules Group Collection Management 
	Then Verify "Save" page is displayed 
	And Click on "OK" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in popup overlay 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "Well Behind" is shown for "testGroup" group name 
	When Input "Execute rules Group Expression (Well Behind)" in overlay comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
	When Click on "Log Out" option 
	Then  Verify "Business Rule Checker" window is closed		
	#TC-C1211512
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "testGroup" group name 
	And Click on Edit button in Group Management page 
	When Select "OR" in "Evaluation Type:" field in Group Management 
	When I select checkbox for "IMS-HIGH-FLOAT" group on Group Selection 
	When I select checkbox for "IMS-NEGATIVE-FLOAT" group on Group Selection 
	When Click on Delete button in the assigned rule header 
	Then Verify "Confirmation" page is displayed 
	And Click on "Yes" button in Group Collection 
	And Click on "Save" button in Group Collection 
	When Click on "Rule Execution" from left side menu panel 
	When Click on "Advanced" from left side menu panel under option 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	When Select "Schedule Metrics" in "Group Collection:" field in Group Management 
	When Select "testGroup" in "Group:" field in Group Management 
	And Click on "Search" button in Search page 
	Then Verify "Rule Execution" page is opened for "Advanced" option 
	Then Verify existing Rules are displayed 
	And Click on "Execute" button in Group Collection 
	Then Verify "Query Parameters" page is displayed 
	When Input "VIEWS5-DEMO 3" in "PROJECT" field in Group Management 
	And Click on "OK" button in Group Collection 
	Then Verify "Run Result" window is displayed in the dialog 
	And Verify status "On Track" is shown for "testGroup" group name 
	When Input "Rule Execution with OR Evaluation Type (On Track)" in comments textarea 
	And Click on "Save" button in Group Collection 
	Then Verify "Run Result" Portal is closed 
	Then Verify existing Rules are displayed 
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
	When Click on "testGroup" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 