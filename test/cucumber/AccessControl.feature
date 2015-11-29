@igormatos
Feature: Access Control
As a user
I want to have access to the system
So that I can see the options that belongs to my user type

#  #Controller scenario
#  Scenario: Signing in
#    Given That "joao" has a account with password "123"
#    When "joao" request to sign in with password "123"
#    Then "joao" have access to the system
#    And the session is saved on his browser cookies
#
#  #Controller scenario
#  Scenario: Failed to sign in
#    Given That "joao" has a account with password "123"
#    When "joao" request to sign in with password "321"
#    Then "joao" have no access to the system

# (Eduardo Ximenes - diest)
# Evite ser específico demais usando coisas como "click" e "button". A ideia é ser mais genérico quanto à
# interação com a interface, pois facilita a portabilidade para outra plataforma, tipo mobile. É uma boa prática.
#
  #GUI scenario
  Scenario: Signing in web
    Given That I am at login page
    Given That "joao" has a account with password "123"
    And I write "joao" and "123" on the login form
    When I click Sign in button
    Then Welcome message is displayed
#
#  #GUI scenario
#   Scenario: Failed signing in web
#    Given that I am on login page
#    And I write "joao" and "321" on the login form
#    When I click Sign in button
#   Then I see a message "Senha ou login incorreto"