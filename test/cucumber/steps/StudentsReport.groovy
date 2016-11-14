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

Given(~/^I create the students "([^"]*)", "([^"]*)", "([^"]*)" of logins "([^"]*)", "([^"]*)", "([^"]*)" respectively/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6->
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
And(~/^I create the criterions "([^"]*)", "([^"]*)", "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
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
And(~/^I evaluate the criterions "([^"]*)", "([^"]*)" e "([^"]*)" of the logins' students "([^"]*)", "([^"]*)", "([^"]*)" as "([^"]*)", "([^"]*)", "([^"]*)", respectively, for each login in each criterion$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9 ->
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
When(~/^I see the Students Report$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}
Then(~/^The row's color of the logins "([^"]*)", "([^"]*)", "([^"]*)" will be the colors "([^"]*)", "([^"]*)", "([^"]*)" on the Students Report$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6 ->
    at StudentsReportPage
    assert page.isLoginColor(arg1, arg4)
    assert page.isLoginColor(arg2, arg5)
    assert page.isLoginColor(arg3, arg6)
}



Given(~/^I create the student "([^"]*)" of login "([^"]*)"$/) { String arg1, String arg2 ->
    to AddStudentsPage
    at AddStudentsPage
    page.fillStudentDetails(arg1, arg2)
    page.selectAddStudent()
}
And(~/^I create the criterions "([^"]*)", "([^"]*)", "([^"]*)" and "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4 ->
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
And(~/^I evaluate the criterions "([^"]*)", "([^"]*)", "([^"]*)" and "([^"]*)" of login's student "([^"]*)" to "([^"]*)"$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6 ->
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
When(~/^I check the students report$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}
Then(~/^The column "([^"]*)" of the login's student "([^"]*)" will be "([^"]*)"$/) { String arg1, String arg2, String arg3 ->
    at StudentsReportPage
    assert page.isColumnLoginValue(arg1, arg2, arg3)
}



Given(~/^I create the students "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)" of logins "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", respectively/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8 ->
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
And(~/^I create the criterions "([^"]*)", "([^"]*)"$/) { String arg1, String arg2 ->
    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg1)

    to CreateCriterionPage
    at CreateCriterionPage
    page.createCriterion(arg2)
}
And(~/^I evaluate the criterions "([^"]*)" and "([^"]*)" of the logins' students "([^"]*)", "([^"]*)", "([^"]*)" and "([^"]*)" as "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)" and "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)", respectively for each login$/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14 ->
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
When(~/^I go to Students Report$/) { ->
    to StudentsReportPage
    at StudentsReportPage
}

Then(~/^The columns' numbers of "([^"]*)", "([^"]*)", "([^"]*)" ,"([^"]*)" and "([^"]*)" are going to be equal to "([^"]*)", "([^"]*)", "([^"]*)", "([^"]*)" and "([^"]*)", respectively/) { String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10 ->
    at StudentsReportPage
    assert page.isColumnNumber(arg1, arg6)
    assert page.isColumnNumber(arg2, arg7)
    assert page.isColumnNumber(arg3, arg8)
    assert page.isColumnNumber(arg4, arg9)
    assert page.isColumnNumber(arg5, arg10)
}