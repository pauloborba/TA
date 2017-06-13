### Created by Avell at 13/06/2017
#Feature: Calculating student grades
#  As an administrator
#  I want to calculate grades of each student by criteria
#  So I can know who has its performance below the class average
#
#  #Controller Scenario
#Scenario: calculating student's grades
#  Given the class "ESS 2017.1" with the students with logins "gscci", "pglj2" and "jcss3" is registered in the system
#  And the system has the goal "falar no slack" , "usar o git" and "participar da aula"
#  And the student with login "gscci" has criteria "MA" at goal "falar no slack" , "MA" at goal "usar o git", "MPA" at goal "participar da aula"
#  And the student with login "pglj2" has criteria "MA" at goal "falar no slack" , "MPA" at goal "usar o git", "MPA" at goal "participar da aula"
#  And the student with login "jcss3" has criteria "MA" at goal "falar no slack" , "MPA" at goal "usar o git", "MANA" at goal "participar da aula"
#  When I ask to compute the grades of students in the class "ESS 2017.1"
#  Then the student with login "gscci" has the grade "8"
#  And student with login "pglj2" has the grade "6"
#  And student with login "jcss3" has the grade "3"
