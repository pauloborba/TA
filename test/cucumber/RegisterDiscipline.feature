Feature: Create new discipline

  As a teacher

  I want to create a new discipline

  So I can manage my classes better

  # - system scenarios -

  Scenario: new discipline

    Given The system has no discipline named "Engenharia de Software e Sistemas"

    When I create the discipline "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then The discipline "Engenharia de Software e Sistemas" is properly stored in the system


  Scenario: duplicate discipline

    Given The system already has a discipline named "Engenharia de Software e Sistemas"

    When I create the discipline "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then The discipline "Engenharia de Software e Sistemas" is not stored more than one time in the system


  # - GUI scenarios -

  Scenario: new discipline

    Given I am at the homepage

    When I select create new discipline
    And fill the form with name "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"

    Then A success message is displayed
    And I am taken to the list of disciplines page where "Engenharia de Software e Sistemas" is listed as a discipline


  Scenario: duplicate discipline

    Given I am at the homepage

    When I select create new discipline
    And fill the form with name "Engenharia de Software e Sistemas" with teacher "Paulo Borba" and concepts "MA, MPA, MANA"
    And the system already has a discipline named "Engenharia de Software e Sistemas"

    Then An error message is displayed
    And I am taken to the list of disciplines page where "Engenharia de Software e Sistemas" is already listed as a discipline