Feature: Create new discipline

  As a teacher

  I want to create a new discipline

  So I can manage my classes better

  # - system scenarios -
  @ignore
  Scenario: new discipline

    Given The system has no discipline named "Engenharia de Software e Sistemas"

    When I create the discipline "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then The discipline "Engenharia de Software e Sistemas" is properly stored in the system

  @ignore
  Scenario: duplicate discipline

    Given The system already has a discipline named "Engenharia de Software e Sistemas"

    When I create the discipline "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then The discipline "Engenharia de Software e Sistemas" is not stored more than one time in the system


  # - GUI scenarios -
  @ignore
  Scenario: new discipline

    Given I am at the homepage

    When I select create new discipline
    And fill the form with name "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then A success message is displayed
    And I am taken to the list of disciplines page where "Engenharia de Software e Sistemas" is listed as a discipline

  @ignore
  Scenario: duplicate discipline

    Given I am at the homepage

    When I select create new discipline
    And fill the form with name "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"
    And the system already has a discipline named "Engenharia de Software e Sistemas"

    Then An error message is displayed
    And I am taken to the list of disciplines page where "Engenharia de Software e Sistemas" is already listed as a discipline

###########################new scenarios for register discipline

# - system scenario
  @ignore
Scenario: Discipline with no teacher

	Given the system has no discipline named "ESS"
	When I create the discipline "ESS" with concepts "MA, MPA, MANA"
	And do not fill in the teacher
	Then the discipline "ESS" is not stored in the system

# - gui scenario
  @ignore
Scenario: Discipline with no teacher

	Given I am at the homepage

	When I select create new discipline
	And fill the form with name "ESS" with concepts "MA, MPA, MANA"
	And do not fill in the teacher

	Then I'm not able to save the discipline until I fill in the teacher

#################################################################################

# - system scenario
  @ignore
Scenario: Discipline with no concepts

	Given the system has no discipline named "ESS"
	When I create the discipline "ESS" with teacher "Paulo Borba"
	And do not fill in the concepts
	Then the discipline "ESS" is not stored in the system

# - gui scenario
  #falta o nome do cenario
	
#	Given I am at the homepage
#
#	When I select create new discipline
#	And fill the form with name "ESS" with teacher "Paulo Borba"
#	And do not fill in the concepts
#
#	Then I'm not able to save the discipline until I fill in the concepts
