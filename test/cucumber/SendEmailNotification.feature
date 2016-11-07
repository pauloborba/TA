Feature: Send email with evaluated criterion
  As a Teacher
  I want to send emails to the students with all evaluation criterion and the evaluated so far
  So the students can know which have been evaluated and which is going to be evaluated yet

  #GUI Scenario
 # Scenario: Send email to all students about all evaluation criterion
    #Given the created criterion are "Requirements definition" and "Test implementation"
   # And the student "João" is registered with grade MPA in the criterion "Requirements definition"
  #  And the student "Pedro" is regitered with grade MA in the criterion "Requirements definition"
 #   When I choose the option "Send evaluated criterion"
 #   Then a email is send to "João" notifying his grade in the criterion "Requirements definition" and that the criterion "Test implementation" is going to be evaluated yet
 #   And a email is send to "Pedro" notifying his grade in the criterion "Requirements definition" and that the criterion "Test implementation" is going to be evaluated yet
 #   And I should see a message notifying that all email have been sent

    #Controller Scenario
 # Scenario: Check the email model that is going to be send
   # Given the created criterion are "Requirements definition" and "Test implementation"
    #When I choose the option "Check model"
   # Then I should see a text with the evaluated criterion with "-NOTA" written in the end of the evaluated criterion
  #  And I should see a text with the criterion that is going to be evaluated yet

    #GUI Scenario
  Scenario: notify that a email has to be send
    Given I see the students "Rodrigo" with login "rcrs3" and "Pedro" with login "Plal" and the criterion "Requirements definition"
    When I update the grade of all students in the criterion "Requirements definition" originated from "Test" and dated from "02/02/2016"
    Then the system notifies that is necessary to send a new email with the evaluated criterion to the students

    #GUI Scenario
  #Scenario: notify that there is no evaluated criterion
    #Given the created criterion are "Requirements definition" and "Test implementation"
    #And the student "João" and the student "Pedro" are registered in the system
   # And the system verify that there is no evaluated criterion
  #  When I request a sending email with the evaluated criterion
  #  Then the system ask if I want to send a email only with the criterion that is going to be evaluated yet