Feature: Access Control
+  As a user
+  I want to have access to the system
+  So that I can see the options that belongs to my user type
+  
+  #Controller scenario
+  Scenario: Signing in
+    Given that "joao" has a account with password "123"
+    When "joao" request to sign in with his correct password "123"
+    Then "joao" have access to the system
+    And the session is saved on his browser cookies
+
+  #Controller scenario
+  Scenario: Failed to sign in
+    Given that "joao" has a account with password "123"
+    When "joao" request to sign in with an incorrect password "321"
+    Then "joao" have no access to the system
+
+  #GUI scenario
+  Scenario: Signing in web
+    Given that I am on login page
+    And I write "joao" and "123" on the login form
+    When I click Sign in button
+    Then I go to the main page

++  #GUI scenario
+    Scenario: Failed signing in web
+    Given that I am on login page
+    And I write "joao" and "321" on the login form
+    When I click Sign in button
+    Then I see a message "Senha ou login incorreto"
