package steps

import cucumber.api.PendingException
import pages.ImportarAlunosPage
import geb.Page
import pages.TurmaPage

/**
 * Created by wfeli on 12/06/2017.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

//PlanilhaAlunos planilha = PlanilhaFactory.getPlanilha('alunos.xls', 'addaluno')

Given(~/^I have the file "([^"]*)" which contains the students names and user names$/) { String path ->
     ImportAlunosDataAndOperations.assertFileExists(path)
}
And(~/^the file "([^"]*)" has the student "([^"]*)" with cin username "([^"]*)"$/) { String path, String name, String cinUsername ->
    ImportAlunosDataAndOperations.assertStudentIsInSpreadsheet(path, cinUsername)
}
And(~/^the system has the class "([^"]*)"$/) { String className ->
    ImportAlunosDataAndOperations.createAndSaveClass(className)
}
When(~/^I import the file "([^"]*)" for the "([^"]*)" class$/) { String path, String className ->
    ImportAlunosDataAndOperations.uploadSpreadsheet(path, className)
}
Then(~/^the system adds the student "([^"]*)" with cin username "([^"]*)" to the class "([^"]*)"$/) { String name, String cinUsername, String className ->
    ImportAlunosDataAndOperations.assertStudentsImported(name, className)
}

Given(~/^I have the class "([^"]*)"$/) { String className ->
    to TurmaPage
    ImportarAlunosPage.createAndSaveClass(className)
}
And(~/^I am at the "([^"]*)" page$/) { String page ->
    //ImportarAlunosPage.gotoImportarAlunos()
    to ImportarAlunosPage
}
And(~/^the class "([^"]*)" is registered in the system$/) { String className ->
}
When(~/^I choose the class "([^"]*)" and the file "([^"]*)"$/) { String className, String file ->
    ImportarAlunosPage.selectClass()
}
Then(~/^I can see the list of all students$/) { ->

}
