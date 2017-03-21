Feature: Email New Grades
  As a teacher
  I want to be able to email New Grades
  to inform students of their Progress

  #-Created By Arthur Costa
  Scenario: Sending new grades
    Given There are grades from student “Arthur” with email “alpgc@cin.ufpe.br” evaluated as “MANA” in the “Cenarios” criteria on the system that were not yet sent
    And  There are grades from student “Arthur” with email “arthurlpgc@gmail.com” evaluated as “MPA” in the “Cenarios” criteria on the system that were not yet sent
    When I request to send new grades
    Then There are no new grades left to send to “arthurlpgc@gmail.com”
    Then There are no new grades left to send to “alpgc@cin.ufpe.br”

  Scenario: No new grades to send
    Given All grades on the system have been already sent
    And I am on the students index page
    When I request to send new grades
    Then the system asks if I want to resend

#  Cant be tested yet, need importing grades
#  Scenario Registering new grades.
#    Given All grades on the system have been already sent
#    When I successfully import students evaluation for the "Cenarios" criterion...
#    Then The system is marked as having grades to send
