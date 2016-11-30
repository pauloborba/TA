#Feature para configurar o atual conceito de avaliação. Por exemplo, por padrão, o projeto possui o conceito de
#avaliação "MA, MPA, MANA". O objetivo da feature é configurar esses conceitos para, por exemplo: "Meta alcançada e
#Meta não alcançada"
#João Vasconcelos de Souza Neto

Feature: Configure the evaluation concept
  As a teacher
  I want to configure the evaluation concept
  So I can evaluate my students with different concepts

  #Controller scenario
  Scenario: Configure the atual evaluation concept.
    Given The evaluation concept is "MA, MPA, MANA"
    When I update the "MA, MPA, MANA" concept to "Usual Average" concept
    Then The evaluation concept "Usual Average" is set

  #Controller Scenario
  Scenario: Configure the atual evaluation concept with invalid attributes.
    Given The evaluation concept is "MA, MPA, MANA"
    When I update the "MA, MPA, MANA" concept to "New Concept" evaluation concept with no concepts
    Then The atual concept is "MA, MPA, MANA"

  #GUI Scenario
  Scenario: Configure the atual evaluation concept with a invalid value.
    Given The "MA, MPA, MANA" evaluation concept with concepts "MA", "MPA", "MANA" is set
    When I edit the "MA, MPA, MANA" evaluation concept with a invalid number of concepts
    Then The concepts of "MA, MPA, MANA" are the same.

  #GUI Scenario
  Scenario: Configure the parameters of the atual evaluation concept.
    Given The "MA, MPA, MANA" evaluation concept with concepts "MA", "MPA", "MANA" is set
    When I edit the "MA" field to "Meta Alcançada" evaluation concept
    Then I can see the concept "Meta Alcançada"
    And I can't see the concept "MA".