Feature: Views Authentication and Authorization 

Background: 
	Given user navigates to URL : "${views.url}" application 
	
	#TC-C1263496
	@SmokeSuite @AuthenticationAndAuthorization @Views
Scenario: Login using both VIEWS and DEFENSE datasets [C1263496] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${viewsdefense.dataset}" as DataSet for views portal
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1263497
	@SmokeSuite @AuthenticationAndAuthorization @Views
Scenario: Login using invalid Username/Password/Dataset [C1263497] 
	Then Verify Artemis Views Login page is displayed 
	When Enter Username "CARRJW" and Password "CARRJW" and Dataset "VIEWS" in login panel 
	Then Verify Invalid Username/Password option is displayed 
	When Enter Username "CARRJW" and Password "CARRJW" and Dataset "DEFENSE" in login panel 
	Then Verify Invalid Username/Password option is displayed 
	
	#TC-C1263284	
	@SmokeSuite @AuthenticationAndAuthorization @Views
Scenario: Change Password for CARRJ [C1263284] 
	Then Verify Artemis Views Login page is displayed 
	When I login using "${views.userName}" as username "${views.password}" as password and "${views.dataset}" as DataSet for views portal 
	When Click on "Profile" option 
	Then Verify "User Profile" window is displayed in the dialog 
	When Click on "Change Password" link in User Profile overlay 
	And Put "CARRJ" in "Current Password" under User Profile overlay 
	And Put "CARRJNEW" in "New Password" under User Profile overlay 
	And Put "CARRJNEW" in "Confirm Password" under User Profile overlay 
	And Click on OK Button inside the dialog change password 
	Then Verify "Password changed successfully" text is visible in the dialog 
	And Click on OK Button inside the dialog basic info 
	Then Verify "User Profile" dialog is closed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	
	#TC-C1263285		
	#DependOn:TC-1263284
	@SmokeSuite @AuthenticationAndAuthorization @Views
Scenario: Login with New Password for CARRJ and Logout [C1263285] 
	Then Verify Artemis Views Login page is displayed 
	When Enter Username "${views.userName}" and Password "CARRJNEW" and Dataset "${views.dataset}" in login panel 
	And Click on Login Button 
	Then Verify Login is successful and "Views Portal" Page is displayed 
	When Click on "Log Out" option 
	Then Verify Artemis Views Login page is displayed 
	#Reset password to previous one
	When user navigates to URL : "${views.url}" application 
	When Enter Username "${views.userName}" and Password "CARRJNEW" and Dataset "${views.dataset}" in login panel 
	And Click on Login Button 
	When Click on "Profile" option 
	Then Verify "User Profile" window is displayed in the dialog 
	When Click on "Change Password" link in User Profile overlay 
	And Put "CARRJNEW" in "Current Password" under User Profile overlay 
	And Put "CARRJ" in "New Password" under User Profile overlay 
	And Put "CARRJ" in "Confirm Password" under User Profile overlay 
	And Click on OK Button inside the dialog change password 
	Then Verify "Password changed successfully" text is visible in the dialog 
	And Click on OK Button inside the dialog basic info 
	Then Verify "User Profile" dialog is closed 
	When Click on "Log Out" option 	