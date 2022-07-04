Feature: This feature is related to Group and Group Collection Management related various scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 
	
@RegressionSuite @GroupManagement @Views
Scenario Outline: Adding New Groups, i.e., BEFORE Group, MRT Group and TESTING Group [C1133670] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group" under Administration Menu 
	Then I should see "Group Management" panel displayed 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "<GroupName>" group displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|BEFORE Group|Threshold|6|true|DCMA|3|Description For BEFORE Group|
		|MRT Group|Threshold|6|true|DCMA|10|Description For MRT Group|
		|TESTING Group|Threshold|1|true|DCMA|0|Description For TESTING Group|
		|MRTGroup|Threshold|3|true|DCMA|2|BRI Test Group|
		
		
@RegressionSuite @GroupManagement @Views
Scenario: Adding New Group Collection, i.e., TESTING Collection [C1133664] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "TESTING COLLECTION" if it is displayed in group collection
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "TESTING COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for TESTING Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "TESTING COLLECTION" displayed in list of Group Collections 
	When I select "TESTING COLLECTION" collection among listed 
	And I click on "Edit" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	And Click on "Cancel" button in Group Collection page
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "TESTING COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
			
	
	#DependOn: TC: C1133664, C1133670	
@RegressionSuite @GroupManagement @Views
Scenario Outline: Assigning a Group to Group Collection, i.e., TESTING Collection [C1133665] 
#Prerequisite TC:C1133670	
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group" under Administration Menu 
	Then I should see "Group Management" panel displayed 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "<GroupName>" group displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Prerequisite TC:C1133664
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "TESTING COLLECTION" if it is displayed in group collection
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "TESTING COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for TESTING Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "TESTING COLLECTION" displayed in list of Group Collections 
	When I select "TESTING COLLECTION" collection among listed 
	And I click on "Edit" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	And Click on "Cancel" button in Group Collection page
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#TC:C1133665
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "TESTING COLLECTION" collection among listed 
	And I click on "Add Assigned Group" icon on GCM page 
	Then I should see Group Selection Window open 
	When I select checkbox for "<GroupName>" group on Group Selection 
	And I click on "OK" button on Group Selection Window 
	Then I should see "<GroupName>" in list of assigned group for "TESTING COLLECTION" collection on GCM page 
	When I click on "Save" button on Group Selection Window 
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up C1133664
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "TESTING COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	#Post data clean up C1133670	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|TESTING Group|Threshold|1|true|DCMA|0|Description For TESTING Group|
				
				#DependOn: TC: C1133665
@RegressionSuite @GroupManagement @Views
Scenario: Adding New Group Collection, i.e., BEFORE Collection [C1133666] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Delete the group name "BEFORE COLLECTION" if it is displayed in group collection
	When Click on Add button in Group Collection Management 
	Then I should see Group Collection Details window displayed 
	When I enter "BEFORE COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for BEFORE Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "BEFORE COLLECTION" displayed in list of Group Collections 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "BEFORE COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	#DependOn: TC: C1133666, C1133670
@RegressionSuite @GroupManagement @Views
Scenario Outline: Assigning a Group to Group Collection, i.e., BEFORE Collection [C1133667] 
#Prerequisite TC:C1133670	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "BEFORE COLLECTION" if it is displayed in group collection
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "BEFORE COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for TESTING Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "BEFORE COLLECTION" displayed in list of Group Collections 
	When I select "BEFORE COLLECTION" collection among listed 
	And I click on "Edit" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	And Click on "Cancel" button in Group Collection page
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Prerequisite TC:C1133670	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group" under Administration Menu 
	Then I should see "Group Management" panel displayed 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "<GroupName>" group displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#TC:C1133667
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "BEFORE COLLECTION" collection among listed 
	And I click on "Add Assigned Group" icon on GCM page 
	Then I should see Group Selection Window open 
	When I select checkbox for "<GroupName>" group on Group Selection
	And I click on "OK" button on Group Selection Window 
	Then I should see "<GroupName>" in list of assigned group for "BEFORE COLLECTION" collection on GCM page 
	When I click on "Save" button on Group Selection Window 
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "BEFORE COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	#Post data clean up C1133670	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|BEFORE Group|Threshold|6|true|DCMA|3|Description For BEFORE Group|
						
#DependOn: TC: C1133667 
@RegressionSuite @GroupManagement @Views
Scenario: Adding New Group Collection, i.e., MRT Collection [C1133668] 
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "MRT COLLECTION" if it is displayed in group collection
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "MRT COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for MRT Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "MRT COLLECTION" displayed in list of Group Collections 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "MRT COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	#DependOn: TC: C1133668, C1133670
@RegressionSuite @GroupManagement @Views
Scenario Outline: Assigning a Group to Group Collection, i.e., MRT Collection [C1133669] 
#Prerequsite:C1133668
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "MRT COLLECTION" if it is displayed in group collection
	When Click on Add button in Group Collection Management 
	Then I should see Group Collection Details window displayed 
	When I enter "MRT COLLECTION" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for MRT Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then Verify "MRT COLLECTION" is visible in group list 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Prerequsite:C1133670
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group" under Administration Menu 
	Then I should see "Group Management" panel displayed 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "<GroupName>" group displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#TC:C1133669	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "MRT COLLECTION" collection among listed 
	When Click on Add button in Assigned Groups Group Collection Management 
	Then I should see Group Selection Window open 
	When I select checkbox for "<GroupName>" group on Group Selection 
	And I click on "OK" button on Group Selection Window 
	Then I should see "<GroupName>" in list of assigned group for "MRT COLLECTION" collection on GCM page 
	When Click on Save button in Assigned Rules Group Collection Management
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
	#Post data clean up C1133670	
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then Verify "Group Collection Management" page is opened for "Group Collections" option 
	When Click on "MRT COLLECTION" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|MRTGroup|Threshold|3|true|DCMA|2|BRI Test Group|
		
		#Pre-condition [C1133670] to create a group and [C1133664] for creating Group Collection	
