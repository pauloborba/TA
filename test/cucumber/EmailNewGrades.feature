Feature: Email New Grades
  As a teacher
  I want to be able to email New Grades
  to inform students of their Progress

  #-Created By Arthur Costa
  Scenario: Sending new grades
    Given There are grades from student “Arthur” with email “alpgc@cin.ufpe.br” evaluated as “MANA” in the “Cenarios” criteria on the system that were not yet sent
    When I request to send new grades
    Then An email is sent to “alpgc@cin.ufpe.br” Telling he received an “MANA” on “Cenarios”

#  Scenario: No new grades to send
#    Given All grades on the system have been already sent
#    And I am on the evaluation index page
#    When I request to send new grades
#    Then the system asks if I want to resend

#  Scenario Registering new grades.
#    Given All grades on the system have been already sent
#    When I successfully import students evaluation for the "Cenarios" criterion...
#    Then The system is marked as having grades to send
