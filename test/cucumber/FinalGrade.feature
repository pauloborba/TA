Feature: Final grade
  As a teacher
  I want to give a grade to my students based on their performance along the course
  So that I can give them a fair grade from 0 to 10
  
  #Controller scenario
  @ignore
  Scenario: Calculating final grade after every criterion gets at least one grade
    Given that student "Eduardo" whose login is "ehxmm" has no grades for criterion "C4"
    And "MPA" for remaining criteria
    When I add "MA" to criterion "C4"
    Then the final grade is calculated

  #Controller scenario
  @ignore
  Scenario: Updating final grade after criterion gets new grade
    Given that student "Eduardo" whose login is "ehxmm" has "MA" for criterion "C1"
    And "MPA" for remaining criteria
    When I add "MPA" to criterion "C1"
    Then the final grade is updated

  #Controller scenario
  @ignore
  Scenario: Inability to calculate grade
    Given that student "Eduardo" whose login is "ehxmm" does not have a grade for criterion "C0"
    When I add "MPA" to criterion "C1"
    Then the system returns an error flag

  #Controller scenario
  @ignore
  Scenario: Adding criterion after 
    Given that student "Eduardo" whose login is "ehxmm" has "MPA" for all criteria
    And the Final Grade has already been calculated
    When I add to criterion "C2016" to the list of criterions
    And "Eduardo" has no grades on "C2016"
    Then the system returns an error flag

  #Ambos os cenários abaixo estão imperfeitos. Requerem acesso a funcionalidades de controlador
  #GUI scenario
  @ignore
  Scenario: Calculating final grade
    Given that I am at student page
    And I can see a table relating students to their grades on each criteria
    And one of the sections is named "Media final"
    When a student has a grade shown in each criteria
    Then "Media final" displays the student's final grade

  #GUI scenario
  @ignore
  Scenario: Inability to calculate grade
    Given that I am at student page
    And I can see a table relating students to their grades on each criteria
    And one of the sections is named "Media final"
    When a student has at least one criteria without a grade
    Then "Media final" displays the message Avaliacoes insuficientes
