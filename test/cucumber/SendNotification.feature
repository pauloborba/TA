Feature: Send email with the criteria
    As as professor
    I want to send a email with all evaluation criteria and the ones evaluated so far
    So the students can know which is the criteria evaluated and the ones evaluated so far

  #GUI
  Scenario: Choose to whom send email with all criteria evaluated and the ones evaluated so far
  Given the professor is at Notification page
  And the professor wants to choose to whom send email with all criteria evaluated and the ones evaluated so far
  And the professor select the option "send email"
  When the professor select "John - j@cin.ufpe.br" from the addressee list
  Then the name "John" shows up in the tab "addressee"

  #GUI
  Scenario: send a email with all criteria evaluated and the ones evaluated so far
  Given the professor is at Notification page
  And the professor wants to send a email with all criteria evaluated and the ones evaluated so far
  And the professor select the option "send email"
  When the professor select the option "criteria evaluated and the evaluated so far"
  Then the criteria evaluated and the evaluated so far shows up in the screen
  And the professor select "send"

  #Controller