@SmokeSuite @GroupManagement @Views
Scenario Outline: Assigning a Group to Group Collection [C1027946] 
#Precondition: C1133664
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "MRTGroupCollection" if it is displayed in group collection 
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "MRTGroupCollection" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "BEI Group Collections Test" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then I should see "MRTGroupCollection" displayed in list of Group Collections 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#Precondition: C1133670
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group" under Administration Menu 
	Then I should see "Group Management" panel displayed 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And Click on "Save" button in Group Collection 
	Then Verify "<GroupName>" is visible in group list 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#TC:C1027946
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "MRTGroupCollection" collection among listed 
	And I click on "Add Assigned Group" icon on GCM page 
	Then I should see Group Selection Window open 
	When I select checkbox for "<GroupName>" group on Group Selection 
	And I click on "OK" button on Group Selection Window 
	Then I should see "<GroupName>" in list of assigned group for "MRTGroupCollection" collection on GCM page 
	When I click on "Save" button on Group Selection Window 
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
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
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|MRTGroup|Threshold|3|true|DCMA|2|BRI Test Group|
		
#DependOn: TC: C1027946
@SmokeSuite @GroupManagement @Views
Scenario Outline: Remove an Assigned Group [C1027949] 
#Precondition: C1133664
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "MRTGroupCollection" if it is displayed in group collection
	When I click on "Add" icon on GCM page 
	Then I should see Group Collection Details window displayed 
	When I enter "MRTGroupCollection" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "BEI Group Collections Test" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And Click on "Save" button in Group Collection 
	Then Verify "MRTGroupCollection" is visible in group list 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#Precondition: C1133670
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "<GroupName>" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "<GroupName>" in "Name" Field for Add Group Tab 
	And I enter "<Evaluation>" in "Evaluation Type" Field for Add Group Tab 
	And I enter "<Acceptable>" in "Acceptable" Field for Add Group Tab 
	And I set "<Active>" value for Active checkbox 
	And I enter "<Type>" in "Type" Field for Add Group Tab 
	And I enter "<Tolerable>" in "Tolerable" Field for Add Group Tab 
	And I enter "<Description>" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "<GroupName>" group displayed 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#Precondition:C1027946
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then I should see "Group Collection Management" panel displayed 
	When I select "MRTGroupCollection" collection among listed 
	When Click on Add button in Assigned Groups Group Collection Management 
	Then I should see Group Selection Window open 
	When I select checkbox for "<GroupName>" group on Group Selection
	And I click on "OK" button on Group Selection Window 
	Then I should see "<GroupName>" in list of assigned group for "MRTGroupCollection" collection on GCM page 
	When I click on "Save" button on Group Selection Window 
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
	#TC:C1027949
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then I should see "Group Collection Management" panel displayed 
	When I select "MRTGroupCollection" collection among listed 
	When I select checkbox for "<GroupName>" group on Group Selection 
	And I click on "Delete" button on Group Selection Window 
	Then I should see confirmation window with "Please confirm that you wish to unassign the selected Group(s) from the Group Collection" "[MRTGroupCollection]" message 
	When I click "Yes" button on confirmation window 
	Then I should see that "<GroupName>" does not exist anymore in Assigned Groups Section 
	When I click on "Save" button on Group Selection Window 
	When Click on "Log Out" option 
	Then I should see default login page displayed 
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
    #Post data clean up
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "<GroupName>" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	When Click on "Log Out" option 
	
	Examples: 
		|GroupName|Evaluation|Acceptable|Active|Type|Tolerable|Description|
		|MRTGroup|Threshold|3|true|DCMA|2|BRI Test Group|
				
	#DependOn: C1027936										
@SmokeSuite @GroupManagement @Views
Scenario: Remove an Assigned Group [C1027957] 
#Prerequsite:C1027936
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed  
	When Click on "Administration" from left side menu panel 
	When Click on "Group Collections" from left side menu panel under option 
	Then I should see "Group Collection Management" panel displayed 
	When Delete the group name "MRTGroupCollection" if it is displayed in group collection
	When Click on Add button in Group Collection Management 
	Then I should see Group Collection Details window displayed 
	When I enter "MRTGroupCollection" for Name field on GCD window 
	And I select "DCMA" as type on GCD window 
	And I enter Description "Description for MRT Collection" for GCD window 
	And I click on Activate checkbox present on GCD window 
	And I click on "Save" button on GCD window 
	Then Verify "MRTGroupCollection" is visible in group list 
	When Click on "Log Out" option
	Then I should see default login page displayed 
#TC:C1027957	
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "MRTGroupCollection" collection among listed 
	And I click on "Delete" icon on GCM page 
	Then I should see confirmation window with "Please confirm that you wish to delete the selected Group Collection" "[MRTGroupCollection]" message for gcm 
	When I click "Yes" button on confirmation window for Group Collection 
	Then I should see that "MRTGroupCollection" does not exist anymore in list of Group Collections 
	When Click on "Log Out" option 
	Then I should see default login page displayed