Feature: Final grade
  As a teacher
  I want to give a grade to my students based on their performance along the course
  So that I can give them a fair grade from 0 to 10
  
  #Controller scenario
  @ignore
  Scenario: Calculating final grade
    Given that every criteria has a grade for student "Eduardo"
    When I request the system to register grades from "Eduardo"
    Then the final grade for "Eduardo" is calculated based on the grades from each criteria
    And the result is stored by the system

  #Controller scenario
  @ignore
  Scenario: Inability to calculate grade
    Given that at least one criteria has no grades for student "Eduardo"
    When I request the system to register grades from "Eduardo"
    Then the final grade is not calculated

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
