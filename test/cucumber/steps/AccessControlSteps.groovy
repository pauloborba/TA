/**
 * Created by ess on 29/11/15.
 */
package steps

import sun.rmi.runtime.Log
import ta.Student
import pages.LoginPage
import pages.StudentPages.CreateStudentPage
import ta.StudentController
import geb.Browser
import geb.binding.BindingUpdater



this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)


/////////////////////////controller tests////////////////////////////////////////
Given(~'That "([^"]*)" has a account with password "([^"]*)"') { String login, password ->
    Student student = new Student(login: login, password: password, name: login)
    student.save(failOnError: true)
//    Student.findOrSaveByLoginAndPassword(discipline, teacher, concepts)
}

Then(~'"([^"]*)" request to sign in with password "([^"]*)"') { String login, String password ->
    StudentController controller = new StudentController()
    Student student = new Student(login: login, password: password, name: login)
    controller.logar(student)

    assert controller.session != null
}

Then(~'"([^"]*)" have access to the system$') { String login ->
    assert session.student.login == login
}

Then(~'And the session is saved on his browser cookies$') {  ->
    assert session.student != null
}


Then(~'"([^"]*)" have no access to the system$') { String login ->
    assert session.student == null
}

/////////////////////////////////////
//
//Given(~'The system already has a discipline named "([^"]*)"$') { String discipline ->
//    RegisterNewDiscipline.createDiscipline(discipline, teacher, concepts)
//    assert Discipline.findByName(discipline) != null
//}
//
//Then(~'The discipline "([^"]*)" is not stored more than one time in the system$') { String discipline ->
//    assert Discipline.findByName(discipline) != null && !saved
//}
//
//////////////////////////GUI tests////////////////////////////////////////////////////
//
Given(~'That I am at login page$') { ->
    to LoginPage // checar se essa
    at LoginPage // p�gina existe mesmo
}

And(~'"([^"]*)" has a account with login "([^"]*)" and password "([^"]*)"') { String name, login, password ->
    to CreateStudentPage
    at CreateStudentPage

    page.fillStudentDetails(login, name, password)
    page.selectCreateStudent()

}

When(~'I write "([^"]*)" and "([^"]*)" on the login form$') { String login, String password ->
    to LoginPage
    at LoginPage

    page.fillLoginDetails(login, password)
}
And(~'I click Sign in button$') { ->
	page.selectLogin()
}

Then(~'Welcome to "([^"]*)" is displayed') { String name ->

}

//
//And(~'fill the form with name "([^"]*)" with teacher "([^"]*)" and concepts "([^"]*)"$') { String discipline, teacher,
//                                                                                           String[] concepts ->
//    page.fillDisciplineForm(discipline, teacher, concepts)
//    disciplineSaved = discipline
//}
//
//Then(~'A success message is displayed$') {
//    // ver como fazer isso
//}
//
//And(~'I am taken to the list of disciplines page where "([^"]*)" is listed as a discipline$') { String discipline ->
//    to DisciplinePage
//    at DisciplinePage
//    assert discipline == disciplineSaved
//}
//
//////////////////////////////////
//
//And(~'the system already has a discipline named "([^"]*)"$') { ->
//    //
//}
//
//Then(~'An error message is displayed$') { ->
//    // ver como fazer isso
//}
//
//And(~'I am taken to the list of disciplines page where "([^"]*)" is already listed as a discipline$') { String discipline ->
//    to DisciplinePage
//    at DisciplinePage
//    assert discipline == disciplineSaved
//}