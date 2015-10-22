<<<<<<< HEAD
//package steps
//
//import ta.Student
//import ta.EvaluationCriterion
//import ta.FinalGradeController
//
//def cont = new FinalGradeController()
//
///*  Scenario: Calculating final grade
//    Given that every criteria has a grade for student "Eduardo"
//    When I request the system to register grades from "Eduardo"
//    Then the final grade for "Eduardo" is calculated based on the grades from each criteria
//    And the result is stored by the system*/
//@ignore
//Given(~'^that every criteria has a grade for student "([^"]*)"$') { String studentName ->
//    student = Student.findByName(studentName)
//    assert !student.evaluations.containsValue("XX")
//    //Preciso confirmar que ele não contém nenhum critério vazio.
//}
//@ignore
//When(~'^I request the system to register grades from "([^"]*)"$') { String studentName ->
//    student = Student.findByName(studentName)
//    cont.params << student.evaluations
//    cont.create()
//    cont.save()
//    cont.response.reset()
//}
//@ignore
//Then(~'the final grade for "([^"]*)" is calculated based on the grades from each criteria$') { String studentName ->
//    student = Student.findByName(studentName)
//    cont.calculateFinalGrade(cont.params)
//    cont.save()
//    cont.response.reset()
//}
//@ignore
//Then(~'And the result is stored by the system$') { ->
//    cont.response.reset()
//}
//
///*  Scenario: Inability to calculate grade
//    Given that at least one criteria has no grades for student "Eduardo"
//    When I request the system to register grades from "Eduardo"
//    Then the final grade is not calculated*/
//@ignore
//Given(~'^that at least one criteria has no grades for student "([^"]*)"$') { String studentName ->
//    student = Student.findByName(studentName)
//    assert student.evaluations.containsValue("XX")
//    //Preciso confirmar que ele contém ao menos um critério vazio.
//}
//@ignore
//When(~'^I request the system to register grades from "([^"]*)"$') { String studentName ->
//    cont = new FinalGradeController()
//    student = Student.findByName(studentName)
//    cont.params << student.evaluations
//    cont.create()
//    cont.save()
//    cont.response.reset()
//}
//@ignore
//Then(~'^the final grade is not calculated$') { ->
//    cont.response.reset()
//    //Não sei o que poderia escrever aqui uma vez que não há uma ação
//}
=======
package steps

import ta.Student
import ta.EvaluationCriterion
import ta.FinalGradeController

def cont = new FinalGradeController

/*  Scenario: Calculating final grade
    Given that every criteria has a grade for student "Eduardo"
    When I request the system to register grades from "Eduardo"
    Then the final grade for "Eduardo" is calculated based on the grades from each criteria
    And the result is stored by the system*/
@ignore
Given(~'^that every criteria has a grade for student "([^"]*)"$') { String studentName ->
    student = Student.findByName(studentName)
    assert !student.evaluations.containsValue("XX")
    //Preciso confirmar que ele não contém nenhum critério vazio.
}
@ignore
When(~'^I request the system to register grades from "([^"]*)"$') { String studentName ->
    student = Student.findByName(studentName)
    cont.params << student.evaluations
    cont.create()
    cont.save()
    cont.response.reset()
}
@ignore
Then(~'the final grade for "([^"]*)" is calculated based on the grades from each criteria$') { String studentName ->
    student = Student.findByName(studentName)
    cont.calculateFinalGrade(cont.params)
    cont.save()
    cont.response.reset()
}
@ignore
Then(~'And the result is stored by the system$') { ->
    cont.response.reset()
}

/*  Scenario: Inability to calculate grade
    Given that at least one criteria has no grades for student "Eduardo"
    When I request the system to register grades from "Eduardo"
    Then the final grade is not calculated*/
@ignore
Given(~'^that at least one criteria has no grades for student "([^"]*)"$') { String studentName ->
    student = Student.findByName(studentName)
    assert student.evaluations.containsValue("XX")
    //Preciso confirmar que ele contém ao menos um critério vazio.
}
@ignore
When(~'^I request the system to register grades from "([^"]*)"$') { String studentName ->
    def cont = new FinalGradeController
    student = Student.findByName(studentName)
    cont.params << student.evaluations
    cont.create()
    cont.save()
    cont.response.reset()
}
@ignore
Then(~'^the final grade is not calculated$') { ->
    cont.response.reset()
    //Não sei o que poderia escrever aqui uma vez que não há uma ação
}
>>>>>>> 40a51b34da0e56c7a645b86e3fd8b165cc38330f
