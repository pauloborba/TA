package steps






import geb.Page

import cucumber.api.PendingException
import pages.AddEvaluationPage
import pages.AddStudentsPage
import pages.CreateCriterionPage
import pages.ReportsPages.CreateReportsPage
import pages.StudentsReportPage
import steps.CriterionTestDataAndOperations
import steps.ReportsDataAndOperations
import ta.ReportController
import steps.AddStudentsTestDataAndOperations
import steps.StudentConsultTestDataAndOperations
import pages.ReportsPages.ShowReportsPage
import static steps.EvaluationDataAndOperations.*
import pages.ReportsPages.IndexReport




this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)




/**
 * #Victor Augusto Pereira Porciúncula - vapp
 feature relatorio de notas
 */






Given(~/^Eu crio os alunos "([^"]*)", "([^"]*)", "([^"]*)" de logins: "([^"]*)", "([^"]*)", "([^"]*)"  respectivamente/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg1, arg4)
    page.selectAddStudent()

    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg2, arg5)
    page.selectAddStudent()

    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg3, arg6)
    page.selectAddStudent()
}


And(~/^Eu crio os criterios "([^"]*)", "([^"]*)", "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg1)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg2)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg3)
}


And(~/^Eu avalio os criterios "([^"]*)", "([^"]*)" e "([^"]*)" dos alunos com logins "([^"]*)", "([^"]*)", "([^"]*)" como "([^"]*)", "([^"]*)", "([^"]*)", respectivamente para cada login repetido em cada criterio$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9 ->
    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg1)
    page.chooseStudentValue(arg4, arg7)
    page.chooseStudentValue(arg5, arg8)
    page.chooseStudentValue(arg6, arg9)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg2)
    page.chooseStudentValue(arg4, arg7)
    page.chooseStudentValue(arg5, arg8)
    page.chooseStudentValue(arg6, arg9)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg3)
    page.chooseStudentValue(arg4, arg7)
    page.chooseStudentValue(arg5, arg8)
    page.chooseStudentValue(arg6, arg9)
    page.selectAddEvaluation()
}

When(~/^Vejo o Relatório dos estudantes$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}
Then(~/^a linha do alunos de login "([^"]*)", "([^"]*)", "([^"]*)" serao das cores "([^"]*)", "([^"]*)", "([^"]*)" no Relatório de notas$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6 ->
    at StudentsReportPage
    assert page.isColor(arg1, arg4)
    assert page.isColor(arg2, arg5)
    assert page.isColor(arg3, arg6)
}






Given(~/^Eu crio o aluno "([^"]*)" de login "([^"]*)"$/) { String arg1, String arg2 ->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg1, arg2)
    page.selectAddStudent()
}
And(~/^Eu crio os criterios "([^"]*)", "([^"]*)", "([^"]*)" e "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg1)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg2)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg3)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg4)
}
And(~/^Eu adiciono os conceitos para "([^"]*)", "([^"]*)", "([^"]*)" e "([^"]*)" do aluno de login "([^"]*)" para "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6 ->
    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg1)
    page.chooseStudentValue(arg5, arg6)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg2)
    page.chooseStudentValue(arg5, arg6)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg3)
    page.chooseStudentValue(arg5, arg6)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg4)
    page.chooseStudentValue(arg5, arg6)
    page.selectAddEvaluation()
}
When(~/^Checo o Relatório dos estudantes$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}
Then(~/^a coluna "([^"]*)" do aluno de login "([^"]*)" será "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    to StudentsReportPage
    at StudentsReportPage
    assert page.isColumn(arg1, arg2, arg3)
}


Given(~/^Eu crio os alunos "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)" de logins: "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)"  respectivamente$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8 ->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg1, arg5)
    page.selectAddStudent()

    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg2, arg6)
    page.selectAddStudent()

    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg3, arg7)
    page.selectAddStudent()

    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg4, arg8)
    page.selectAddStudent()
}
And(~/^Eu crio os criterios "([^"]*)", "([^"]*)"$/) { String arg1, String arg2 ->
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg1)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg2)
}
And(~/^And Eu avalio os criterios "([^"]*)", e "([^"]*)" dos alunos com logins "([^"]*)", "([^"]*)", "([^"]*)" e "([^"]*)" como "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)" e "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", respectivamente para cada login$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14 ->
    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg1)
    page.chooseStudentValue(arg3, arg7)
    page.chooseStudentValue(arg4, arg8)
    page.chooseStudentValue(arg5, arg9)
    page.chooseStudentValue(arg6, arg10)
    page.selectAddEvaluation()

    to AddEvaluationPage
    at AddEvaluationPage
    page.chooseOrigin("Test")
    page.chooseCriterion(arg2)
    page.chooseStudentValue(arg3, arg11)
    page.chooseStudentValue(arg4, arg12)
    page.chooseStudentValue(arg5, arg13)
    page.chooseStudentValue(arg6, arg14)
    page.selectAddEvaluation()
}
When(~/^Vou para o Relatório de notas$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}

Then(~/^Os campos "([^"]*)", "([^"]*)", "([^"]*)" ,"([^"]*)", "([^"]*)" serao iguais a "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", respectivamente$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10 ->
    at StudentsReportPage
    assert page.isColumnGeneral(arg1, arg6)
    assert page.isColumnGeneral(arg2, arg7)
    assert page.isColumnGeneral(arg3, arg8)
    assert page.isColumnGeneral(arg4, arg9)
    assert page.isColumnGeneral(arg5, arg10)
}