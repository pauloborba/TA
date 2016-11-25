Feature: Send email with evaluated criterion
  As a Teacher
  I want to send emails to the students with all evaluation criterion and the evaluated so far
  So the students can know which have been evaluated and which is going to be evaluated yet

  #GUI Scenario
  Scenario: Send email to all students about all evaluation criterion
    Given the student "Aimee" login "aacb" has grade "MANA" in the criterion "Test implementation" that was not sent to the students
    When I request to send email with evaluated criterion
    Then I should see a message notifying that the email have been successfully sent

   #GUI Scenario
  Scenario: notify that there is no evaluated criterion
    Given I see the student "Pedro" login "p" and the criterion "Requirements definition"
    And the system verify that there is no evaluated criterion
    When I request a sending email with the evaluated criterion
    Then the system notify that I sent a email only with the criterion that is going to be evaluated yet

    #GUI Scenario
  Scenario: notify that a email has to be send
    Given I see the student "Rodrigo" with login "rcrs3" and the criterion "Requirements definition"
    When I update the grade of all students in the criterion "Requirements definition" originated from "Test" and dated from "02/02/2016"
    Then the system notifies that is necessary to send a new email with the evaluated criterion to the students


      #Controller Scenario
  Scenario: Check if the student continues in the system
    Given the student "Joao" login "J" is in the system
    When I request to send an email with evaluated criterion
    Then the student "Joao" with login "J" is still in the system