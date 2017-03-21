Feature: Send email with evaluated criterion
  As a Teacher
  I want to send emails to the students with all evaluation criterion and the evaluated so far
  So the students can know which have been evaluated and which is going to be evaluated yet

  #GUI Scenario
  Scenario: Send email to students about all evaluation criterion
    Given The only not yet sent grade is "MANA" in the criterion "Test implementation" from the student "Aimee" with login "aacb"
    When I request to send email with evaluated criterion
    Then I should see a message notifying that the email have been successfully sent

   #GUI Scenario
  Scenario: notify that there is no evaluated criterion
    Given the student "Pedro" that has login "p" is in the system
    And the criterion "Requirements definition" is registered in the system
    And the system verifies that there is no evaluated criterion
    When I request a sending email with the evaluated criterion
    Then I should see a message that I sent a email only with the criterion that is going to be evaluated yet

    #GUI Scenario
  Scenario: notify that a email has to be send
    Given the student with name "Rodrigo" and login "rcrs3" is in the system
    And the criterion with name "Requirements definition" is in the system
    When the criterion "Requirements definition" originated from "Test" and dated from "02/02/2016" has the grade updated
    Then I should see a message that is necessary to send a new email with the evaluated criterion to the students


      #Controller Scenario
  Scenario: Check if the student continues in the system
    Given the student "Joao" login "J" is in the system
    When I request to send an email with evaluated criterion
    Then the student "Joao" with login "J" is still in the system


  #GUI Scenario
  Scenario: Send email to students with the evaluated criterion
    Given the student "Rodrigo" that has login "rcrs3" is registered in the system
    And The only not yet sent grades are "MANA" in the criterion "Test implementation" and "MA" in the criterion "Requirements definition"
    When I request a sending email with evaluated criterion
    Then I should see a message that notifies that the email have been successfully sent