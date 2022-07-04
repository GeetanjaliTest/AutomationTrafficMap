Feature: This feature is related to Verifying active inactive fields of Groups with few scenarios 

Background: 
	Given user navigates to application URL : "${views.url}" application 
	
	#TC:C1160271	
@RegressionSuite @GroupManagement @Views
Scenario: Validate Active and Inactive fields for Groups in Edit mode [C1160271] 
#PreCondition: C1133670, Create Group name: 5001_Example 1
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	When Click on "Administration" from left side menu panel  
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Delete the group name "5001_Example 1" if it is displayed 
	When Delete the group name "5001_Example 2" if it is displayed 
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "5001_Example 1" in "Name" Field for Add Group Tab 
	And I enter "Threshold" in "Evaluation Type" Field for Add Group Tab 
	And I enter "4" in "Acceptable" Field for Add Group Tab 
	And I set "true" value for Active checkbox 
	And I enter "DCMA" in "Type" Field for Add Group Tab 
	And I enter "2" in "Tolerable" Field for Add Group Tab 
	And I enter "Testing Example 1" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "5001_Example 1" group displayed 
#PreCondition: C1133670, Create Group name: 5001_Example 2
	When I click on "Add" icon on Group Management panel 
	Then I should see "Add Group" tab opened 
	When I enter "5001_Example 2" in "Name" Field for Add Group Tab 
	And I enter "Threshold" in "Evaluation Type" Field for Add Group Tab 
	And I enter "3" in "Acceptable" Field for Add Group Tab 
	And I set "true" value for Active checkbox 
	And I enter "DCMA" in "Type" Field for Add Group Tab 
	And I enter "2" in "Tolerable" Field for Add Group Tab 
	And I enter "Testing Example 2" in "Description" Field for Add Group Tab 
	And I click on "Save" button on Add Group Tab 
	Then I should see "5001_Example 1" group displayed 
	When I logout of Views Portal 
	Then I should see default login page displayed 
#TC:C1160271
	Given I am on Views Login Page 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then I should see Verify Business Rule Checker Window displayed 
	When I click on "Group Collections" under Administration Menu 
	Then I should see "Group Collection Management" panel displayed 
	When I select "Schedule Metrics" collection among listed 
	And I click on "Add Assigned Group" icon on GCM page 
	Then I should see Group Selection Window open 
	When I select checkbox for "5001_Example 1" group on Group Selection 
	And I click on "OK" button on Group Selection Window 
	Then I should see "5001_Example 1" in list of assigned group for "Schedule Metrics" collection on GCM page 
	When I click on "Save" button on Group Selection Window 
	Then I should see "Group Collection data are saved successfully." message displayed on save window 
	When I click on "OK" button on Group Selection Window 
	Then I should see "Group Collection Management" panel displayed 
	When I click on "Group" under Administration Menu when its open 
	Then I should see "Group Management" panel displayed 
	When I select "5001_Example 1" group listed on Group Management Panel 
	And I click on "Edit" icon on Group Management panel 
	Then I should see "Edit Group" tab opened 
	And I should see Active Checkbox being "Disabled" 
	When I click on "Cancel" button on Edit Group Tab 
	When I select "5001_Example 2" group listed on Group Management Panel 
	And I click on "Edit" icon on Group Management panel 
	Then I should see "Edit Group" tab opened 
	And I should see Active Checkbox being "Enabled" 
	When I logout of Views Portal 
	Then I should see default login page displayed	
	#Post data clean up Delete Group name: 5001_Example 1
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "5001_Example 1" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection 
	And Click on "Log Out" option 
	#Post data clean up Delete Group name: 5001_Example 2
	When user navigates to URL : "${views.url}" application 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Business Rule Checker" Page is displayed 
	Then Verify "Rule Execution" panel header is displayed 
	When Click on "Administration" from left side menu panel 
	When Click on "Group" from left side menu panel under option 
	Then Verify "Group Management" page is opened for "Group" option 
	When Click on "5001_Example 2" group name 
	When Click on Delete button in the group management header 
	And Click on "Yes" button in Group Collection
	And Click on "Log Out" option 