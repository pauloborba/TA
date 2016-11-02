#Feature para configurar o atual conceito de avaliação. Por exemplo, por padrão, o projeto possui o conceito de
#avaliação "MA, MPA, MANA". O objetivo da feature é configurar esses conceitos para, por exemplo: "Meta alcançada e
#Meta não alcançada"
#João Vasconcelos de Souza Neto

Feature: Configure the evaluation concept
  As a teacher
  I want to configure the evaluation concept
  So I can evaluate my students with different concepts

  #Controller scenario
  Scenario: Configure the atual evaluation concept
    Given The evaluation concept is "MA, MPA, MANA"
    When I update the "MA, MPA, MANA" concept to "Usual Average" concept
    Then The evaluation concept is set

  #Controller Scenario
  Scenario: Configure the atual evaluation concept with invalid attributes
    Given The evaluation concept is "MA, MPA, MANA"
    When I update the "MA, MPA, MANA" concept to "New Concept" concept
    And the "New Concept" doesn't have any concept
    Then The atual concept doesn't change

  #GUI Scenario


  #GUI Scenario