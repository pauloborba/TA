@igormatos
Feature: Access Control
As a user
I want to have access to the system
So that I can see the options that belongs to my user type

#  #Controller scenario

  Scenario: Signing in
   Given that the student named "Anakin Skywalker" with a login "ak" is registered in the system
   When "ak" request to sign in with password "ak"
   Then "ak" have access to the system

#
#  #Controller scenario
#  Scenario: Failed to sign in
#    Given That "joao" has a account with password "123"
#    When "joao" request to sign in with password "321"
#    Then "joao" have no access to the system

# (Eduardo Ximenes - diest)
# Evite ser específico demais usando coisas como "click" e "button". A ideia é ser mais genérico quanto à
# interação com a interface, pois facilita a portabilidade para outra plataforma, tipo mobile. É uma boa prática.



 #GUI scenario
  Scenario: Signing in web
   Given That I am at login page
   And "finn" has a account with login "finnsw" and password "123"
   When I write "finnsw" and "123" on the login form
   And I click Sign in button
   Then Welcome to "finn" is displayed

#  #GUI scenario
   Scenario: Failed signing in web
    Given That I am at login page
    And "rey" has a account with login "reysw" and password "123"
    When I write "reysw" and "321" on the login form
    And I click Sign in button
    Then I see a error message for "reysw"