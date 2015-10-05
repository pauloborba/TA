package steps

import ta.Student
import ta.EvaluationCriterion
import ta/grails-app/controllers/ta.FinalGradeController

#  Scenario: Calculating final grade
#    Given that every criteria has a grade for student "Eduardo"
#    When I request the system to register grades from "Eduardo"
#    Then the final grade is calculated based on the grades from each criteria
#    And the result is stored by the system

@ignore
Given(~'^that every criteria has a grade for student "([^"]*)"$') { String studentName ->
    assert !Student.findByName(studentName).evaluations.containsValue("XX")
    #Preciso confirmar que ele NÃO contém um critério vazio.
}
@ignore
When(~'^I request the system to register grades from "([^"]*)"$') { String studentName ->
    
}
@ignore
Then(~'^the final grade is calculated based on the grades from each criteria$') {->
    
}
@ignore
And(~'^the result is stored by the system$') {->
    
}
